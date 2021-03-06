package de.lendico.utils;

import de.lendico.model.LoanRequest;
import de.lendico.model.LoanResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static de.lendico.utils.Constants.HUNDRED;
import static de.lendico.utils.Constants.MONTHS_IN_YEAR;

/**
 * Class responsible for loan related calculations
 */
@Slf4j
public class CalculationUtils {

    /**
     * Method ot calculate loan amount
     *
     * @param loanRequest
     * @param listOfEmi
     * @return
     */
    public static List calculateEmiAmount(LoanRequest loanRequest, List listOfEmi) {

        if (loanRequest.getDuration() == 0) {
            return listOfEmi;
        }
        LoanResponse loanResponseNew = LoanResponse.builder()
                .initialOutstandingPrincipal(convertPrecession(loanRequest.getLoanAmount()))
                .build();

        double monthlyInterest = calculateInterest(loanRequest.getNominalRate(), loanResponseNew);

        Double emiAmount = calculateEmiAmount(loanRequest, loanResponseNew);

        Double principalComponent = calculatePrincipal(emiAmount, monthlyInterest, loanResponseNew);

        Double outStanding = calculateOutstanding(loanRequest.getLoanAmount(), principalComponent);

        loanResponseNew.setRemainingOutstandingPrincipal(convertPrecession(outStanding));

        Date emiDate = emiDate(loanRequest.getStartDate(), listOfEmi.isEmpty() ? false : true, loanResponseNew);

        listOfEmi.add(loanResponseNew);
        loanRequest.setStartDate(emiDate);
        loanRequest.setDuration(loanRequest.getDuration() - 1);
        loanRequest.setLoanAmount(outStanding);

        if (loanRequest.getDuration() > 0) {
            calculateEmiAmount(loanRequest, listOfEmi);
        }
        return listOfEmi;
    }

    /**
     * Method to format the date
     *
     * @param dateStr
     * @param addOrNot
     * @param loanResponse
     * @return
     */
    private static Date emiDate(Date dateStr, Boolean addOrNot, LoanResponse loanResponse) {
        try {
            if (!addOrNot) {
                loanResponse.setDate(dateStr);
                return loanResponse.getDate();
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateStr);
            calendar.add(Calendar.MONTH, 1);
            loanResponse.setDate(calendar.getTime());
            return loanResponse.getDate();
        } catch (Exception e) {
            log.info("exception : " + e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Problem occurred with date");
        }
    }

    /**
     * Method to calculate interest
     *
     * @param nominalRate
     * @param loanResponseNew
     * @return
     */
    private static Double calculateInterest(Double nominalRate, LoanResponse loanResponseNew) {
        loanResponseNew.setInterest(convertPrecession((convertPrecession(loanResponseNew.getInitialOutstandingPrincipal())
                * nominalRate / MONTHS_IN_YEAR) / HUNDRED));
        return loanResponseNew.getInterest();
    }

    /**
     * Method to convert the double value with precession #.##
     *
     * @param value
     * @return
     */
    private static Double convertPrecession(Double value) {
        return value != null ? BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_DOWN).doubleValue() : value;
    }

    /**
     * Method to calculate R value
     *
     * @param nominalRate
     * @return
     */
    private static Double calculateRValue(Double nominalRate) {
        return nominalRate / (MONTHS_IN_YEAR * HUNDRED);
    }

    /**
     * Method to calculate EMI amount
     *
     * @param loanRequest
     * @param loanResponseNew
     * @return
     */
    private static Double calculateEmiAmount(LoanRequest loanRequest, LoanResponse loanResponseNew) {
        Double r = calculateRValue(loanRequest.getNominalRate());
        loanResponseNew.setBorrowerPaymentAmount(convertPrecession((loanRequest.getLoanAmount() * r * (float) Math.pow(1 + r, loanRequest.getDuration()))
                / (float) (Math.pow(1 + r, loanRequest.getDuration()) - 1)));
        return loanResponseNew.getBorrowerPaymentAmount();
    }

    /**
     * Method to calculate principal amount
     *
     * @param emi
     * @param monthlyInterest
     * @param loanResponse
     * @return
     */
    private static Double calculatePrincipal(Double emi, Double monthlyInterest, LoanResponse loanResponse) {
        loanResponse.setPrincipal(convertPrecession(convertPrecession(emi) - convertPrecession(monthlyInterest)));
        return loanResponse.getPrincipal();
    }

    /**
     * Method calculate outstanding amount
     *
     * @param outStanding
     * @param principalComponent
     * @return
     */
    private static Double calculateOutstanding(Double outStanding, Double principalComponent) {
        return outStanding -
                principalComponent <= 0 ? 0 : outStanding - principalComponent;
    }
}

package utils;

import de.lendico.model.LoanRequest;

import org.junit.Test;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static de.lendico.utils.CalculationUtils.calculateEmiAmount;
import static org.junit.Assert.assertEquals;

public class CalculationUtilsTest {


    @Test
    public void calculateSuccessTest() {
        LoanRequest loanRequest = LoanRequest.builder().loanAmount(2000.0).duration(24L).nominalRate(5.0).startDate(new Date()).build();
        List list = new LinkedList<>();
        calculateEmiAmount(loanRequest, list);
        assertEquals(24, list.size());
    }

    @Test
    public void calculateFailureTest() {
        LoanRequest loanRequest = LoanRequest.builder().loanAmount(2000.0).duration(-24L).nominalRate(5.0).startDate(new Date()).build();
        List list = new LinkedList<>();
        calculateEmiAmount(loanRequest, list);
        assertEquals(1, list.size());
    }
}

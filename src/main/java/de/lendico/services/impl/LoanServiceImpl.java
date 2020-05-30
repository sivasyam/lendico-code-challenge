package de.lendico.services.impl;

import de.lendico.model.LoanRequest;
import de.lendico.model.LoanResponse;
import de.lendico.services.LoanService;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import static de.lendico.utils.CalculationUtils.processLoanCalculation;

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {

    /**
     *
     * @param loanRequest
     * @return
     */
    public List<LoanResponse> calculateLoan(LoanRequest loanRequest) {
        List loanEmiList = new LinkedList();
        return processLoanCalculation(loanRequest, loanEmiList);
        //return loanEmiList;
    }

}

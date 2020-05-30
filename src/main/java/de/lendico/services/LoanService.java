package de.lendico.services;

import de.lendico.model.LoanRequest;
import de.lendico.model.LoanResponse;

import java.util.List;

/**
 *
 */
public interface LoanService {
    List<LoanResponse> calculateLoan(LoanRequest loanRequest);
}

package de.lendico.contoller;

import de.lendico.model.LoanRequest;
import de.lendico.services.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Controller responsible for loan request processing
 */
@Slf4j
@RestController
@RequestMapping(path = "/")
@RequiredArgsConstructor
public class LoanController {

    @Autowired
    private LoanService loanService;

    /**
     * Method to process loan request
     *
     * @param loanRequest
     * @return
     */
    @PostMapping("generate-plan")
    public @ResponseBody
    ResponseEntity<?> generatePlan(@Valid @RequestBody LoanRequest loanRequest) {
        return new ResponseEntity<>(loanService.calculateLoan(loanRequest), HttpStatus.CREATED);
    }
}

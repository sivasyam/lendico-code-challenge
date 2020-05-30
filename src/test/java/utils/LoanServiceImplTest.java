package utils;

import de.lendico.model.LoanRequest;
import de.lendico.model.LoanResponse;
import de.lendico.services.LoanService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoanServiceImplTest {

    @Autowired
    private LoanService loanService;

    @Test
    public void calculateLoanSuccessTest() {
        LoanRequest loanRequest = LoanRequest.builder().loanAmount(2000.0).duration(24L).nominalRate(5.0).startDate(new Date()).build();
        List<LoanResponse> responseList =  loanService.calculateLoan(loanRequest);
        assertEquals(24, responseList.size());
    }

    @Test
    public void calculateLoanValueTest() throws ParseException {

        LoanRequest loanRequest = LoanRequest.builder().loanAmount(2000.0).duration(24L)
                .nominalRate(3.0).startDate(new Date()).build();
        List<LoanResponse> responseList =  loanService.calculateLoan(loanRequest);

        assertEquals(24, responseList.size());
    }
}

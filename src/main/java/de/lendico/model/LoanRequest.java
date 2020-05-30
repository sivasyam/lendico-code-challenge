package de.lendico.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LoanRequest {

    @NotNull(message = "Loan amount should not be empty")
    @Min(value = 1000, message = "Wrong Loan amount entered")
    @Positive
    private Double loanAmount;

    @NotNull(message = "Nominal Rate should not be empty")
    @Positive
    private Double nominalRate;

    @NotNull(message = "Duration should not be empty")
    @Positive
    private Long duration;

    @NotNull(message = "Start date should not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    private Date startDate;

    @JsonIgnore
    private String emi;

}

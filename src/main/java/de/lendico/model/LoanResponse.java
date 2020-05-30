package de.lendico.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class LoanResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "#0.00")
    @JsonProperty("borrowerPaymentAmount")
    private Double borrowerPaymentAmount;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    @JsonProperty("date")
    private Date date;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("initialOutstandingPrincipal")
    private Double initialOutstandingPrincipal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("interest")
    private Double interest;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("principal")
    private Double principal;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("remainingOutstandingPrincipal")
    private Double remainingOutstandingPrincipal;

}

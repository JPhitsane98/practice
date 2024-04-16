package finacial.calculator.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class StandardLoan {
    //Calculate monthly payments for loans based on principal, interest rate, and term.
    private BigDecimal LoanAmount;
    private BigDecimal interestRate;
    private BigDecimal finalAmount;
    private BigDecimal monthlyPayment;
    private DURATIONTYPE periodType;
    private int period;
}

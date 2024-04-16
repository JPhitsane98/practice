package finacial.calculator.service;

import finacial.calculator.pojo.StandardLoan;

import java.math.BigDecimal;

public interface LoanService {
    BigDecimal getMonthlyPayment(StandardLoan standardLoan);

    BigDecimal getInterestPaid(StandardLoan standardLoan);

    int getDuration(StandardLoan standardLoan);
}

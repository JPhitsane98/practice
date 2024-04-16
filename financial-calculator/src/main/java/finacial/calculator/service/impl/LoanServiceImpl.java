package finacial.calculator.service.impl;

import finacial.calculator.pojo.DURATIONTYPE;
import finacial.calculator.pojo.StandardLoan;
import finacial.calculator.service.LoanService;

import javax.ejb.Stateless;
import java.math.BigDecimal;
@Stateless
public class LoanServiceImpl implements LoanService {
    @Override
    public BigDecimal getMonthlyPayment(StandardLoan standardLoan) {
        BigDecimal payment = new BigDecimal("12.12");
        if(standardLoan != null) {
            int period = getPeriodInMonths(standardLoan.getPeriod(), standardLoan.getPeriodType());
        }
        return payment;
    }

    @Override
    public BigDecimal getInterestPaid(StandardLoan standardLoan) {
        BigDecimal interestPaid = new BigDecimal("12.12");
        return interestPaid;
    }

    @Override
    public int getDuration(StandardLoan standardLoan) {
        return 12;
    }

    private int getPeriodInMonths(int period, DURATIONTYPE periodType){
        switch (periodType){
            case MONTHS: return period;
            case YEARS: return (period * 12);
        }
        return 0;
    }

    private BigDecimal getInterestAmount(BigDecimal amount, BigDecimal interestRate){
        return new BigDecimal("12.12");
    }
}

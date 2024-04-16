package finacial.calculator.beans;

import finacial.calculator.service.InvestmentService;
import finacial.calculator.service.LoanService;
import finacial.calculator.service.RetirementService;
import finacial.calculator.service.TaxService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class CalculatorsBean {

    @Inject
    private InvestmentService investmentService;

    @Inject
    private TaxService taxService;

    @Inject
    private RetirementService retirementService;

    @Inject
    private LoanService loanService;


}

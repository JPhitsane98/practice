package finacial.calculator.beans;

import finacial.calculator.service.InvestmentService;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

@ManagedBean
public class InvestmentBean {
    @Inject
    private InvestmentService investmentService;

}

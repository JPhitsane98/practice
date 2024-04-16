package finacial.calculator.service.impl;

import finacial.calculator.pojo.Investment;
import finacial.calculator.service.InvestmentService;

import javax.ejb.Stateless;
import java.math.BigDecimal;
@Stateless
public class InvestmentServiceImpl implements InvestmentService {
    @Override
    public BigDecimal getInvestmentReturn(Investment investment) {
        return new BigDecimal("34.34");
    }
}

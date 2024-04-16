package finacial.calculator.service.impl;

import finacial.calculator.pojo.Retirement;
import finacial.calculator.service.RetirementService;

import javax.ejb.Stateless;
import java.math.BigDecimal;
@Stateless
public class RetirementServiceImpl implements RetirementService {
    @Override
    public BigDecimal getRetirementTotal(Retirement retirement) {
        return new BigDecimal("56.56");
    }
}

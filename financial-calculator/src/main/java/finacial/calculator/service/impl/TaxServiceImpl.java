package finacial.calculator.service.impl;

import finacial.calculator.pojo.IncomeTax;
import finacial.calculator.service.TaxService;

import javax.ejb.Stateless;
import java.math.BigDecimal;
@Stateless
public class TaxServiceImpl implements TaxService {
    @Override
    public BigDecimal getTaxableIncomeAmount(IncomeTax incomeTax) {
        return new BigDecimal("78.78");
    }
}

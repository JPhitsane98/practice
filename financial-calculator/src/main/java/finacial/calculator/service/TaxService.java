package finacial.calculator.service;

import finacial.calculator.pojo.IncomeTax;

import java.math.BigDecimal;

public interface TaxService {

    BigDecimal getTaxableIncomeAmount(IncomeTax incomeTax);
}

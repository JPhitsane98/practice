package finacial.calculator.service;

import finacial.calculator.pojo.Investment;

import java.math.BigDecimal;

public interface InvestmentService {

    BigDecimal getInvestmentReturn(Investment investment);
}

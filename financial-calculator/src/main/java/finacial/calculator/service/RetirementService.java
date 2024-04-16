package finacial.calculator.service;

import finacial.calculator.pojo.Retirement;

import java.math.BigDecimal;

public interface RetirementService {

    BigDecimal getRetirementTotal(Retirement retirement);
}

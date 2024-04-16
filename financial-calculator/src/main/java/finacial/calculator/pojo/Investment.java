package finacial.calculator.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Investment {
    // Calculate future value of investments with compound interest, considering initial investment, interest rate, and time.
    private BigDecimal initialAmount;
    private BigDecimal rate;
    private BigDecimal finalAmount;
    private DURATIONTYPE periodType;
    private int period;
}

package finacial.calculator.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Retirement {
    // Estimate how much you need to save for retirement based on desired retirement age and income.

    private BigDecimal income;
    private BigDecimal monthlyContribution;
    private Date dateOfBirth;
    private int retirementAge;
}

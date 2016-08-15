package ch03;

import java.math.BigDecimal;

public class Executive extends Employee {
    @Override
    public void raise(Number amount) {
        System.out.println("Executive got raise.");
    }

    public void raise(BigDecimal amount) {
        System.out.println("Executive got outlandish raise.");
    }
}

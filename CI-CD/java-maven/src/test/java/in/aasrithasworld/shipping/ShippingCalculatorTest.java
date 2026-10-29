package in.aasrithasworld.shipping;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {
    private final ShippingCalculator calculator = new ShippingCalculator();

    @Test
    void chargesShippingBelowThreshold() {
        assertEquals(50, calculator.shippingCharge(499));
    }

    @Test
    void givesFreeShippingAtThreshold() {
        assertEquals(0, calculator.shippingCharge(500));
    }

    @Test
    void givesFreeShippingAboveThreshold() {
        assertEquals(0, calculator.shippingCharge(750));
    }

    @Test
    void acceptsZeroOrderTotal() {
        assertEquals(50, calculator.shippingCharge(0));
    }

    @Test
    void rejectsNegativeOrderTotal() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.shippingCharge(-1));
    }
}

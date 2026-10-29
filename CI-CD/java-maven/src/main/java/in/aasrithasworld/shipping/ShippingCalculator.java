package in.aasrithasworld.shipping;

public class ShippingCalculator {
    // Orders of 500 rupees or more have free shipping.
    public int shippingCharge(int orderTotal) {
        if (orderTotal < 0) {
            throw new IllegalArgumentException("Order total cannot be negative.");
        }
        return orderTotal >= 500 ? 0 : 50;
    }
}

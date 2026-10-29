package in.aasrithasworld.shipping;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar shipping-quote-1.0.0.jar <order-total-in-rupees>");
            System.exit(1);
            return;
        }
        try {
            int orderTotal = Integer.parseInt(args[0]);
            int shipping = new ShippingCalculator().shippingCharge(orderTotal);
            System.out.println("Order total: Rs " + orderTotal);
            System.out.println("Shipping: Rs " + shipping);
        } catch (IllegalArgumentException exception) {
            System.err.println("Enter a non-negative whole number of rupees.");
            System.exit(1);
        }
    }
}

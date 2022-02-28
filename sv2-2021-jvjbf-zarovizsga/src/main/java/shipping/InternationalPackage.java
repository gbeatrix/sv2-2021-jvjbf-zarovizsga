package shipping;

public class InternationalPackage implements Transportable {
    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;
    private static final int SHIPPING_PRICE = 1200;
    private static final int KM_PRICE = 10;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    @Override
    public int calculateShippingPrice() {
        int shippingPrice = breakable ? 2 * SHIPPING_PRICE : SHIPPING_PRICE;
        shippingPrice += distance * KM_PRICE;
        return shippingPrice;
    }
}

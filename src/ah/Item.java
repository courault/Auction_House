package ah;

class Item {

    private final String name;
    private final int price;
    private final int minBid;
    public int commonPrice;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
        commonPrice = price * 2;
        minBid = (int) (Math.random() * (price / 10 - price / 20));
    }

    //Getters
    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getMinBid() {
        return minBid;
    }

    public int getCommonPrice() {
        return commonPrice;
    }
}

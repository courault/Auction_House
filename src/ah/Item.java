package ah;

class Item {
    private final String name;
    private final int price;
    
    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
    
    //Getters
    public int getPrice(){ return price;}
    public String getName(){return name;}
}

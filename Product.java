public class Product {
    //Attributes that will be used in later search methods
    private String name;
    private String description;
    private double price;

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //Getters and setters for the product
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if(!name.isEmpty())
         this.name = name;
    }

    public void setCost(double cost) {
        if(cost > 0)
            this.price = cost;
    }
}

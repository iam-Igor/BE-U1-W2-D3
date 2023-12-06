package entities;

import java.util.Random;

public class Product {

    public long id;

    public String name;

    public String category;
    public double price;

    Random rndm = new Random();

    public Product(String name, String category, double price) {
        this.id = rndm.nextInt(0, 100000);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

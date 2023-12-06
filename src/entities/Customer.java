package entities;

import java.util.Random;

public class Customer {

    Random rndm = new Random();
    private long id;
    private String name;
    private int tier;


    public Customer(String name, int tier) {
        this.id = rndm.nextInt(0, 1000);
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}

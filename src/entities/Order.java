package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {

    Random rndm = new Random();
    private long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> productList;
    private Customer customer;


    public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> productList, Customer customer) {
        this.id = rndm.nextInt(0, 10000);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.productList = productList;
        this.customer = customer;
    }

    public Random getRndm() {
        return rndm;
    }

    public void setRndm(Random rndm) {
        this.rndm = rndm;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

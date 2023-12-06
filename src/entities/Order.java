package entities;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private long id;
    private String status;
    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private List<Product> productList;

    private Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> productList, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.productList = productList;
        this.customer = customer;
    }


}

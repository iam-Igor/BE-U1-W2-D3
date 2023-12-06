package Es1;

import entities.Customer;
import entities.Order;
import entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate tomorrow = now.plusDays(1);

        List<Product> mainList = new ArrayList<>();


        Product book1 = new Product("Topolino", "Books", 25.99);
        Product book2 = new Product("Zio Paperone", "Books", 110.99);
        Product book3 = new Product("Pippo", "Books", 10.12);
        Product book4 = new Product("Paperino", "Books", 220.50);

        mainList.add(book1);
        mainList.add(book2);
        mainList.add(book3);
        mainList.add(book4);


        Product toy1 = new Product("Puzzle", "Baby", 110.15);
        Product toy2 = new Product("Doll", "Baby", 11.99);
        Product toy3 = new Product("Bear", "Baby", 150.15);

        mainList.add(toy1);
        mainList.add(toy2);
        mainList.add(toy3);


        Product boy1 = new Product("Water Gun", "Boys", 200.00);
        Product boy2 = new Product("PlayStation 5", "Boys", 350.00);
        Product boy3 = new Product("Soccer ball", "Boys", 20.99);

        mainList.add(boy1);
        mainList.add(boy2);
        mainList.add(boy3);


        //Ottenere una lista di prodotti che appartengono alla categoria «Books» ed hanno un prezzo > 100

        Predicate<Product> isBookCategory = product -> product.category == "Books";
        Predicate<Product> isPriceLessThan100 = product -> product.price < 100;
        List<String> booksInfo = mainList.stream()
                .filter(isBookCategory.and(isPriceLessThan100))
                .map(book -> book.getName() + " " + book.getPrice()).toList();
        log.info("Lista dei libri con prezzo inferiore a 100: " + booksInfo);


        //Ottenere una lista di ordini con prodotti che appartengono alla categoria «Baby»

        Customer mario = new Customer("Mario", 2);
        List<Order> marioList = new ArrayList<>();

        Order order1 = new Order("Pending", now, tomorrow, mainList, mario);
        marioList.add(order1);
        Predicate<Product> isBabyCategory = product -> product.category == "Baby";

        List<String> babyCategory = marioList.stream()
                .flatMap(ord -> ord.getProductList().stream().filter(isBabyCategory))
                .map(Product::getName)
                .collect(Collectors.toList());
        log.info("Ordini appartenenti alla categoria Baby:" + babyCategory);


        //Ottenere una lista di prodotti che appartengono alla categoria «Boys» ed applicare 10% di sconto al loro prezzo
        Predicate<Product> isBoyCategory = product -> product.category == "Boys";
        List<String> boyCategory = mainList.stream().filter(isBoyCategory).map(boy -> boy.getName() + " " + (boy.getPrice() * 0.90)).toList();

        log.info("Prodotti appartenenti alla categoria Boy con il 10% di sconto: " + boyCategory);


        //Ottenere una lista di prodotti ordinati da clienti di livello (tier) 2 tra l’01-Feb-2021 e l’01-Apr-2021

        List<Product> orders = new ArrayList<>();
        orders.add(book1);
        orders.add(toy1);
        orders.add(boy2);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        LocalDate orderDate = LocalDate.of(2021, 03, 25);
        LocalDate shippingDate = orderDate.plusDays(5);

        Customer luigi = new Customer("Luigi", 1);
        Customer wario = new Customer("Wario", 2);

        List<Order> orderList = new ArrayList<>();

        Order order2 = new Order("Preparing", now, tomorrow, orders, luigi);
        Order order3 = new Order("Shipped", orderDate, shippingDate, orders, wario);

        orderList.add(order2);
        orderList.add(order3);

        Predicate<Order> isDateRight = order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate);
        Predicate<Customer> isTierlevel2 = customer -> customer.getTier() == 2;


        List<String> filteredOrders = orderList.stream().filter(isDateRight).map(ord -> ord.getProductList().toString()).toList();

        log.info(filteredOrders.toString());
    }
}
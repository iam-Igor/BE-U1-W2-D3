import entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

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
        mainList.stream().filter(isBookCategory.and(isPriceLessThan100)).forEach(System.out::println);
    }
}
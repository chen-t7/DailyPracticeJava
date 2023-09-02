package book;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2023 -09 -02
 * Time: 15:20
 */
public class Book {
    private String name;
    private String author;
    private String type;
    private double price;
    private boolean isBorrowed = false;

    Book(String name, String author, String type, double price) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.price = price;
    }
}

package book;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -14
 * Time: 23:15
 */
public class Book {
    private String name;
    private String author;
    private boolean isBorrowed;
    private String type;
    private int price;

    public Book(String name, String anthor, String type, int price) {
        this.name = name;
        this.author = anthor;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}

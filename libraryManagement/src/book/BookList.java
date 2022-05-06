package book;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -14
 * Time: 23:19
 */
public class BookList {
    private Book[] books = new Book[10];
    private int usedSize;

    public BookList() {
        books[0] = new Book("《三国演义》", "罗贯中", "小说", 34);
        books[1] = new Book("《西游记》", "吴承恩", "小说", 35);
        books[2] = new Book("《红楼梦》", "曹雪芹", "小说", 36);
        this.usedSize = 3;
    }


    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getPos(int pos) {
        return this.books[pos];
    }

    public void setBook(int pos, Book book) {
        this.books[pos] = book;
    }

}


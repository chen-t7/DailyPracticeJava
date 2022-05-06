package operation;
import book.*;


import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -16
 * Time: 22:54
 */
public class BorrowOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("请输入你要借阅的书籍名称");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(true);
                System.out.println(book);
                System.out.println("你已成功借阅书籍");
                return;
            }
        }
        System.out.println("该图书馆没有你要借阅的书籍");
    }
}

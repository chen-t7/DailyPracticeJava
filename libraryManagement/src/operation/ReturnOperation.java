package operation;

import book.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -16
 * Time: 22:55
 */
public class ReturnOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("请输入你要归还的书籍名称");
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if (book.getName().equals(name)) {
                book.setBorrowed(false);
                System.out.println("你已成功归还书籍");
                return;
            }
        }
        System.out.println("没有你要归还的这本书");
    }
}

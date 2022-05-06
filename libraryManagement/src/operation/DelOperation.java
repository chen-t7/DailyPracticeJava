package operation;

import book.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:47
 */
public class DelOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入你要删除的书籍名称");
        String name = scanner.nextLine();
        int index = 0;
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            if (book.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if (index >= bookList.getUsedSize()) {
            System.out.println("该图书馆没有你要删除的书籍");
            return;
        }
        while (index < bookList.getUsedSize()-1){
            bookList.setBook(index, bookList.getPos(index+1));
            index++;
        }

        bookList.setBook(bookList.getUsedSize(), null);
        bookList.setUsedSize(bookList.getUsedSize()-1);
        System.out.println("已成功删除该本书");
    }
}

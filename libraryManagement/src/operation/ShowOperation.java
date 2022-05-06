package operation;

import book.*;


/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -16
 * Time: 22:54
 */
public class ShowOperation implements IoOperation{
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getPos(i);
            System.out.println(book);
        }
    }
}

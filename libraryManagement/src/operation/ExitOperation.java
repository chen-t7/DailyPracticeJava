package operation;

import book.*;


/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -16
 * Time: 22:55
 */
public class ExitOperation implements IoOperation{
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}

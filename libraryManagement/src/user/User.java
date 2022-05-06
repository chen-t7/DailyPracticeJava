package user;

import book.BookList;
import operation.IoOperation;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:51
 */
abstract public class User {
    protected String name;
    protected IoOperation[] ioOperations;

    public User(String name) {
        this.name = name;
    }

    abstract public int menu();
    abstract public void doWork(int choice, BookList bookList);
}

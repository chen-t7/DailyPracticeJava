package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:46
 */
public interface IoOperation {
    Scanner scanner = new Scanner(System.in);
    void work(BookList bookList);
}



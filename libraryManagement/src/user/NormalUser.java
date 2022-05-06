package user;

import book.BookList;
import operation.*;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -15
 * Time: 0:52
 */
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        ioOperations = new IoOperation[] {
                new ExitOperation(),
                new BorrowOperation(),
                new ReturnOperation(),
                new FindOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("========普通菜单========");
        System.out.println("hello " + this.name + " 欢迎来到这里！");
        System.out.println("1.借阅图书");
        System.out.println("2.归还图书");
        System.out.println("3.查找图书");
        System.out.println("0.退出系统");
        System.out.println("请选择");
        System.out.println("======================");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

    @Override
    public void doWork(int choice, BookList bookList) {
        ioOperations[choice].work(bookList);
    }
}

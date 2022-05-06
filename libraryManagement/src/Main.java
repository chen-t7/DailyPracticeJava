import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -04 -14
 * Time: 23:09
 */
public class Main {
    public static User login() {
        System.out.println("请输入你的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：0-管理员  1-普通用户");
        int choice = scanner.nextInt();
        if (choice == 0) {
            AdminUser adminUser = new AdminUser(name);
            return adminUser;
        } else{
            NormalUser normalUser = new NormalUser(name);
            return normalUser;
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            user.doWork(choice, bookList);
        }
    }
}

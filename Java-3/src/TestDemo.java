import java.io.Console;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -06 -07
 * Time: 22:35
 */
public class TestDemo {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("......");
            return ;
        }
        String username = console.readLine();
        char[] passwd = console.readPassword();
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -17
 * Time: 12:44
 */
class NameException extends RuntimeException{
    public NameException(String message) {
        super(message);
    }
}

class PassworddException extends RuntimeException{
    public PassworddException(String message) {
        super(message);
    }
}
public class TestDemo2 {
    public static void main(String[] args) {
        int i = 0;
        while (i != 10) {
            try {
                if (i < 10){
                    throw new Exception("i的值为" + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("尝试连接网络...第" + i + "次");
                i++;
            }
        }
        System.out.println("终于有网了，程序继续执行！");
    }

    public static void main2(String[] args) {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally执行了");
        }
    }

    private static final String userName = "admin";
    private static final String password = "123456";

    public static void login(String name, String password) throws NameException, PassworddException{
        if (!TestDemo2.userName.equals(name)) {
            throw new NameException("用户名错误！");
        }
        if (!TestDemo2.password.equals(password)) {
            throw new NameException("密码错误！");
        }
    }
    public static void main1(String[] args) {
        try {
            login("admin", "1234561");
        } catch (NameException e){
            System.out.println("用户名错误！！");
        } catch (PassworddException e) {
            System.out.println("密码错误！！");
        } finally {
            System.out.println("finally执行了！！");
        }
    }
}

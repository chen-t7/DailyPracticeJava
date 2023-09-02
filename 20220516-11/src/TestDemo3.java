import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -17
 * Time: 12:48
 */
//一般继承Exception的为受查异常，必须显示处理；如果不显式处理, 编译无法通过
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
//继承RuntimeException的异常类为非受查异常
class MyException2 extends RuntimeException {
    public MyException2(String message) {
        super(message);
    }
}

public class TestDemo3 {
    public static void main5(String[] args) throws FileNotFoundException {
        System.out.println(readFile());
    }
    //FileNotFoundException是受查异常，不显示处理无法编译通过
    public static String readFile() throws FileNotFoundException {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }
    public static void func3(int x) {
        try {
            if (x == 0) {
                throw new MyException2("hahaha");
            }
        } catch (MyException2 e) {
            e.printStackTrace();
        }
    }

    public static void func4(int x) {
        if (x == 0) {
            throw new MyException2("MyException2");
        }
    }
    public static void main2(String[] args) {
        func3(0);
        func4(0);
    }

    public static void func1(int x) {
        try {
            if (x == 0) {
                throw new MyException("hahaha");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    public static void func2(int x) throws MyException {
        if (x == 0) {
            throw new MyException("haihaihai");
        }
    }

    public static void main1(String[] args) throws MyException {
        func1(0);
        func2(0);
    }
}

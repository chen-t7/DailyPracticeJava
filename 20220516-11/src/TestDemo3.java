/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -17
 * Time: 12:48
 */
//受查异常
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
//非受查异常
class MyException2 extends RuntimeException {
    public MyException2(String message) {
        super(message);
    }
}

public class TestDemo3 {
    public static void func3(int x) throws MyException2{
        try {
            if (x == 0) {
                throw new MyException2("hahaha");
            }
        } catch (MyException2 e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        func3(0);
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

    public static void func2(int x) throws MyException{
        if (x == 0) {
            throw new MyException("haihaihai");
        }
    }

    public static void main1(String[] args) throws MyException {
        func1(0);
        func2(0);
    }
}

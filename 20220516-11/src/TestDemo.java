import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -05 -16
 * Time: 19:43
 */
class  Person implements Cloneable {
    public int id;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {


    public static void main(String[] args) {
        System.out.println(readFile());
    }

    public static String readFile() {
        // 尝试打开文件, 并读其中的一行.
        File file = new File("d:/test.txt");
        // 使用文件对象构造 Scanner 对象.
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sc.nextLine();
    }

    public static void func(int n) throws ArithmeticException{
        try {
            System.out.println(10/n);
        } catch (ArithmeticException e) {
            System.out.println("func");
            e.printStackTrace();
        }
        //System.out.println(10/n);

    }

    public static int func2() {
        int a = 10;
        try {
            //System.out.println();
            return a;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            //不管抛出异常没有，finally都会被执行
            //所以尽量避免在finally中写return
            return 20;
        }
    }

    public  static void func3(int x) throws RuntimeException{
        if (x == 0) {
            //throw用来抛出自定义的异常
            //System.out.println(10/x);
            throw new ArithmeticException(" / by 0");
        }
    }

    public static void main14(String[] args) {
        try {
            func3(0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        /*
        finally {
            System.out.println("finally");
        }
         */
        System.out.println("code");
    }

    public static void main13(String[] args) {
        System.out.println(func2());
    }

    public static void main12(String[] args) {
        try {
            func(0);
        } catch (ArithmeticException e) {
            System.out.println("main");
            e.printStackTrace();
        }
        System.out.println("scsad");
    }

    public static void main10(String[] args) {
        //将 Scanner 对象在 try 的 ( ) 中创建, 就能保证在 try 执行完毕后自动调用 Scanner的 close 方法
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(10 / n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常，可能0作为了除数");
        } finally {
            //一般用作 资源的关闭
            System.out.printf("finally执行了");
        }
    }

    public static void main9(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int n = scanner.nextInt();
            System.out.println(10/n);
        } catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println("输入有误！");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算术异常，可能0作为了除数");
        } finally {
            //一般用作 资源的关闭
            scanner.close();
            System.out.println("finally执行了");
        }
    }

    public static void main8(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[5]);//当这里抛出异常后，后面的代码不会被执行
            System.out.println("hhhhh");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界异常");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个索引越界异常");
        }
        System.out.println("hello！！！");
    }

    public static void main7(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[5]);//当这里抛出异常后，后面的代码不会被执行
            System.out.println("hhhhh");
        } catch (Exception e) { //最好不要使用Exception。Exception 类是所有异常类的父类. 因此可以用这个类型表示捕捉所有异常.
            //catch 进行类型匹配的时候, 不光会匹配相同类型的异常对象, 也会捕捉目标异常类型的子类对象
            e.printStackTrace();
            System.out.println("捕捉到了一个异常");
        }
        System.out.println("hello！！！");
    }

    public static void main6(String[] args) {
        int[] array = {1,2,3};
        try {
            array = null;
            System.out.println(array[5]);
            System.out.println("hhhhh");
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) { //处理异常
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界或者空指针异常");
        }
        System.out.println("hello！！！");
    }

    public static void main5(String[] args) {
        int[] array = {1,2,3};
        try {
            array = null;
            System.out.println(array[5]);
            System.out.println("hhhhh");
        } catch (ArrayIndexOutOfBoundsException e) { //处理异常
            e.printStackTrace();
            System.out.println("捕捉到了一个数组越界异常");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("捕捉到了一个空指针异常异常");
        }
        System.out.println("hello！！！");
    }

    public static void main4(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[5]);//当这里抛出异常后，后面的代码不会被执行
            System.out.println("hhhhh");
        } catch (ArrayIndexOutOfBoundsException e) { //处理异常
            e.printStackTrace();//打印出现异常代码的调用栈
            System.out.println("捕捉到了一个数组越界异常");
        }
        System.out.println("hello！！！");
    }

    public static void main3(String[] args) {
        int[] array = {1,2,3};
        System.out.println(array[5]);//当这里抛出异常后，后面的代码不会被执行
        System.out.println("其他的代码");
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(n);
    }

    public static void main1(String[] args) {
        Person person = new Person();
        try {
            Person person1 = (Person)person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


        System.out.println(10/0);

        String str = null;
        System.out.println(str.length());

        int[] array = {1,2,3,4};
        System.out.println(array[9]);

    }
}

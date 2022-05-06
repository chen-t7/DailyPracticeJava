import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: chen
 * Date: 2022 -03 -07
 * Time: 23:34
 */

class Person {
    //字段，也叫属性，也叫成员变量--》定义在类的内部，方法的外部，是一个成员变量
    //成员变量分类：1.普通成员变量--》通过引用访问，普通成员是属于对象的；2.静态成员变量--》通过类名访问，不依赖于对象
    private String name;
    //该变量被private修饰后，只能在当前类中访问
    public int age = 19;
    //静态成员变量，也叫类变量，存在方法区（存储
    public static int count = 10;

    {
        this.age = 100;
        System.out.println("实例代码块！！");
    }

    //new一个对象时，先调用静态代码块，再是实例代码块，然后再调用构造方法，静态代码块只会被执行一次
    static {
        count = 99;
        System.out.println("静态代码块！！");
    }
    public Person() {
        this("chen");//代表调用带有一个参数的构造方法
        //this("chen", 19);
        System.out.println("Person():不带参数的构造方法");
    }

    public Person(String name) {
        this.name = name;//this代表当前对象的引用
        System.out.println("Person(String):带String类型参数的构造方法");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int):带两个参数的构造方法");
    }
    public String getName() {
        return name;
    }

    /*
    public void setName(String myName) {
        name = myName;
    }
     */
    /*
    public void setName(String name) {
        this.name = name;//局部变量优先使用，如果传入的参数名和成员变量名称相同时，会冲突，所以要用this.区分
    }
     */

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public static int getCount() {
        return count;
    }

    //成员方法->行为
    //成员方法分类：1.普通成员方法--》通过引用访问；2.静态成员方法
    public void eat() {
        //普通方法中不能定义静态变量:
        // 1.static定义的变量是类变量，属于类的
        // 2.eat方法的调用，需要对应的引用来调用。但是如果可以定义static的变量，Person就可以调用
        //static int size = 0;
        System.out.println(name + "正在吃饭");
    }

    public void sleep() {
        System.out.println(name + "正在睡觉");
    }

    public void print() {
        //普通方法可以调用静态方法，因为静态方法不需要依赖于对象
        //staticFunc();
        this.eat();
        System.out.println("姓名:" + name + " " + "年龄:" + age);
    }

    @Override//重写：检查的作业
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void staticFunc() {
        //静态的成员变量是不可以在方法中定义的
        //static int n = 0;
        //静态的方法中不能调用普通方法，因为静态的方法不依赖于对象，但是普通方法依赖对象
        //print();
        System.out.println("static:func()");
    }

}

class Calculator {
    private int num1;
    private int num2;

    Calculator() {
        this.num1 = 1;
        this.num2 = 1;
    }

    Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return this.num1;
    }

    public int getNum2(int num2) {
        return this.num2;
    }

    public int add(){
        return this.num1 + this.num2;
    }

    public int sub(){
        return this.num1 - this.num2;
    }

    public int mul(){
        return this.num1 * this.num2;
    }

    public double div(){
        return this.num1*1.0 / this.num2;
    }
}
class Myvalue {
    public int val;

}
public class TestDemo {
    public static void swap(Myvalue myV1, Myvalue myV2) {
        int tmp = myV1.val;
        myV1.val = myV2.val;
        myV2.val = tmp;
    }
    public static void main(String[] args) {
        Myvalue myValue1 = new Myvalue();
        myValue1.val = 10;

        Myvalue myValue2 = new Myvalue();
        myValue2.val = 20;
        swap(myValue1, myValue2);

        System.out.println(myValue1.val + " " + myValue2.val);
    }
    public static void main13(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(10);
        calculator.setNum2(2);
        System.out.println(calculator.add());
    }
    public static void main12(String[] args) {
        new Person().eat();//匿名对象，一次性的，只能在创建的时候使用
        new Person().print();
        System.out.println(new Person());
        System.out.println("===============");
        Person person = new Person();
        person.eat();
        person.print();
        System.out.println(person);
    }
    public static void main11(String[] args) {
        //静态代码块不用实例化对象都能被执行，并且只被执行一次，类加载的时候执行
        System.out.println(Person.count);
    }
    public static void main10(String[] args) {
        //new一个对象时，先调用静态代码块，再是实例代码块，然后再调用构造方法，静态代码块只会被执行一次
        Person person = new Person();
        System.out.println("============");
        Person person2 = new Person();
    }
    public static void main9(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.out.println("==============");
        Person person1 = new Person("chen");
        System.out.println("==============");
        Person person3 = new Person("chen", 11);
    }
    public static void main8(String[] args) {
        Person person = new Person();
        //person.name = "chen";
        person.setName("chen");
        person.age = 100;
        System.out.println(person.getName());
    }

    public final int SIZE = 10;//被final修饰的叫常量，也属于对象。 被final修饰，后续不可更改
    public static final int COUNT = 99;//静态的常量，属于类本身，只有一份 被final修饰，后续不可更
    //一个对象存储在哪里，和这个对象是否被final修饰无关
    Person person = new Person();

    public static void main7(String[] args) {
        TestDemo testDemo = new TestDemo();
    }
    public static void main6(String[] args) {
        Person person = null;//这个引用不指向任何对象
        Person person1 = person;//代表person2这个引用 指向person引用所指向的对象
        person = new Person();//一个引用不可以同时指向多个对象，只要看最后一次的指向
        //引用一定是在栈上吗？不一定
    }
    public static void main5(String[] args) {
        Person person1 = new Person();
        //person1.print();
    }

    public static void main4(String[] args) {
        Person person1 = new Person();
        person1.count++;//这里会报警告是因为静态成员变量不属于某个对象，想访问的时候直接使用类名访问，即Person.count++
        System.out.println(person1.count);
        System.out.println("==================");

        Person person2 = new Person();
        person2.count++;
        System.out.println(person2.count);

        Person.staticFunc();
    }

    public static void main3(String[] args) {
        Person person1 = new Person();
        person1.age++;
        System.out.println(person1.age);
        System.out.println("==================");

        Person person2 = new Person();
        person2.age++;
        System.out.println(person2.age);
    }

    public static void main2(String[] args) {
        Person person = new Person();
        //person.name = "chenyu";
        person.age = 999;
       //System.out.println(person.name);
        System.out.println(person.age);

        Person person2 = new Person();
        //System.out.println(person2.name);
        System.out.println(person2.age);

        person.eat();
    }
    public static void main1(String[] args) {
        //Person p = null;
        Person person = new Person();
        //成员变量没有赋初值时，打印时打印的是默认值
       //System.out.println(person.name);
        System.out.println(person.age);
    }
}

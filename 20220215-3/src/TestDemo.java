import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -02 -15
 * Time: 22:35
 */
public class TestDemo {
    public static void main(String[] args) {
        //7. 计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
        double sum = 0.0;
        for (int i = 1; i <= 100 ; i++) {
            if (i % 2 == 0) {
                sum -= 1.0/i;//分子必须是1.0  如果是1除法的结果是整数，1/i就是0了
            } else {
                sum += 1.0/i;
            }
        }
        System.out.println(sum);

        //8. 编写程序数一下 1到 100 的所有整数中出现多少个数字9。
        int num = 0;
        for (int i = 1; i <=100 ; i++) {
            if (i / 10 == 9) {
                num++;
            }
            if (i % 10 == 9) {
                num++;
            }
        }
        System.out.println(num);
    }
    public static void main17(String[] args) {
        //1. 根据年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄 ：");
        int age = sc.nextInt();
        if (age >= 0 && age <= 18) {
            System.out.println("你是少年");
        } else if (age >= 19 && age <= 28) {
            System.out.println("你是青年");
        } else if (age >= 29 && age <= 55) {
            System.out.println("你是中年");
        } else {
            System.out.println("你是老年");
        }

        //2. 判定一个数字是否是素数
        int num = sc.nextInt();
        int i = 2;
        while (i <= Math.sqrt(num)) {
            if (num % i == 0) {
                System.out.println(num + "不是素数");
                break;
            }
            i++;
        }
        if (i > Math.sqrt(num)) {
            System.out.println(num + "是素数");
        }

        //3. 打印 1 - 100 之间所有的素数
        for (int j = 1; j <= 100; j++) {
            int k = 2;
            while (k <= j/2) {
                if (j % k == 0) {
                    break;
                }
                k++;
            }
            if (k > j/2) {
                System.out.println(j + "是素数");
            }
        }

        //4. 输出 1000 - 2000 之间所有的闰年
        for (int n = 1000; n <= 2000; n++) {
            if ((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0)) {
                System.out.println(n + "是闰年");
            }
        }

        //5. 输出乘法口诀表
        for (int j = 1; j <= 9; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print(j + "*" + k + "=" + j*k + " ");
            }
            System.out.println(6);
        }

        //6. 求两个正整数的最大公约数
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int min = num1 > num2 ? num2 : num1;
        int numMax = 1;
        for (int j = 2; j <= min; j++) {
            if (num1 % j == 0 && num2 % j == 0) {
                numMax = j;
            }
        }
        System.out.println("最大公约数是" + numMax);

        //6. 求两个正整数的最大公约数---辗转相除
        int num3 = sc.nextInt();
        int num4 = sc.nextInt();
        int max = num3 > num4 ? num3 : num4;
        int c = max % min;
        while (c != 0) {
            max = min;
            min = c;
            c = max % min;
        }
        System.out.println("最大公约数是" + min);

        sc.close();
    }
    //猜数字游戏
    public static void main16(String[] args) {
        Random random = new Random(11111);
        int rand = random.nextInt(100);//[0~100)
        System.out.println("rand " + rand);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你要要猜的数字：");
            int n = sc.nextInt();
            if (n < rand) {
                System.out.println("你猜小了");
            }else if (n > rand){
                System.out.println("你猜大了");
            } else {
                System.out.println("你猜对了");
                break;
            }
        }
        sc.close();
    }
    //使用scanner循环读取字符串/整数/浮点数
    public static void main15(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        int num = 0;
        while (sc.hasNextDouble()) {
            double tmp = sc.nextDouble();
            sum += tmp;
            num++;
        }
        System.out.println("sum = " + sum);
        System.out.println("avg = " + sum / num);
        sc.close();
    }
    public static void main14(String[] args) {
        System.out.println("hello world");
        int a = 10;
        System.out.printf("a = %d\n", a);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();//先读INT会把输入的回车当成字符串读入
        System.out.println("请输入你的年纪：");
        int age = sc.nextInt();//nextINt和nextLine混用时，不要把nextInt放在nextLine的前面（JAVA的缺陷
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名：" + name + "\n" + "年龄 ： " + age + "\n" + "工资：" + salary);
        sc.close();
    }

    public static void main13(String[] args) {
        int i = 0;
        int sum = 0;
        //先执行循环再判断，至少会被执行一次
        do {
            sum = sum + i;
            i++;
        }while (i <= 10);
        System.out.println(sum);
    }
    //n的阶乘之和
    public static void main12(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 5; ++i) {
            int n = 1;
            for (int j = 1; j <= i; j++) {
                n *= j;
            }
            sum += n;
        }
        System.out.println(sum);
    }
    //n的阶乘
    public static void main11(String[] args) {
        int n = 1;
        for (int i = 1; i <= 5; ++i) {
            n *= i;
        }
        System.out.println(n);
    }
    ///找到1到100之间既能被3整除也能被5整除的数字
    public static void main10(String[] args) {
        int n = 1;
        while (n <= 100) {
            if (n % 3 != 0 || n % 5 != 0) {
                n++;
                continue;
            }
            System.out.println(n);
            n++;
        }
    }
    public static void main9(String[] args) {
        int n = 1;
        while (n <= 100) {
            if (n % 3 == 0 && n % 5 == 0) {
                System.out.println(n);
            }
            n++;
        }
    }
    //找到1到10之间所有3的倍数
    public static void main8(String[] args) {
        int i = 1;
        while (i <= 10) {
            if (i % 3 != 0)
            {
                i++;
                continue;//结束本次循环
            }
            System.out.println(i);
            i++;
        }
    }
    //找到第一个被3整除的数字
    public static void main7(String[] args) {
        int i = 1;
        while (i <= 10) {
            if (i % 3 == 0)
            {
                System.out.println(i);
                break;//结束所有循环
            }
            i++;
        }
    }
    //n的阶乘之和  n! + (n-1)! + (n-2)! +... + 1!
    public static void main6(String[] args) {
        int n = 5;
        int sum = 0;
        while (n > 0) {
            int ret = 1;
            int i = n;
            while (i > 0) {
                ret *= i;
                i--;
            }
            sum += ret;
            n--;
        }
        System.out.println(sum);
    }
    //n的阶乘
    public static void main5(String[] args) {
        int n = 5;
        int ret = 1;
        while (n > 0) {
            ret *= n;
            n--;
        }
        System.out.println(ret);
    }

    public static void main4(String[] args) {
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println(i);
    }

    //面试问题：Java中不能当switch参数的数据类型有哪些？
    //1.long  float   double  boolean
    //JDK1.5之后引入了枚举  枚举也可做switch参数
    //工作的时候尽量少用switch
    public static void main3(String[] args) {
        int a = 1;
        //long a = 1L;
        //double a = 1.2;
        //char a = 'f';
        //boolean a = true;
        //String a = "hello";
        switch (a) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("参数不匹配");
                break;
        }
    }

    public static void main2(String[] args) {
        int x = 20;
        int y = 10;
        if (x == 10)
            if (y == 10)
                System.out.println("aaa");
            else
                System.out.println("bbb");
    }

    public static void main1(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int year = scanner.nextInt();
         if((year % 100 != 0 && year % 4 == 0) || (year % 400 == 0)) {
             System.out.println("闰年");
         }else {
             System.out.println("平年");
         }
         scanner.close();
    }
}

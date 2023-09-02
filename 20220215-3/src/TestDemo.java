import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -02 -15
 * Time: 22:35
 */

public class TestDemo {

    //华为od笔试题，给两个字符串a和b，在b中找到a字符串，返回a字符串最后一次出现的首字母下标
    //例如target="abc",source="abcaybec"；返回3
    //通过百分之六十用例
    public static void main22(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String target = sc.nextLine();
        String source = sc.nextLine();
        int lastIndex = -1;
        for (int i = 0; i < source.length(); i++) {
            int j = 0;
            int tempi = i;
            int last = lastIndex;
            boolean has = false;
            while (tempi < source.length() && j < target.length()) {
                if (target.charAt(j) == source.charAt(tempi)) {
                    if (source.charAt(i) == target.charAt(0) && lastIndex < i) {
                        lastIndex = i;
                    }
                    j++;
                    has = true;
                }
                tempi++;
            }
            //在source中找不到和目标字符串字母相同的，应该直接退出
            if (target.charAt(target.length()-1) != source.charAt(tempi-1)) {
                lastIndex = last;
            }
        }
        System.out.println(lastIndex);
    }

    //华为od笔试题，给定一个数组，从数组第一个元素出发，第一步走n步（n<数组长度一半），
    // 之后的每一步走对应数组下标的部步数，求最少走几步能走到数组尾部
    //例：[7,5,9,4,2,6,8,3,5,4,3,9]，第一步从7走2步到9，再从9走9步到9
    //笔试通过
    public static void main21(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String[] str = sc.nextLine().split(" ");
        int minstep = -1;
        for (int i = 1; i < str.length/2; i++) {
            int j = i;
            int step = 1;
            while (j < str.length-1) {
                j += Integer.parseInt(str[j]);
                step++;
            }
            if ((j == str.length-1 &&  minstep < 0) || (j == str.length-1 &&  step < minstep)) {
                minstep = step;
            }
        }
        System.out.println(minstep);
    }


    /*题目描述:
    宜居星球改造计划
2XXX年，人类通过对火星的大气进行宜居改造分析，使得火星已在理论上具备人类宜居的条件；
由于技术原因，无法一次性将火星大气全部改造，只能通过局部处理形式；
假设将火星待改造的区域为row *column的网格，每个网格有3个值，宜居区、可改造区、死亡区，
使用YES、NO、NA代替，YES表示该网格已经完成大气改造，NO表示该网格未进行改造，后期可进行改造，NA表示死亡区，
不作为判断是否改造完的宜居，无法穿过；
初始化下，该区域可能存在多个宜居区，并目每个宜居区能同时在每个大阳日单位向上下左右四个方向的相邻格子进行扩散，自动将4个方向相邻的真空区改造成宜居区；
请计算这个待改造区域的网格中，可改造区是否能全部成宜居区，如果可以，则返回改造的大阳日天教，不可以则返回-1*/
    //输入row*column个网格数据，每个网格值枚举值如下: YES，NO，NA，样例:
    //YES YES NO
    //NO NO NO
    //NA NO YES
    //没做出来  再看看
    public static void main20(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int column = sc.nextInt();
        int days = 0;
        boolean flag = false;
        String [][]str = new String[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                str[i][j] = sc.next();
            }
        }
        for (int i = 0; i < row-1; i++) {
            for (int j = 0; j <= i; j++) {
                if (str[i][j] == "YES") {
                    flag = true;
                }
                if (str[i+1][j] == "NA" && str[i][j+1] == "NA") {
                    days = -1;
                    break;
                }
                if (str[i][j] == "NO") {
                    //days++;
                }
            }
        }

        if (flag == false) {
            System.out.println(-1);
        } else{
            System.out.println(days);
        }
    }
    //华为OD试题
    // 给定一个整型数组，移除数组的某个元素使其剩下的元素乘积最大，如果数组出现相同的元素 ，请输出第一次出现的元素
    public static void main19(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int ret = 0;
        int negret = 0;
        int negcount = 0;
        int min = 0;
        for (int i = 0; i < str.length; i++) {
            int temp = Integer.parseInt(str[i]);
            if (temp >= 0) {
                if (Integer.parseInt(str[ret]) < 0 || temp < Integer.parseInt(str[ret])) {
                    ret = i;
                }
            }else if (temp < 0) {
                if (Integer.parseInt(str[negret]) > 0 || temp >= Integer.parseInt(str[negret])) {
                    negret = i;
                }
                negcount++;
            }
            //如果都是负数并且总数个数是双数的情况下，比如-2 -3 -4 -5这种情况下不能排序负数里面最大的，
            // 要排除所有负数里面最小的那个数
            if (temp < Integer.parseInt(str[min])) {
                min = i;
            }
        }
        if (ret == 0 && Integer.parseInt(str[0]) < 0) {
            System.out.println(min);
        } else if (negcount % 2 == 0) {
            System.out.println(ret);
        } else {
            System.out.println(negret);
        }
    }

    public static void main18(String[] args) {
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
        //Random random = new Random();
        Random random = new Random(11111);//设置随机种子，每次输出的结果一致
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

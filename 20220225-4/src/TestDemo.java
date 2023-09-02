import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -02 -25
 * Time: 0:06
 */

public class TestDemo {
    //求三个数中的最大值
    public static int max2(int a, int b) {
        return a > b ? a : b;
    }
    public static int max(int a, int b, int c){
        return max2(max2(a,b), c);
    }
    //调整数组顺序使得奇数位于偶数之前，不关心大小顺序
    public static void main12(String[] args) {
        int[] array = {1,2,3,4,5};
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    //找出只出现一次的数字
    public static void main11(String[] args) {
        int[] array = {1,2,3,2,1};
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum ^= array[i];
        }
        System.out.println(sum);
    }
    //13. 输出一个整数的每一位.
    public static void print(int n) {
        int tempn = n;
        int count = 0;
        while (tempn != 0) {
            count++;
            tempn /= 10;
        }
        while (count > 0) {
            tempn = n;
            int num = (int)(tempn / Math.pow(10,count-1)) % 10;
            count--;
            System.out.println(Math.abs(num));//输出绝对值
        }
    }

    public static void main(String[] args) {
        print(-574);
    }
    //12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。
    public static void main9(String[] args) {
        printOne(11);
    }

    public static void printOne(int n) {
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
        System.out.println();
        for (int i = 31; i >= 1; i -= 2) {
            System.out.print(((n >> i) & 1) + " ");
        }
    }
    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字验证它二进制中1的个数：");
        int num = sc.nextInt();
        System.out.println(numOfOne1(num));
        System.out.println(numOfOne2(num));
    }
    //11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static int numOfOne2(int n) {
        //方法2：算法级别，让n和(n-1)按位与，每次按位与都会少一个1，直至为0没有1，只需要计算能按位与几次
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
    //11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
    public static int numOfOne1(int n) {
        //方法1：判断1的个数，让这个数按位与&1，判断最后一位是否为1，然后一直无符号右移直至数字为0
        int count = 0;
        while (n != 0) {
            if ((n & 1) != 0){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字验证它是否是水仙花数：");
        int num = sc.nextInt();
        findNum(num);
    }
    //. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
    //身，如；153＝1＋5＋3?，则153是一个“水仙花数”。)
    public static void findNum(int n) {
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int tmp = i;
            while (tmp != 0) {
                count++;
                tmp /= 10;
            }
            tmp = i;
            int sum = 0;
            while (tmp > 0) {
                sum += Math.pow(tmp % 10, count);
                tmp /= 10;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }

    public static void main6(String[] args) {
        login();
    }
    //10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
    //入，最多输入三次。三次均错，则提示退出程序
    public static void login() {
        Scanner sc = new Scanner(System.in);
        int count = 3;
        while (count > 0) {
            System.out.println("请输入你的密码：");
            String password = sc.nextLine();
            //if (password == "123456")  错误写法
            if (password.equals("123456")) {
                System.out.println("登录成功！");
                break;
            } else {
                count--;
                System.out.println("密码错误，你还有" + count + "次机会");
            }
        }
    }

    public static  void main5(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(add(a, b));

        double d1 = 10.1;
        double d2 = 10.2;
        System.out.println(add(d1, d2));
    }

    public static int add(int a, int b) {
        return a+b;
    }
    public static double add(double a, double b) {
        return a+b;
    }

    public static void main4(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("交换实参前：" + a +" " + b);
        swap(a, b);
        System.out.println("交换实参后：" + a +" " + b);
    }

    /**
     * 在java中是拿不到栈上的地址，要解决这个问题只能把a和b的值放到堆上
     * 所以以下交换函数的代码是错误的，无用的
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
    public static void main3(String[] args) {
        int n = 10;
        int ret = sumAdd(n);
        System.out.println(ret);

        int fac = facSum(10);
        System.out.println(fac);
    }

    /**
     * 求某个数字的阶乘
     * @param n 5！ = 5*4*3*2*1
     * @return
     */
    public static int fac(int n) {
        int mul = 1;
        for (int i = 1; i <= n; i++) {
            mul *= i;
        }
        return mul;
    }

    /**
     * 求n的阶乘之和
     * 分开写代码的可阅读性提高
     * @param n
     * @return
     */
    public static int facSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += fac(i);
        }
        return sum;
    }

    public static void main2(String[] args) {
        int num = sumAdd(10);//方法的调用
        System.out.println(num);
        System.out.println(sumAdd(num)*2);//函数的返回值支持链式调用
    }
    /**
     * 求1-n的和
     * 函数名称：小驼峰
     * @param n 输入的一个数字
     * @return 求的和
     */
    public static int sumAdd(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += n;
        }
        return sum;
    }
    public static void main1(String[] args) {

        /*
        //9. 求出0～999之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确好等于该数本
        //   身，如；153＝1三次方＋5三次方＋3三次方，则153是一个“水仙花数”。)
        for (int i = 0; i <= 999 ; i++) {
            int tmp = i;
            int count = 0;
            int num = 0;
            while(tmp > 0) {
                tmp /= 10;
                count++;
            }
            tmp = i;
            while(tmp > 0) {
                num += (int)Math.pow(tmp%10, count);
                tmp /= 10;
            }
            if (num == i) {
                System.out.println(i);
            }
        }
         */

        /*
        //10. 编写代码模拟三次密码输入的场景。 最多能输入三次密码，密码正确，提示“登录成功”,密码错误， 可以重新输
        //     入，最多输入三次。三次均错，则提示退出程序
        int passNum = 3;
        String password = "chenyu";
        Scanner sc = new Scanner(System.in);
        while (passNum > 0) {
            String str = sc.nextLine();
            if (password.equals(str)) {
                System.out.println("登录成功");
                break;
            } else {
                passNum--;
                System.out.println("密码错误");
            }
        }
         */
        /*
        //11. 写一个函数返回参数二进制中 1 的个数 比如： 15 0000 1111 4 个 1
        //0001   0010  0011  0100  0101  0110  0111 1000  1001  1010  1011  1100  1101
        int num = 63;
        int count = 0;
        int num1 = num;
        //方法一：让num&1，判断最低位是1还是0，接下来num右移一位，判断num的每一位。最多有32位，判断32次就可以了
        for (int i = 0; i < 32; i++) {
            if ((num1 & 1) == 1) {
                count++;
            }
            num1 = num1 >> 1;
        }
        System.out.println(count);
        //方法二：假如这个数是十进制，我们要求它各个位上的数字，只需要进行% 和 /的操作就可以了
        //例如：num=1234   个位：num%10  十位：num/10   num%10   百位：num/10  num%10以此类推
        //想知道二进制数的各个位，只需要进行%和/的操作就可以了
        int num2 = num;
        int count2 = 0;
        while (num2 > 0) {
            if ((num2 % 2) == 1) {
                count2++;
            }
            num2 /= 2;
        }
        System.out.println(count2);
        //方法三：一个二进制数字和比自己小一位的数字& ，肯定会把这个数最右边的1消除，看能消除几次，就有几个1
        int num3 = num;
        int count3 = 0;
        while (num3 > 0) {
            num3 = num3 & (num3-1);
            count3++;
        }
        System.out.println(count3);

         */
        //12. 获取一个数二进制序列中所有的偶数位和奇数位， 分别输出二进制序列。

         /*
        //13. 输出一个整数的每一位
        System.out.println("请输入一个整数");
        Scanner sc = new Scanner(System.in);
        int num2 = sc.nextInt();
        int tmp2 = num2;
        int count2 = 1;
        while (tmp2 >= 0) {
            count2 += tmp2 % 10;
            tmp2 /= 10;
        }
         */
    }
}

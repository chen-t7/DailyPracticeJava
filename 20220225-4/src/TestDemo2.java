/**
 * Created with IntelliJ IDEA.
 * Description
 * User: lenovo
 * Date: 2022 -02 -28
 * Time: 22:18
 */
//递归
public class TestDemo2 {
    // 实现代码: 求解汉诺塔问题(提示, 使用递归)
    //汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。
    //大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
    //大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。
    //并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。
    //问应该如何操作？
    //1个盘子：A->C
    //2个盘子：A->B A->C B->C
    //3个盘子：A->C A->B C->B A->C B->A B->C A->C
    //4个盘子：A->B A->C B->C A->B C->A C->B A->B A->C B->C B->A C->A B->C A->B A->C B->C 2^n-1
    //规律：共n个盘子，要把n-1个盘子挪到B上，最大的从A->C，最后通过A把B上的盘子挪到C
    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }

    /**
     *
     * @param n      代表盘子的个数
     * @param pos1   代表盘子所在的起始位置
     * @param pos2   代表盘子的中转位置
     * @param pos3   代表盘子的结束位置
     */
    public static void hanio(int n, char pos1, char pos2, char pos3){
        if (n == 1) {
            move(pos1, pos3);
        } else{
            hanio(n-1, pos1, pos3, pos2);
            hanio(1, pos1, pos2, pos3);
            hanio(n-1, pos2, pos1, pos3);
        }
    }

    public static void main(String[] args) {
        hanio(4,'A','B','C');
    }
    public static void main7(String[] args) {
        int n = frogJump2(4);
        System.out.println(n);
    }
    //实现代码: 青蛙跳台阶问题(提示, 使用递归)
    //一只青蛙一次可以跳上 1 级台阶，也可以跳上2 级。求该青蛙跳上一个n 级的台阶总共有多少种跳法
    public static int frogJump(int n) {
        if (n == 1 || n == 2) {
            return n;
        } else {
            return frogJump(n - 1) + frogJump(n - 2);
        }
    }
    public static int frogJump2(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static void main6(String[] args) {
        int n = fib2(10);
        System.out.println(n);
    }
    //求斐波那契数列的第 N 项 F(0)=0，F(1)=1, F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
    //递归求斐波那契数列 缺点：到后面数字越大，出现冗余计算越多，效率越慢
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    //循环求斐波那契数列
    public static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
    public static void main5(String[] args) {
        int n = addNum(1729);
        System.out.println(n);
    }
    // 写一个递归方法，输入一个非负整数，返回组成它的数字之和. 例如，输入 1729, 则应该返回1+7+2+9，
    //它的和是19
    public static int addNum(int n) {
        if (n < 9) {
            return n;
        }
        return n % 10 + addNum(n / 10);
    }
    public static void main4(String[] args) {
        print(1230);
    }
    public static void print(int n){
        if (n >= 10) {
            print(n / 10);
        }
        System.out.print(n % 10 + " ");
    }
    public static void main2(String[] args) {
        int n = fac(5);
    }
    //求某个数的阶乘
    public static int fac(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fac(n-1);
    }
    public static void func(int n) {
        if (n == 1)
            return;
        func(n-1);
    }

    public static void main1(String[] args) {
        func(3);
    }
}

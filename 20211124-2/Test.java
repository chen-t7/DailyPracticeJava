public class Test{
	public static void main(String[] args) {
		//整型转字符串
		int num = 10;
		String str1 = num + "";
		String str2 = String.valueOf(num);
		//字符串转整型
		String str = "100a";
		int num1 = Integer.parseInt(str);
		System.out.println(num1);
	}
	public static void main11(String[] args) {
		final int MAXNUM;
		MAXNUM = 100;//常量只能被初始化一次且使用时一定要初始化
		System.out.println(MAXNUM);
	}
	//小于4个字节的数据类型运算的时候，会发生类型的提升
	public static void main10(String[] args) {
		byte b = 10;
		byte c = 20;
		byte d = (byte)(b + c);//强制类型转换时类型必须带括号
		int d2 = b + c;
		System.out.println(d);
	}
	// 字符串数据类型：
	// String
	public static void main9(String[] args){
		String str = "\"hello\"";//想要打印符号需要加转义字符
		System.out.println(str);
	}

	//布尔类型  
	//1.在java中布尔类型没有明确的大小
	//2.布尔类型只有两个取值：true和false
	//3.在java中没有所谓的0是假，非0是真，真只有true，假只有false
	public static void main8(String[] args){
		boolean flg = false;
		System.out.println(flg);
		//if(1){

		//}
	}

	//短整型：short 2个字节 范围-32768~32767  
	public static void main7(String[] args){
		short sh = 12;
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
	}

	//字节类型：byte  1个字节  数值  范围:128~127
	public static void main6(String[] args){
		byte b = 12;
		byte c = 21;
		System.out.println(b + " " + c);
		//System.out.println(c);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);

		//byte d = Byte.MAX_VALUE + 1;//发生了类型提升
		System.out.println(Byte.MAX_VALUE + 1);//println默认是以整形进行打印的，结果不是-128，是128

		//byte d = 130;//127
		//int i = 2147483648;//每一种数据给其赋值时，不能超过它的取值范围
		System.out.println(Integer.MAX_VALUE + Byte.MAX_VALUE);
	}

	//字符数据类型
	//Unicode字符集-->包含了很多，比如中文，变得更大了，能表示的范围更广了
	//char类型对应的包装类是Character
	public static void main5(String[] args){
		char ch = 'a';//2 byte  取值范围0~65535
		System.out.println(ch);
		
		char ch2 = '陈';//2 byte
		System.out.println(ch2);
	
		char ch3 = 98;
		System.out.println(ch3);
	}

	//单精度浮点型
	public static void main4(String[] args){
		float f = 12.3f;//4个字节，不加f默认是double类型
		System.out.println(f);
	}

	//双精度浮点型
	public static void main3(String[] args){
		double d = 12.5;//默认12.5是双精度类型
		//double是8字节
		System.out.println(d);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		
		int a = 1;
		int b = 2;
		System.out.println(a / b);//a 和 b都是整形、
		double num = 1.1;
		System.out.println(num * num);
	}

	//String[] args的作用是什么，运行时参数
	public static void main2(String[] args){
		for (int i = 0; i < args.length; i++){
			System.out.println(args[i]);
		}
	}
	
	/**
	 *长整型
	 */
	public  static void main1(String[] args){
		
		//long  8byte
		long a = 10L;  //定义的时候加L，意思是10是长整型
		System.out.println(a);
		//Long 是包装类
		System.out.println("长整型最大值:" + Long.MAX_VALUE);//用+拼接
		System.out.println("长整型最小值:" + Long.MIN_VALUE);
		
		int b = 10;
		int c = 20;
		System.out.println(b + c);
		//注意：任何类型的数据和字符串进行拼接  结果就是字符串
		System.out.println("sum = " + b + c);
	}
}
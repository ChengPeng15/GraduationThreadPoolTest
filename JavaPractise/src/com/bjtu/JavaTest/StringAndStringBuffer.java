package com.bjtu.JavaTest;

public class StringAndStringBuffer {

	public static void main(String[] args) {
		StringBuffer string = new StringBuffer("Hello");
		test(string);
		System.out.println(string);
	}

	/**
	 * StringBuffer是产生一块内存空间，增删改查都在内存空间中。
	 * 所以结果是Hello,world!
	 * @param str
	 */
	public static void test(StringBuffer str)
	{
		str.append(",world!");
	}
	
	/**
	 * String默认是final类型的，当执行str="World"的时候，系统会先new一个新的String对象
	 * 把这个新的string对象设置为“World”，然后复制给str。但是出了方法的作用范围之后就无效了
	 * @param str
	 */
	public static void test(String str)
	{
		str = "World";
	}
	
}

package com.lkp.leetcode.test;

import java.io.IOException;

/**
 *@className Test
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/7/22 15:10
 *@Version
 */
 public class Test {
 	private static int j = 0;
	
	/**
	 * 静态方法只会调用一次
	 * @param k
	 * @return
	 */
	public static boolean methodB(int k){
		j+=k;
		return true;
	}
	public static void methodA() throws IOException {
		throw new IOException();
	}
	
	public static void main(String[] args) {
		String str = "0123456789ABCDEF";
		int data = 0xee; //十六进制数
		int scale = 10; //转化目标进制
		
		String s = "";
		while(data > 0){
			if(data < scale){
				s = str.charAt(data) + s;
				data = 0;
			}else{
				int r = data%scale;
				s = str.charAt(r) + s;
				data  = (data-r)/scale;
			}
		}
		
		System.out.println(s);
	}
}
class A{
	public int getNumber(int a){
		return a+1;
	}
}

class B extends A{

@Override
public int getNumber(int a){
	return a+2;
}

public static void main(String[] args){
	B b=new B();
	String[] strings = new String[]{};
	int length = strings.length;
	System.out.println(b.getNumber(0));
	}
}

package com.lkp.leetcode.test;

/**
 *@className Test2
 *@description TODO
 *@Auther 85291173@qq.com
 *@Date 2019/7/22 17:25
 *@Version
 */
 public class Test2 {
	public static void main(String[] args) {
		//25 8b dd 5b 00010fd508010300000002c40b
		String str = "5D3800E1";
		String s = hexStringToString(str);
		long l = Long.parseLong(str, 16);
		System.out.println(l);
		System.out.println(s);
	}
	
	/**
	 * 字符串转换unicode
	 */
	public static String string2Unicode(String string) {
	  StringBuffer unicode = new StringBuffer();
	  for (int i = 0; i < string.length(); i++) {
		// 取出每一个字符
				char c = string.charAt(i);
				// 转换为unicode
				unicode.append("\\u" + Integer.toHexString(c));
	  }
	  return unicode.toString();
	}
	/**
	 * 字符串转化成为16进制字符串
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}
	/**
	 * 16进制转换成为string类型字符串
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "UTF-8");
			System.out.println(baKeyword);
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}
}


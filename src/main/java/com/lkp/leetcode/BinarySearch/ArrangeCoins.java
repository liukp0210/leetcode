package com.lkp.leetcode.BinarySearch;

/**
 *@className ArrangeCoins
 *@description
 *@Auther 85291173@qq.com
 *@Date 2019/8/30 15:03
 *@Version
 */
public class ArrangeCoins {
	
	/**
	 * You have a total of n coins that you want jto form in a staircase shape,where every k-th row must have exactly k coins.
	 * Given n find the total number of full staircase rows that can be formed.
	 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
	 *
	 * Example 1
	 *  n = 5
	 *  The coins can form the following rows:
	 *  *
	 *  **
	 *  **
	 *  Because the 3rd row is incomplete, we return 2.
	 * Example 2:
	 *  n = 8
	 *  The coins can form the following rows:
	 *
	 * （首项+末项）×项数/2
	 	举例：1+2+3+4+5+6+7+8+9=（1+9）×9/2=45
	 */
	public static int arrangeCoins(int n) {
		//表示硬币摆放的行数
	    int line = 1;
	    //当前摆放的硬币
	    int i = 1;
	    //表示当前行摆放硬币数量
	    int k = 0 ;
	    while ( i <= n){
	    	k++;
	    	if(k == line){
	    		if(i == n){
	    			return line;
				}
				line++;
				k = 0;
			}else{
				if(i == n){
					return line - 1;
				}
			}
			i++;
		}
		return 0;
	}
	
	/**
	 * todo 提交时说超出规定时间 其实是 k超出了int的范围所以使用long类型也能编译通过
	 * @param n
	 * @return
	 */
	public static int arrangeCoins2(int n) {
	    //当前摆放的硬币
	    int i = 0;
	    //表示当前行摆放硬币数量
	    long k = 0 ;
	    while ( k < n ) {
			i++;
			k += i;
		}
		return k==n?i:i-1;
	}
	
	/**
	 * todo 能用减法做的不要用用加法，防止int类型溢出边界
	 * @param n
	 * @return
	 */
	public static int arrangeCoins3(int n) {
	    //当前摆放的硬币
	    int i = 0;
	    while ( 0 < n ) {
			i++;
			n -= i;
		}
		return 0==n?i:i-1;
	}
	
	/**
	 * todo 根据等差公式计算
	 * @param n
	 * @return
	 */
	public static int arrangeCoins4(int n) {
		return (int)(Math.sqrt(0.25+n*2.0)-0.5);
	}
	
	public static void main(String[] args) {
		int i = arrangeCoins2(5);
		System.out.println(i);
	}
}

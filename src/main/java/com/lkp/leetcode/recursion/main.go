package main

import "fmt"


/**
 *
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 示例:
 输入: 38
 输出: 2
 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 进阶:
 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？

 f(x*10+y)=f(x*9+x+y)=f(x+y)  数学推理方法 数学不好只能看着别人的答案
 *
 */
func addDigits(num int) int  {
	if(num < 10){
		return num
	}

	a := num;
	var tatal int
	for a > 0  {
		tatal += a%10;
		a /= 10;
	}
	return addDigits(tatal);
}
func addDigits2(num int) int  {
	if num > 0 {
		if num%9 == 0 {
			return 9
		}else{
			return num%9
		}
	}
	return 0
}
//=========================================================================
/**
编写一个程序判断给定的数是否为丑数。
丑数就是只包含质因数 2, 3, 5 的正整数。

 */

func main()  {
	//fmt.Println(addDigits(89))

	fmt.Println(isBgly(16));
}

/**
异或算法
 */
func missingNumber(nums []int) int {
	var num = len(nums)
	for i := 0 ; i < len(nums) ; i ++  {
		num ^= nums[i]
		num ^= i
	}
	return num
}



func isBgly(num int32) bool{
	if num <= 0{ return  false}
	for num % 2 == 0 {
		num /= 2;
	}
	for num % 3 == 0 {
		num /= 3;
	}
	for num % 5 == 0 {
		num /= 5;
	}

	if num == 1 {
		return true;
	}
	return false;
}


func isBgly2(num int32) bool{
	if num <= 0{ return  false}
	if num % 2 == 0 {
		num /= 2;
	}
	for num % 3 == 0 {
		num /= 3;
	}
	for num % 5 == 0 {
		num /= 5;
	}
	if num == 1 {
		return true;
	}
	return false;
}

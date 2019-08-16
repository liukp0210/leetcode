package main

import (
	"fmt"
	"container/list"
	"strings"
)


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

	//fmt.Println(isBgly(16));
	//fmt.Println("hello world");
	//a := []int{0,0,1,1,1,2,2,3,3,4}
	//duplicates := removeDuplicates(a)
	//fmt.Println(duplicates)

	//nums := []int{1,3,5,6}
	//insert2 := searchInsert2(nums, 7)
	//fmt.Println(insert2)
	//palindrome := isPalindrome(121)
	//fmt.Println(palindrome)

	//toInt := romanToInt("MMMCMXCIX")
	//fmt.Println(toInt)
	strs := []string{"flower","flow","flight"}
	prefix := longestCommonPrefix(strs)
	fmt.Println(prefix)
}


	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 如果不存在公共前缀，返回空字符串 ""。
	 示例 1:
	 输入: ["flower","flow","flight"]
	 输出: "fl"
	 示例 2:
	 输入: ["dog","racecar","car"]
	 输出: ""
	 解释: 输入不存在公共前缀。
	 说明:
	 所有输入只包含小写字母 a-z 。
	 *
	 */
func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 {
		return ""
	}
	s := strs[0]
	commonPreFix := ""
	flag := false
	for index , value := range s {
		for i := 1 ;i < len(strs) ; i++{
			i2 := strs[i]
			if len(strs[i]) > index{
				i3 := i2[index]
				if int32(i3) != value{
					flag = true
					break
				}
			}else{
				flag = true
				break
			}

		}
		if flag {
			break
		}else{
			commonPreFix += string(value)
		}
	}
	return commonPreFix
}







//map.put('I',1);
//map.put('V',5);
//map.put('X',10);
//map.put('L',50);
//map.put('C',100);
//map.put('D',500);
//map.put('M',1000);
func romanToInt(s string) int{
	maps := make(map[rune]int)
	maps['I'] = 1
	maps['V'] = 5
	maps['X'] = 10
	maps['L'] = 50
	maps['C'] = 100
	maps['D'] = 500
	maps['M'] = 1000
	//j := 0
	flag := false
	nums := 0
	for index,value := range s {

		if flag {
			flag = false
			continue
		}
		i := maps[value]
		j := 0
		if index + 1 < len(s){
			i2 := s[index+1]
			j = maps[rune(i2)]
		}
		if  i < j {
			nums += j - i
			flag = true
		}else{
			nums += i
		}


	}


	return nums
}

func isPalindrome(x int)  bool {
	if x < 0 || x%10 ==0 && x!= 0{
		return false
	}
	a := 0
	for x > a{
		a = (a * 10) + (x % 10)
		x /= 10
	}

	if a == x || x == a / 10 {
		return true
	}
	return false
}


func searchInsert2(nums []int,target int) int  {
	left := 0
	right := len(nums) - 1
	for left <= right {
		middle := (left + right)>>1
		if nums[middle] == target {
			return middle
		}else if nums[middle] > target {
			right = middle -1
		}else if nums[middle] < target{
			left = middle + 1
		}
	}
	return left
}


func searchInsert( nums []int, target int) int {

	k := 0
	for i := 0; i < len(nums) ;i++  {
		if nums[i] == target {
			return i
		}
		if nums[i]> target {
			k++
		}
	}
	return len(nums) -k
}


func strStr(haystack , needle string) int  {
	if needle == "" {
		return 0
	}
	return strings.Index(haystack, needle)
}


func removeElement(nums []int,val int) int  {
	if len(nums) == 0 {
		return  0
	}
	k := 0
	for i := 0 ; i < len(nums) ; i++ {
		if nums[i] != val {
			nums[k] = nums[i]
			k++;
		}
	}
	return  k
}

func removeDuplicates2(nums []int) int {
	if len(nums) == 0 {
		return  0
	}
	k := 0
	for i := 1; i< len(nums); i++ {
		if nums[k] != nums[i]{
			k++
			nums[k] = nums[i]
		}
	}
	return k+1;
}
func removeDuplicates(nums []int) int {
	var l =list.New()
	for k, _ := range nums {
		i := nums[k]
		back := l.Back()
		if back != nil{
			if (back.Value) != i  {
				l.PushBack(i)
			}

		}else{
			l.PushBack(i)
		}
	}
	k := 0;
	for i := l.Front(); i != nil ; i=i.Next()  {
		i2 := (i.Value).(int)
		nums[k] = i2;
		fmt.Print(i2)
		k++
	}
	fmt.Println()

	return  l.Len();
}

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}
	l := list.New()
	for e := range s {
		if s[e] == '(' || s[e] == '{' || s[e] == '[' {
			l.PushBack(s[e])
		} else {
			elem := l.Back()
			if elem == nil {
				return false
			}
			v := (elem.Value).(uint8)
			if (v == '(' && s[e] == ')') || (v == '{' && s[e] == '}') || (v == '[' && s[e] == ']') {
				l.Remove(elem)
			} else {
				return false
			}
		}
	}
	return l.Len() == 0
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

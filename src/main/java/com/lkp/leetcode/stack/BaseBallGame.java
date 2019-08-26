package com.lkp.leetcode.stack;

import java.util.Iterator;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 *@className BaseBallGame
 *@description 棒球得分
 *@Auther 85291173@qq.com
 *@Date 2019/8/23 15:36
 *@Version
 */
public class BaseBallGame {
	/**
	 * You're now a baseball game point recorder.
	 * Given a list of strings,each string can be one of the following types:
	 * 1. Integer (one round's score):Directly represents the number of points you get in this round.
	 * 2. "+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
	 * 3. "D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
	 * 4. "C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
	 *
	 *Each round's operation is permanent and could have an impact on the round before and the round after.
	 *You need to return the sum of the points you could get in all the rounds.
	 *
	 *Example 1:
	 Input: ["5","2","C","D","+"]
	 Output: 30
	 Explanation:
	 Round 1: You could get 5 points. The sum is: 5.
	 Round 2: You could get 2 points. The sum is: 7.
	 Operation 1: The round 2's data was invalid. The sum is: 5.
	 Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
	 Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
	 Example 2:
	 Input: ["5","-2","4","C","D","9","+","+"]
	 Output: 27
	 Explanation:
	 Round 1: You could get 5 points. The sum is: 5.
	 Round 2: You could get -2 points. The sum is: 3.
	 Round 3: You could get 4 points. The sum is: 7.
	 Operation 1: The round 3's data is invalid. The sum is: 3.
	 Round 4: You could get -4 points (the round 3's data has been removed). The sum is: -1.
	 Round 5: You could get 9 points. The sum is: 8.
	 Round 6: You could get -4 + 9 = 5 points. The sum is 13.
	 Round 7: You could get 9 + 5 = 14 points. The sum is 27.
	 Note:
	 The size of the input list will be between 1 and 1000.
	 Every integer represented in the list will be between -30000 and 30000.
	 *
	 * 分析：循环遍历数组根据对应的类型，将得到的分数放入到依次放入到stack中如果遇到 C时，将栈顶的数据移除
	 * 1. 循环数组，判断类型，得到对应的分数，放入stack中，定义两个变量来保存上一回合分数有效分数和上上一个回合的有效分数
	 *
	 */
	
	public  static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < ops.length ; i++) {
			String op = ops[i];
			if(op.equals("+")){
				Integer pop = stack.pop();
				Integer pop1 = stack.pop();
				int pop3 = pop + pop1;
				stack.push(pop1);
				stack.push(pop);
				stack.push(pop3);
			}else if(op.equals("C")){
				//表示您获得的最后一个有效 回合的分数是无效的，应该被移除。
				stack.pop();
			}else if(op.equals("D")){
				//表示本轮获得的得分是前一轮有效 回合得分的两倍。
				Integer peek = stack.peek();
				stack.push(peek*2);
			}else {
				//直接表示您在本轮中获得的积分数。
				int i1 = Integer.parseInt(op);
				stack.push(i1);
			}
		}
		int i = 0 ;
		Iterator<Integer> iterator = stack.iterator();
		while (iterator.hasNext()){
			i += iterator.next();
		}
		return i;
	}
	public static void main(String[] args) {
		int i = calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
		System.out.println(i);
//		boolean integer = isInteger("1");
//		System.out.println(integer);
	}
}

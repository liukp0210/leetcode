package com.lkp.leetcode.stack;

/**
 *@className MinStack
 *@description min stack
 *@Auther 85291173@qq.com
 *@Date 2019/8/6 10:15
 *@Version
 */
 public class MinStack {
	/**
	 *
	 * Design a stack that supports push,pop,top,and retrieving the minimum element in sonstant time.
	 * push(x) --Push element x onto stack .
	 * pop()  -- Removes the element on top of the stack.
	 * top() --Get the top element.
	 * getMin() --Retrieve the minimum element in the stack.
	 *
	 *动态扩容的问题
	 */
	/** initialize your data structure here. */
	Integer[] arr = null;
	int count = 0;
	Integer min = null;
	public MinStack() {
		arr = new Integer[64];
	}
	
	public void push(int x) {
		if(count == arr.length){
			Integer[] arr1 = new Integer[arr.length*2];
			for (int i = 0; i < count; i++) {
				arr1[i] = arr[i];
			}
			arr = arr1;
		}
		arr[count++] = x;
		if(min == null){
			min = x;
		}else if(min > x ){
			min = x;
		}
	}
	
	public void pop() {
		count--;
		if(arr[count].equals(min)){
			arr[count] = null;
			min = null;
			for (int i = 0; i < arr.length; i++) {
				if(min == null && arr[i] != null){
					min = arr[i];
				}
				if(arr[i] != null && min > arr[i]){
					min = arr[i];
				}
			}
		}else{
			arr[count] = null;
		}
	}
	
	public int top() {
		return  arr[count-1];
	}
	
	public int getMin() {
		return min;
	}
	
	
	/**
	 * ["MinStack","push","getMin","top","getMin","push","push","getMin","push","getMin","pop","push","push","getMin","push","top","push","pop","pop","getMin","pop","getMin","getMin","pop","getMin","push","push","pop","push","getMin","getMin","push","getMin","getMin","push","getMin","getMin","getMin","push","getMin","pop","top","push","top","push","getMin","getMin","push","pop","getMin","getMin","pop","pop","getMin","push","getMin","getMin","push","getMin","top","getMin","push","getMin","push","top","getMin","push","getMin","top","getMin","push","getMin","getMin","push","pop","push","push","getMin","push","push","push","top","getMin","push","getMin","push","push","push","getMin","push","push","push","pop","push","getMin","top","getMin","getMin","push","top","push","push","top","push","getMin","push","top","getMin","getMin","getMin","getMin","getMin","push","getMin","push","push","getMin","getMin","getMin","top","getMin","push","pop","getMin","getMin","push","getMin","getMin","getMin","getMin","push","top","top","push","push","push","top","top","push","getMin","push","push","push","getMin","getMin","push","push","push","push","getMin","getMin","getMin","push","top","pop","getMin","push","top","pop","push","getMin","pop","getMin","pop","getMin","push","top","push","getMin","getMin","top","pop","top","getMin","getMin","push","push","push","pop","push","getMin","getMin","push","push","push","top","getMin","top","getMin","getMin","top","top","pop","pop","getMin","getMin","push","getMin","push","getMin","push","push","push","getMin","pop","pop","push","pop","top","push","top","top","pop","top","push","push","top","top","getMin","getMin","getMin","push","getMin","getMin","push","getMin","pop","top","push","push","push","push","push","getMin","getMin","push","getMin","getMin","getMin","push","getMin","getMin","getMin","top","getMin","getMin","push","top","getMin","push","getMin","push","getMin","getMin","getMin","push","pop","push","pop","push","top","getMin","getMin","push","getMin","getMin","getMin","push","push","push","getMin","push","top","push","getMin","push","top","getMin","getMin","getMin","pop","getMin","top","getMin","push","getMin","getMin","getMin","getMin","getMin","pop","getMin","getMin","push","getMin","pop","push","top","push","push","getMin","pop","pop","push","pop","getMin","push","push","getMin","getMin","pop","pop","pop","push","pop","push","push","push","push","getMin","top","getMin","getMin","getMin","top","push","getMin","push","push","getMin","pop","getMin","push","pop","pop","push","push","push","pop","getMin","getMin","pop","push","push","getMin","top","getMin","pop","push","push","push","getMin","getMin","push","push","push","getMin","pop","getMin","push","push","getMin","getMin","getMin","push","getMin","getMin","getMin","getMin","getMin","getMin","push","getMin","pop","getMin","getMin","push","pop","pop","pop","push","top","push","push","getMin","getMin","getMin","getMin","getMin","push","push","top","push","top","push","top","pop","push","getMin","push","push","getMin","getMin","getMin","getMin","pop","getMin","push","top","pop","push","getMin","push","push","push","push","pop","getMin","push","push","top","getMin","getMin","top","getMin","getMin","push","getMin","push","getMin","top","getMin","getMin","push","push","getMin","push","push","push","push","getMin","getMin","pop","push","top","push","pop","getMin","push","push","getMin","getMin","push","getMin","push","push","getMin","getMin","getMin","top","getMin","getMin","push","top","push","top","pop","push","push","getMin","push","pop","pop","push","getMin","push","getMin","getMin","getMin","top","top","pop","pop","pop","getMin","push","top","push","getMin","getMin","getMin","push","getMin","top","getMin","push","push","getMin","pop","getMin"]
	 [[],[395],[],[],[],[276],[29],[],[-482],[],[],[-108],[-251],[],[-439],[],[370],[],[],[],[],[],[],[],[],[-158],[82],[],[-176],[],[],[-90],[],[],[411],[],[],[],[-494],[],[],[],[155],[],[-370],[],[],[273],[],[],[],[],[],[],[173],[],[],[0],[],[],[],[-266],[],[-359],[],[],[189],[],[],[],[375],[],[],[-188],[],[-275],[-223],[],[294],[380],[-42],[],[],[33],[],[457],[422],[-352],[],[326],[-378],[231],[],[416],[],[],[],[],[277],[],[472],[205],[],[-443],[],[-5],[],[],[],[],[],[],[-312],[],[-249],[-209],[],[],[],[],[],[196],[],[],[],[-347],[],[],[],[],[400],[],[],[269],[434],[-213],[],[],[-58],[],[-353],[-426],[-335],[],[],[-188],[-388],[369],[319],[],[],[],[121],[],[],[],[155],[],[],[155],[],[],[],[],[],[495],[],[-53],[],[],[],[],[],[],[],[465],[162],[-334],[],[282],[],[],[432],[-418],[195],[],[],[],[],[],[],[],[],[],[],[],[374],[],[202],[],[181],[173],[-323],[],[],[],[-430],[],[],[346],[],[],[],[],[244],[-467],[],[],[],[],[],[279],[],[],[-30],[],[],[],[264],[-217],[-418],[12],[-439],[],[],[7],[],[],[],[-189],[],[],[],[],[],[],[303],[],[],[-297],[],[-21],[],[],[],[461],[],[-303],[],[-338],[],[],[],[-42],[],[],[],[85],[132],[57],[],[-17],[],[-10],[],[-500],[],[],[],[],[],[],[],[],[-7],[],[],[],[],[],[],[],[],[346],[],[],[16],[],[472],[-211],[],[],[],[-381],[],[],[214],[169],[],[],[],[],[],[33],[],[115],[-346],[-309],[130],[],[],[],[],[],[],[335],[],[-92],[-16],[],[],[],[-470],[],[],[250],[327],[144],[],[],[],[],[359],[138],[],[],[],[],[272],[-241],[-362],[],[],[-83],[195],[-208],[],[],[],[-500],[5],[],[],[],[284],[],[],[],[],[],[],[477],[],[],[],[],[30],[],[],[],[-269],[],[-413],[-323],[],[],[],[],[],[217],[-408],[],[-353],[],[-142],[],[],[-321],[],[-33],[382],[],[],[],[],[],[],[298],[],[],[495],[],[195],[-147],[-85],[195],[],[],[154],[-311],[],[],[],[],[],[],[-390],[],[323],[],[],[],[],[338],[263],[],[160],[148],[142],[427],[],[],[],[-153],[],[-384],[],[],[159],[419],[],[],[-385],[],[461],[-346],[],[],[],[],[],[],[343],[],[-269],[],[],[-401],[81],[],[130],[],[],[-428],[],[454],[],[],[],[],[],[],[],[],[],[59],[],[143],[],[],[],[-154],[],[],[],[114],[-346],[],[],[]]
	 *
	 *
	 *
	 *
	 * @param args
	 */
	
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
//		for (int i = 0; i < 100; i++) {
			
			minStack.push(2);
//		}
		minStack.push(0);
		minStack.push(3);
		minStack.push(0);
		
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.pop();
//		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
		
	}
}

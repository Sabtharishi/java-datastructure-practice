package com.rishi.ds.stack;

/**
 * Custom implementation of stack in java
 * <li>stack uses LIFO</li>
 * <li>Adding new element called as push</li>
 * <li>Getting an element called as pop. Once we popped an element, that element
 * can not be retrieved any more</li>
 * <li>Instead of popping an element, we can use peek. Using peek we can get
 * idea what is the next element to pop. In this case, element still be
 * accessible</li>
 * <li>stack uses LIFO</li>
 * 
 * <li>In this example, we are going to use Array as a backing data structure
 * <li>We need a pointer variable to keep track of last index. This variable is
 * usually called "top"
 * 
 * @author Rishi
 */
public class ArrayBackedStack {
	private int top = -1;
	private String stack[];
	private int size;

	public ArrayBackedStack(int size) {
		stack = new String[size];
		this.size = size;
	}

	public void push(String newElement) throws IllegalAccessException {
		// hasSpaceInArray?
		if (hasSpace()) {
			stack[++top] = newElement;
			System.out.println("New element added at " + top);
		} else {
			throw new IllegalAccessException("Stack is full!!!! pop elements to add new elements ");
		}
	}

	/**
	 * 
	 * @return
	 */
	public String peek() {
		if (top == -1) {
			System.out.println("No data exist");
			return null;
		}
		System.out.println("Next element to be popped: " + stack[top]);
		return stack[top];
	}

	/*
	 * top is the current last index (starts from 0) Size starts from 1
	 */
	private boolean hasSpace() {
		return size - 1 != top;
	}

	public String pop() {
		if (top == -1) {
			System.out.println("No data exist");
			return null;
		}

		System.out.println("Popping element: " + stack[top]);
		return stack[top--];
	}

	public static void main(String[] args) throws IllegalAccessException {
		ArrayBackedStack sc = new ArrayBackedStack(3);
		sc.pop(); // should be no element
		sc.push("a");
		sc.push("b");
		sc.push("c");
		sc.pop();//pop a
		sc.pop();//pop b
		sc.pop();//pop c
		sc.pop();// should be no element
		sc.push("c");// add new element at 0
		sc.peek();// peek 
		sc.pop();//pop c
		sc.pop();//should be no element
	}
}

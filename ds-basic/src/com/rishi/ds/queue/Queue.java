package com.rishi.ds.queue;

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
 * -------------------------------------------------------------<br />
 * -------------------------------------------------------------<br />
 * Queue --> |Head|2 |3 | | Rear | --<br />
 * -------------------------------------------------------------<br />
 * -------------------------------------------------------------<br />
 * 
 * @author Rishi
 */
public class Queue {
	private int head = -1;
	private int rear = -1;
	private String queue[];
	private int size;

	public Queue(int size) {
		queue = new String[size];
		this.size = size;
	}

	public void push(String newElement) throws IllegalAccessException {
		// hasSpaceInArray?
		if (hasSpace()) {
			queue[++rear] = newElement;
			System.out.println("New element added at " + rear);
		} else {
			System.out.println("Queue is full!!!! pop elements to add new elements ");
			return;
		}
	}

	/**
	 * 
	 * @return
	 */
	public String peek() {
		if (rear == -1) {
			System.out.println("No data exist");
			return null;
		}

		if (head + 1 > rear) {
			System.out.println("No data exist");
			return null;
		}
		System.out.println("head: " + (head + 1));
		System.out.println("Popping element: " + queue[head + 1]);
		return queue[head];
	}

	/*
	 * top is the current last index (starts from 0) Size starts from 1
	 */
	private boolean hasSpace() {
		return size - 1 != rear;
	}

	public String pop() {
		if (rear == -1) {
			System.out.println("No data exist");
			return null;
		}

		head++;

		if (head > rear) {
			System.out.println("No data exist");
			return null;
		}
		System.out.println("head: " + head);
		System.out.println("Popping element: " + queue[head]);
		return queue[head];
	}

	public static void main(String[] args) throws IllegalAccessException {
		Queue sc = new Queue(3);
		sc.pop(); // should be no element
		sc.pop(); // should be no element
		sc.push("a");
		sc.push("b");
		sc.push("c");
		sc.pop();// pop a
		sc.pop();// pop b
		sc.pop();// pop c
		sc.pop();// should be no element
		sc.push("c");// add new element at 0
		sc.peek();// peek
		sc.push("d");
		sc.push("e");
		sc.push("f");
		sc.pop();// pop c
		sc.pop();// should be no element

		System.out.println("Program completed");
	}
}

package com.greatlearning.dsa;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

class StackUsingQueue {
	Queue<Integer> queue;
	Queue<Integer> tempQueue;

	public StackUsingQueue() {
		// TODO Auto-generated constructor stub
		queue = new LinkedList<Integer>();
		tempQueue = new LinkedList<Integer>();

	}

	// push
	void push(int data) {
		if (queue.size() == 0) {
			queue.add(data);
		} else {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				tempQueue.add(queue.remove());
			}
			queue.add(data);
			for (int i = 0; i < size; i++) {
				queue.add(tempQueue.remove());
			}
		}
	}

	// pop
	int pop() {
		if (queue.size() == 0) {
			throw new NoSuchElementException("Underflow Exception");
		}
		return queue.remove();
	}

	// Check Empty
	boolean isEmpty() {
		return queue.size() == 0;
	}

	// size
	int getSize() {
		return queue.size();
	}

	void display() {
		System.out.println("\n Stack: ");

		int size = getSize();

		if (size == 0) {
			System.out.println("\n Empty");
		} else {
			Iterator<Integer> iterator = queue.iterator();

			while (iterator.hasNext()) {
				System.out.println(iterator.next() + " ");
			}
		}

	}

}

public class StackImplementationsUsingQueue {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		StackUsingQueue stackUsingQueue = new StackUsingQueue();

		char ch;

		do {

			System.out.println("\n Operations: \n 1. push \n 2. pop \n 3. check empty \n 4. size");

			int choice = scanner.nextInt();

			switch (choice) {
			// push
			case 1:
				System.out.println("\n Enter Element to push: ");

				stackUsingQueue.push(scanner.nextInt());

				break;
			// pop
			case 2:
				System.out.println("\n Popped Element: " + stackUsingQueue.pop());

				break;

			// check empty
			case 3:

				System.out.println("\n Check Empty: " + stackUsingQueue.isEmpty());
				break;

			// size
			case 4:

				System.out.println("\n Size: " + stackUsingQueue.getSize());

				break;

			default:
				System.out.println("\n Invalid Choice");
				break;
			}

			stackUsingQueue.display();
			System.out.println("\n Do you want to continue: Y/N ");
			ch = scanner.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

		scanner.close();

	}
}

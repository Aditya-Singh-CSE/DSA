package linkedListBasics;

import java.util.Scanner;

public class MidPoint {
	
	public static int findMid(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast= head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
	}
	
	static int findMiddleLL(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow.data;
	}
	
	public static Node<Integer> takeInput(){
		Scanner sc = new Scanner(System.in);
		Node<Integer> head=null;
		Node<Integer> tail = null;
		
		int data = sc.nextInt();
		while(data!=-1) {
			Node<Integer> newNode = new Node(data);
			if(head==null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = tail.next;
			}
			
			data = sc.nextInt();
		}
		
		return head;
	}
	
	public static void printLL(Node<Integer> head) {
		Node<Integer> curr = head;
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printLL(head);
		System.out.println();
		int ans = findMid(head);
		System.out.println("Mid element is "+ans);

	}

}

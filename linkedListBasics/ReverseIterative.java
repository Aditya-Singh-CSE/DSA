package linkedListBasics;

import java.util.Scanner;

public class ReverseIterative {
	
	public static Node<Integer> reverseIterative(Node<Integer> head){
		Node<Integer> prev = null;
		Node<Integer> curr = head;
		Node<Integer> temp;
		
		while(curr!=null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
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
	//Print LL element
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
		head = reverseIterative(head);
		printLL(head);

	}

}

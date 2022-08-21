package linkedListBasics;

import java.util.Scanner;

public class RemoveDuplicate {
	
	public static Node<Integer> removeDuplicates(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> curr = head;
		while(curr.next!=null) {
			if(curr.data==curr.next.data) {
				curr.next = curr.next.next;
			}
			else {
				curr = curr.next;
			}
		}
		return head;
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
		head = removeDuplicates(head);
		printLL(head);

	}

}

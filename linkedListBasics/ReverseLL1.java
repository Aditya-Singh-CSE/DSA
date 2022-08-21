package linkedListBasics;

import java.util.Scanner;

public class ReverseLL1 {

	public static Node<Integer> reverseR(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> finalHead = reverseR(head.next);
		Node<Integer> temp = finalHead;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next = head;
		head.next = null;
		return finalHead;
	}

	public static void printLL(Node<Integer> head) {
		Node<Integer> curr = head;
		while(curr!=null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
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
	
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printLL(head);
		System.out.println();
		head = reverseR(head);
		printLL(head);

	}

}

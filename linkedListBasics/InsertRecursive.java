package linkedListBasics;

import java.util.Scanner;

public class InsertRecursive {

	public static Node<Integer> insertRecur(Node<Integer> head,int pos,int elem){
		
		if(pos==0) {
			Node<Integer> newNode = new Node<Integer>(elem);
			newNode.next = head;
			return newNode;
		}
		if(head==null) {
			return head;
		}
		
		head.next = insertRecur(head.next,pos-1,elem);
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
		head = insertRecur(head,8,90);
		printLL(head);

	}

}

package linkedListBasics;

import java.util.Scanner;

// Best method its time complexity is O(1)
public class ReverseLL3 {
	
	// Best method
	// Try to remember this method and forgot all other methods
	public static Node<Integer> reverseLLRecursively(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> reversedTail = head.next;
		Node<Integer> newHead = reverseLLRecursively(head.next);
		reversedTail.next = head;
		head.next = null;
		return newHead;
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
		head = reverseLLRecursively(head);
		printLL(head);
	}

}

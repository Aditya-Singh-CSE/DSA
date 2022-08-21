package linkedListBasics;

import java.util.Scanner;

public class ReverseLL2 {
	
	public static DoubleNode reverseLLBetter(Node<Integer> head) {
		if(head==null || head.next==null) {
			DoubleNode ans = new DoubleNode();
			ans.head = head;
			ans.tail = head;
			return ans;
		}
		
		DoubleNode smallAns = reverseLLBetter(head.next);
		smallAns.tail.next = head;
		head.next = null;
		smallAns.tail=head;
		
//		DoubleNode ans = new DoubleNode();
//		ans.head = smallAns.head;
//		ans.tail = head;
		return smallAns;
		
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
		DoubleNode ans = reverseLLBetter(head);
		printLL(ans.head);

	}

}

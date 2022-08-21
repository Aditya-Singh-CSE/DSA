package linkedListBasics;

import java.util.Scanner;

public class BubbleSort {
	
	public static int length(Node<Integer> head) {
		int count = 0;
		while(head!=null) {
			count = count+1;
			head = head.next;
		}
		return count;
	}
	
	public static Node<Integer> bubbleSort(Node<Integer> head){
		if(head==null) {
			return head;
		}
		
		int n = length(head);
		
		for(int i=0;i<n;i++) {
			Node<Integer> temp = head;
			Node<Integer> temp1 = temp.next;
			int d;
			for(int j=0;j<n-i-1;j++) {
				// swapping of data if first data is greater
				if(temp.data > temp1.data) {
					d = temp.data;
					temp.data = temp1.data;
					temp1.data = d;
				}
				temp = temp1;
				temp1 = temp1.next;
			}
		}
		Node<Integer> temp2 = head;
		return temp2;
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
		head = bubbleSort(head);
		System.out.println();
		printLL(head);

	}
	
}

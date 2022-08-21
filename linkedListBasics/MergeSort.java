package linkedListBasics;

import java.util.Scanner;

public class MergeSort {
	
	public static Node<Integer> middle(Node<Integer> head) {
		Node<Integer> slow = head;
		Node<Integer> fast= head;
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	//Merge two sorted linked list or two unsorted/sorted elements
	public static Node<Integer> mergeSortedLL(Node<Integer> head1,Node<Integer> head2){
		Node<Integer> newHead = null;
		Node<Integer> newTail = null;
		
		//Step1: Find newHead
		if(head1.data < head2.data) {
			newHead = head1;
			newTail = head1;
			head1 = head1.next;
		}
		else {
			newHead = head2;
			newTail = head2;
			head2 = head2.next;
		}
		
		//Step2: Find smallest number b/w two LL and add it to tail
		// do this procedure untill one of them equal to null
		while(head1!=null && head2!=null) {
			if(head1.data < head2.data) {
				newTail.next = head1;
				newTail = newTail.next;
				head1 = head1.next;
			}
			else {
				newTail.next = head2;
				newTail = newTail.next;
				head2 = head2.next;
			}
		}
		if(head1!=null) {
			newTail.next = head1;
		}
		if(head2!=null) {
			newTail.next = head2;
		}
		return newHead;
	}    
	
	public static Node<Integer> mergeSort(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> mid = middle(head);
		Node<Integer> half1 = head;
		Node<Integer> half2 = mid.next;
		
		//To break the link initially
		mid.next=null;
		
		half1 = mergeSort(half1);
		half2 = mergeSort(half2);
		
		Node<Integer> finalHead = mergeSortedLL(half1,half2);
		return finalHead;	
		
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
		head = mergeSort(head);
		printLL(head);

	}

}

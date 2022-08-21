package linkedListBasics;

import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> removeDuplicate(Node<Integer> head){
		Node<Integer> curr = head;
		while(curr!=null && curr.next!=null) {
			if(curr.data==curr.next.data) {
				curr.next = curr.next.next;
			}
			else {
				curr = curr.next;
			}
		}
		return head;
	}
	
	//Append last n node to first node
	public static Node<Integer> appendLastN(Node<Integer> head,int n){
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		if(n==0 || head.next==null) {
			return head;
		}
		for(int i=0;i<n;i++) {
			fast = fast.next;
			if(fast==null) {
				return head;
			}
		}
		
		
		while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}

		Node<Integer> newHead = slow.next;
		slow.next=null;
		
		fast.next=head;
		return newHead;
	}
	
	
	//Find nth element from last
	public static int findNfromLast(Node<Integer> head,int n) {
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		if(n==0) {
			return -1;
		}
		for(int i=0;i<n-1;i++) {
			fast = fast.next;
		}
		while(fast.next!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow.data;
	}
	
	//Return index of given element
	public static int findNode(Node<Integer> head,int element) {
		Node<Integer> curr = head;
		int pos=0;
		while(curr!=null) {
			if(curr.data == element) {
				return pos;
			}
			curr = curr.next;
			pos++;
		}
		return -1;
	}
	
	//Delete element from given position
	public static Node<Integer> delete(Node<Integer> head,int position){
		if(position==0) {
			head = head.next;
			return head;
		}
		Node<Integer> curr = head;
		for(int i=0;i<position-1;i++) {
			curr=curr.next;
		}
		curr.next = curr.next.next;
		return head;
		
	}
	
	//Take input in LinkedList
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
		mid.next=null;
		
		half1 = mergeSort(half1);
		half2 = mergeSort(half2);
		
		Node<Integer> finalHead = mergeSortedLL(half1,half2);
		return finalHead;	
		
	}
	
    

	//Main function
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0) {
			Node<Integer> head = null;
		     head = takeInput();
		    printLL(head);
		    System.out.println();
		    Node<Integer> head1 = appendLastN(head,0);
		    printLL(head1);
		    
		    //head = mergeSort(head);
//		    printLL(head1);
//		    System.out.println();
//		    head = mergeSortedLL(head1,head2);
//		    printLL(head);
//		    
//		    System.out.println();
//		    int midle = middle(head);
//		    System.out.println("Middle "+midle);
//		    head = removeDuplicate(head);
//		    printLL(head);
		  
//		    head = appendLastN(head,3);
//		    printLL(head);
//		    int ans = findNfromLast(head,1);
//		    System.out.print("Ans "+ans);
		   
			
//			int elem = sc.nextInt();
//			int index = findNode(head,elem);
//			System.out.println(index);
			
//			int pos = sc.nextInt();
//			head = delete(head,pos);
//			printLL(head);
			
			t--;
		}
		

	}

	public static Node<Integer> insertEnd(Node<Integer> head, int data) {
		Node<Integer> newNode = new Node(data);
		Node<Integer> curr = head;
	
		if(head==null) {
			head=newNode;
			return head;
		}
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=newNode;
		return head;
	}
	
	public static Node<Integer> insertBegin(Node<Integer> head, int data){
		Node<Integer> newNode = new Node(data);
		if(head==null) {
			head = newNode;
			return head;
		}
		newNode.next = head;
		head = newNode;
		return head;
	}

}

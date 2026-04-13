package dsa;

import java.util.*;

class Node{
	
	int data;
	Node left,right;
	
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class Stack{
	
	int size = 50;
	Node[] stack = new Node[size];
	int top = -1;
	
	boolean isEmpty() {
		return top == -1;
	}
	
	boolean isFull() {
		return top == size - 1;
	}
	
	void push(Node n) {
		if(!isFull()) {
			stack[++top] = n;
		}
		else {
			System.out.print("Stack is Full!");
		}
	}
	
	Node pop() {
		if(!isEmpty()) {
			return stack[top--];
		}
		else {
			System.out.print("Stack is Empty!");
			return null;
		}
	}
}

class BinaryTree{
	
	Scanner sc = new Scanner(System.in);
	
	Node root;
	int terminalNode = 0;
	
	public void insert(int data) {
		
		Node temp = root;
		
		while(true) {
			
			System.out.print("Enter direction L or R from " + temp.data + ": ");
			char dir = sc.next().charAt(0);
			
			if(dir == 'L') {
				
				if(temp.left == null) {
					temp.left = new Node(data);
					System.out.println("Inserted at left of " + temp.data);
					break;
				}
				else {
					temp = temp.left;
				}
			}
			else if(dir == 'R') {
				
				if(temp.right == null) {
					temp.right = new Node(data);
					System.out.println("Inserted at right of " + temp.data);
					break;
				}
				else {
					temp = temp.right;
				}
			}
			else {
				System.out.println("Enter correct direction!");
			}
		}
	}
	
	//Non recursive traversals
	
	void inOrderNonRecursive() {
		
		Stack s = new Stack();
		Node ptr = root;
		
		while(ptr != null || !s.isEmpty()) {
			
			while(ptr != null) {
				s.push(ptr);
				ptr = ptr.left;
			}
			
			ptr = s.pop();
			System.out.print(ptr.data + " ");
			ptr = ptr.right;
		}
	}
	
	void preOrderNonRecursive() {
		
		Stack s = new Stack();
		Node ptr = root;
		
		while(ptr != null || !s.isEmpty()) {
			
			while(ptr != null) {
				System.out.print(ptr.data + " ");
				s.push(ptr);
				ptr = ptr.left;
			}
			
			ptr = s.pop();
			ptr = ptr.right;
		}
	}
	
	void postOrderNonRecursive() {
		
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		
		if(root == null) {
			return;
		}
		
		s1.push(root);
		
		while(!s1.isEmpty()) {
			
			Node temp = s1.pop();
			s2.push(temp);
			
			if(temp.left != null) {
				s1.push(temp.left);
			}
			
			if(temp.right != null) {
				s1.push(temp.right);
			}
		}
		
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().data + " ");
		}
	}
	
	// Recursive Traversals
	
	void inOrderRecursive(Node n) {
		
		if(n!=null) {
		inOrderRecursive(n.left);
		System.out.print(n.data + " ");
		inOrderRecursive(n.right);
		
		}
	}
	
	void preOrderRecursive(Node n) {
		
		if(n != null) {
			System.out.print(n.data + " ");
			preOrderRecursive(n.left);
			preOrderRecursive(n.right);
		}
	}
	
	void postOrderRecursive(Node n) {
		
		if(n != null) {
			postOrderRecursive(n.left);
			postOrderRecursive(n.right);
			System.out.print(n.data + " ");
		}
	}
	
	void terminalNodeCount(Node n) {
		
		if(n!=null) {
			
			terminalNodeCount(n.left);
			
			if(n.left == null && n.right == null)
				terminalNode++;
			
			terminalNodeCount(n.right);
		}
	}
}


public class Tree{
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		boolean isTreeCreated = false;
		
		int choice;
		
		do {
			
				System.out.println("\n-----------Binary Tree Menu-----------");
				System.out.println("1. Create");
				System.out.println("2. Inorder Traversal (Recursive)");
	            System.out.println("3. Inorder Traversal (Non-Recursive)");
	            System.out.println("4. Preorder Traversal (Recursive)");
	            System.out.println("5. Preorder Traversal (Non-Recursive)");
	            System.out.println("6. Postorder Traversal (Recursive)");
	            System.out.println("7. Postorder Traversal (Non-Recursive)");
	            System.out.println("8. Count Terminal Nodes");
	            System.out.println("9. Exit");
	            
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();
	            
	            switch(choice) {
	            
	            case 1:
	            	System.out.print("Enter number of Nodes: ");
	            	int n = sc.nextInt();
	            	
	            	System.out.print("Enter value of root node: ");
	            	tree.root = new Node(sc.nextInt());
	            	
	            	for (int i=1;i<n;i++) {
	            		System.out.print("Enter value for node: ");
	            		tree.insert(sc.nextInt());
	            	}
	            	
	            	isTreeCreated = true;
	            	System.out.print("Tree Created Successfully.");
	            	break;
	            	
	            case 2:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.inOrderRecursive(tree.root);
	            		System.out.println();
	            	}
	            	break;
	            	
	            case 3:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.inOrderNonRecursive();
	            		System.out.println();
	            	}
	            	break;
	            
	            case 4:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.preOrderRecursive(tree.root);
	            		System.out.println();
	            	}
	            	break;
	            
	            case 5:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.postOrderNonRecursive();
	            		System.out.println();
	            	}
	            	break;
	            
	            case 6:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.postOrderRecursive(tree.root);
	            		System.out.println();
	            	}
	            	break;
	            
	            case 7:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.postOrderNonRecursive();
	            		System.out.println();
	            	}
	            	break;
	            
	            case 8:
	            	if(!isTreeCreated) {
	            		createTree();
	            	}
	            	else {
	            		tree.terminalNode = 0;
	            		tree.terminalNodeCount(tree.root);
	            		System.out.println("Number of terminal nodes: " + tree.terminalNode);
	            	}
	            	break;
	            
	            case 9:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
	            
	            }
			
		}while(choice != 9);
		
		sc.close();
	}
	
	static void createTree() {
		
		System.out.print("Please create the tree first! ");
	}
	
}

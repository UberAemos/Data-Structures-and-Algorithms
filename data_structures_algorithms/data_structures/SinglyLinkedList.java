package com.uberaemos.data_structures_algorithms.data_structures;

public class SinglyLinkedList<E> {
	private Node<E> head = null;		// Head node of the list
	private Node<E> tail = null;		// Last node of the list
	private int size = 0;				// Number of nodes in the list
	
	public SinglyLinkedList() { }
	
	/*
	 * Access methods
	 */
	
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	// Returns the first element
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	// Returns the last element
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		if (!isEmpty()) {
			Node current = head;
			do {
				builder.append(current.getElement());
				if (current.getNext() != null) builder.append(", ");
				current = current.getNext();
			} while (current != null);
		}
		builder.append("}");
		return builder.toString();
	}
	
	// Checks if given list is equal to the current list
	public boolean equals(Object o) {
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		SinglyLinkedList other = (SinglyLinkedList) o;
		if (size != other.size()) return false;
		Node walkA = head;
		Node walkB = other.head;
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement())) return false;
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		return true;
	}
	
	/*
	 * Update methods
	 */
	
	// Adds element to the front of the list
	public void addFirst(E e) {
		head = new Node<>(e, head);		// Create and link a new node
		if (size == 0) tail = head;		// If list is empty head also becomes the tail
		size++;
	}
	
	public void addLast(E e) {
		Node newNode = new Node(e, null);	// Create new node for tail
		if (isEmpty()) head = newNode;		// If empty tail also will be head
		else tail.setNext(newNode); 		// Make old tail link to the new node
		tail = newNode;						// New node becomes tail
		size++;
	}
	
	// Removes and returns the first element
	public E removeFirst() {
		if (isEmpty()) return null;
		E e = head.getElement();
		head = head.getNext();				// Head shifts one
		size--;
		if (size == 0) tail = null;			// Empty list tail should be null also
		return e;
	}
	
	// Removes and returns the last element
	public E removeLast() {
		if (isEmpty()) return null;
		E e = tail.getElement();
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node current = head;
			while (current.getNext().getNext() != null) {
				current = current.getNext();
			}
			current.setNext(null);
			tail = current;
		}
		size--;
		return e;
	}
	
	public void addList(SinglyLinkedList<E> list) {
		Node<E> current = list.head;
		while (current != null) {
			addLast(current.getElement());
			current = current.getNext();
		}
	}
	
	public void removeElement(E e) {
		if (isEmpty()) return;
		else if (head.getElement() == e) removeFirst();
		else if (tail.getElement() == e) removeLast();
		else {
			Node current = head;
			while (current.getNext() != null) {
				if (current.getNext().getElement() == e) {
					current.setNext(current.getNext().getNext());
					size--;
				}
				current = current.getNext();
			}
		}
	}
	
	private static class Node<E> {
		private E element;				// The element stored in this node
		public Node<E> next;			// Subsequent node in the list
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}

		public Node<E> getNext() { return next; }
		public void setNext(Node<E> next) {	this.next = next; }
		public E getElement() {	return element;	}
	}
}

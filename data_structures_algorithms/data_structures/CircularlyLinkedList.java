package com.uberaemos.data_structures_algorithms.data_structures;

public class CircularlyLinkedList<E> {
	private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}

		public Node<E> getNext() {	return next; }
		public void setNext(Node<E> next) { this.next = next; }
		public E getElement() {	return element;	}
	}

	private Node<E> tail = null;
	private int size = 0;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		if (!isEmpty()) {
			if (size == 1) {
				builder.append(tail.getElement());
			} else {
				Node current = tail.getNext();
				do {
					builder.append(current.getElement());
					if (current != tail) builder.append(", ");
					current = current.getNext();
				} while (current != tail.getNext());
			}
		}
		builder.append("}");
		return builder.toString();
	}
	
	/*
	 * Access methods
	 */
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }
	
	public E first() {
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	/*
	 * Update methods
	 */
	
	// Add element to the front of the list
	public void addFirst(E e) {
		if (isEmpty()) {
			tail = new Node<>(e, null);
			tail.setNext(tail);
		} else {
			Node<E> newNode = new Node<>(e, tail.getNext());
			tail.setNext(newNode);
		}
		size++;
	}
	
	// Add element to the end of the list
	public void addLast(E e) {
		addFirst(e);
		tail = tail.getNext();
	}
	
	// Rotates the first element to the back of the list
	public void rotate() {
		if (tail != null) tail = tail.getNext();
	}
}

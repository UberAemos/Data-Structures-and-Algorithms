package com.uberaemos.data_structures_algorithms.data_structures;

public class DoublyLinkedList<E> {
	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;
	
	public DoublyLinkedList() {
		header = new Node<E>(null, null, null);
		trailer = new Node<E>(null, header, null);
		header.setNext(trailer);
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first() {
		if (isEmpty()) return null;
		else {
			return header.getNext().getElement();
		}
	}
	
	public E last() {
		if (isEmpty()) return null;
		else {
			return trailer.getPrev().getElement();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		Node current = header.getNext();
		while (current != trailer) {
			builder.append(current.getElement());
			if (current.getNext() != trailer) builder.append(", ");
			current = current.getNext();
		}
		return builder.append("}").toString();
	}
	
	/*
	 * Update methods
	 */
	
	// Adds a node with element e between prev and next nodes
	private void addBetween(E e, Node prev, Node next) {
		Node newNode = new Node(e, prev, next);
		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;
	}
	
	// Removes the given node from the list and returns its element
	private E remove(Node<E> node) {
		Node prev = node.getPrev();
		Node next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		return node.getElement();
	}
	
	// Creates a node with element e at the start of the list
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}
	
	// Creates a node with element e at the end of the list	
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	// Removes the first node from the list and returns its value
	public E removeFirst() {
		if (isEmpty()) return null;
		return remove(header.getNext());
	}
	
	// Removes the last node from the list and returns its value
	public E removeLast() {
		if (isEmpty()) return null;
		return remove(trailer.getPrev());
	}
	
	public static class Node<E> {
		private E element;
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E element, Node<E> prev, Node<E> next) {
			this.element = element;
			this.next = next;
			this.prev = prev;
		}

		public Node<E> getNext() {return next;}
		public void setNext(Node<E> next) {	this.next = next;}
		public Node<E> getPrev() {	return prev;}
		public void setPrev(Node<E> prev) {	this.prev = prev;}
		public E getElement() {	return element;}
	}
}

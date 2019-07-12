package com.uberaemos.data_structures_algorithms.data_structures.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.uberaemos.data_structures_algorithms.data_structures.SinglyLinkedList;

public class TestSinglyLinkedList {
	SinglyLinkedList<Integer> emptyList;
	SinglyLinkedList<Integer> testListOfFive;
	SinglyLinkedList<Integer> testListOfTen;
	
	@BeforeEach
	public void init() {
		emptyList = new SinglyLinkedList<>();
		testListOfTen = new SinglyLinkedList<>();
		testListOfFive = new SinglyLinkedList<>();
		
		for (int i = 0; i < 5; i++) {
			testListOfFive.addLast(i);
		}
		
		for (int i = 0; i < 10; i++) {
			testListOfTen.addLast(i);
		}
	}
	
	@Test
	public void emtyListWhenNoElementsAdded() {
		assertTrue(emptyList.size() == 0, "Initial list is empty without any elements");
		assertTrue(emptyList.toString().equals("{}"));
	}
	
	@Test
	public void containsIntegerAfterAddFirst() {
		emptyList.addFirst(0);
		assertAll(() -> assertTrue(emptyList.first() == 0, "First element should be 0"),
				() -> assertTrue(emptyList.last() == 0, "Last element should be 0"));
	}
	
	@Test
	public void containsIntegerAfterAddLast() {
		emptyList.addLast(0);
		assertAll(() -> assertTrue(emptyList.first() == 0, "First element should be 0"),
				() -> assertTrue(emptyList.last() == 0, "Last element should be 0"));
	}
	
	@Test
	public void containsHeadAndTail() {
		assertAll(() -> assertTrue(testListOfTen.first() == 0, "First element should be 0"),
				() -> assertTrue(testListOfTen.last() == 9, "Last element should be 9"));
	}
	
	@Test
	public void shiftsHeadAfterRemoveFirst() {
		assertTrue(testListOfTen.removeFirst() == 0);
		assertAll(() -> assertTrue(testListOfTen.first() == 1, "First element should be 1"),
				() -> assertTrue(testListOfTen.size() == 9, "Size should be 9"));
	}
	
	@Test
	public void shiftsTailAfterRemoveLast() {
		assertTrue(testListOfTen.removeLast() == 9);
		assertAll(() -> assertTrue(testListOfTen.last() == 8, "Last element should be 8"),
				() -> assertTrue(testListOfTen.size() == 9, "Size should be 9"));
	}
	
	@Test
	public void shiftsListAfterRemovingElement() {
		testListOfTen.removeElement(5);
		assertAll(() -> assertTrue(testListOfTen.toString().equals("{0, 1, 2, 3, 4, 6, 7, 8, 9}"), "Element 5 should be removed"),
				() -> assertTrue(testListOfTen.size() == 9, "List size should be 9"));
	}
	
	@Test
	public void twoTestListsCanBeAddedInOrder() {
		testListOfTen.addList(testListOfFive);
		assertAll(() -> assertTrue(testListOfTen.size() == 15, "New list size should be 15"),
				() -> assertTrue(testListOfTen.toString().equals("{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4}"), "Two lists are not added properly")
			);
	}
	
	@Test
	public void equalsForDiffentListShouldReturnFalse() {
		assertFalse(testListOfFive.equals(testListOfTen), "Two lists are not equal");
	}
	
	@Test
	public void equalsForTheSameListShouldReturnTrue() {
		assertAll(() -> assertTrue(emptyList.equals(emptyList), "Two lists are equal"),
			() -> assertTrue(testListOfFive.equals(testListOfFive), "Two lists are equal")
		);
	}
}

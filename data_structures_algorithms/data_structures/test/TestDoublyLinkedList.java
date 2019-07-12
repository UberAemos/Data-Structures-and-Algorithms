package com.uberaemos.data_structures_algorithms.data_structures.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.uberaemos.data_structures_algorithms.data_structures.DoublyLinkedList;

public class TestDoublyLinkedList {
	public DoublyLinkedList<Integer> emptyList;
	public DoublyLinkedList<Integer> testList;
	
	@BeforeEach
	public void init() {
		emptyList = new DoublyLinkedList<>();
		testList = new DoublyLinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			testList.addLast(i);
		}
	}
	
	@Test
	public void listIsEmptyWithoutElementsAdded() {
		assertAll(
			() -> assertTrue(emptyList.isEmpty(), "isEmpty should return true"),
			() -> assertTrue(emptyList.size() == 0, "Size should return 0"),
			() -> assertTrue(emptyList.toString().equals("{}"), "toString should return empty list")
		);
	}
	
	@Test
	public void addFirstMakesConnectionsCorrectly() {
		emptyList.addFirst(0);
		testList.addFirst(-1);
		assertAll(
			() -> assertTrue(emptyList.toString().equals("{0}"), "Only 0 should be visible in emptyList"),
			() -> assertTrue(testList.toString().equals("{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}"), "-1 should be the first element"),
			() -> assertTrue(emptyList.size() == 1, "List size should be 1"),
			() -> assertTrue(testList.size() == 11, "List should be 11"),
			() -> assertTrue(emptyList.first() == 0, "First element of emptyList should be 0"),
			() -> assertTrue(testList.first() == -1, "First element of testList should be -1"),
			() -> assertTrue(emptyList.last() == 0, "Last element of emptyList should be the same and 0")
		);
	}
	
	@Test
	public void addLastMakesConnectionsCorrectly() {
		emptyList.addLast(0);
		testList.addLast(10);
		assertAll(
			() -> assertTrue(emptyList.toString().equals("{0}"), "Only 0 should be visible in emptyList"),
			() -> assertTrue(testList.toString().equals("{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}"), "10 should be the last element"),
			() -> assertTrue(emptyList.size() == 1, "List size should be 1"),
			() -> assertTrue(testList.size() == 11, "List should be 11"),
			() -> assertTrue(emptyList.first() == 0, "First element of emptyList should be 0"),
			() -> assertTrue(testList.last() == 10, "Last element of testList should be 10"),
			() -> assertTrue(emptyList.last() == 0, "Last element of emptyList should be the same and 0")
		);
	}
	
	@Test
	public void removeMakesConnectionsCorrectly() {
		assertAll(
			() -> assertTrue(emptyList.removeFirst() == null, "Removing from empty list should return null"),
			() -> assertTrue(emptyList.toString().equals("{}"), "emptyList should still be empty"),
			() -> assertTrue(testList.removeFirst() == 0, "removeFirstShould return first element"),
			() -> assertTrue(testList.toString().equals("{1, 2, 3, 4, 5, 6, 7, 8, 9}"), "0 should be deleted"),
			() -> assertTrue(emptyList.size() == 0, "List size should be 0"),
			() -> assertTrue(testList.size() == 9, "List size should be 9"),
			() -> assertTrue(emptyList.first() == null, "First element of emptyList should be null"),
			() -> assertTrue(testList.first() == 1, "First element of testList should be 1"),
			() -> assertTrue(emptyList.last() == null, "Last element of emptyList should be the same and null"),
			() -> assertTrue(testList.removeLast() == 9, "removeLast Should return 9"),
			() -> assertTrue(testList.toString().equals("{1, 2, 3, 4, 5, 6, 7, 8}"), "9 should be deleted"),
			() -> assertTrue(testList.size() == 8, "List size should be 8"),
			() -> assertTrue(testList.last() == 8, "Last element of testList should be 8")
			
		);
	}
}

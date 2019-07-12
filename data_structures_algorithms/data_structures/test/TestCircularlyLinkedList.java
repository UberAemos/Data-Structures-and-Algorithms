package com.uberaemos.data_structures_algorithms.data_structures.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.uberaemos.data_structures_algorithms.data_structures.CircularlyLinkedList;

public class TestCircularlyLinkedList {
	public CircularlyLinkedList<Integer> emptyList;
	public CircularlyLinkedList<Integer> testList;
	
	@BeforeEach
	public void init() {
		emptyList = new CircularlyLinkedList<>();
		testList = new CircularlyLinkedList<>();
		
		for (int i = 0; i < 10; i++) {
			testList.addLast(i);
		}
	}
	
	@Test
	public void list_Empty_Without_Elements_Added() {
		assertAll("List should be empty", 
			() -> assertTrue(emptyList.isEmpty()),
			() -> assertTrue(emptyList.size() == 0),
			() -> assertTrue(emptyList.toString().equals("{}"))
		);
	}
	
	@Test
	public void add_First_To_Empty_List_Makes_Tail_And_Head_Same() {
		emptyList.addLast(0);
		assertAll(() -> assertTrue(emptyList.size() == 1, "Size should be 1 after addition"),
			() -> assertTrue(emptyList.first() == 0 && emptyList.last() == 0, "Both tail and head should be 0"),
			() -> assertTrue(emptyList.toString().equals("{0}"), "List should include 0")
		);
	}
	
	@Test
	public void add_Last_To_Empty_List_Makes_Tail_And_Head_Same() {
		emptyList.addLast(0);
		assertAll(() -> assertTrue(emptyList.size() == 1, "Size should be 1 after addition"),
			() -> assertTrue(emptyList.first() == 0 && emptyList.last() == 0, "Both tail and head should be 0"),
			() -> assertTrue(emptyList.toString().equals("{0}"), "List should include 0")
		);
	}
	
	@Test
	public void add_First_Shifts_List() {
		testList.addFirst(-1);
		assertAll(() -> assertTrue(testList.size() == 11, "Size should be 11 after addition"),
			() -> assertTrue(testList.first() == -1, "First element should be -1"),
			() -> assertTrue(testList.toString().equals("{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}"), "-1 should be at the front")
		);
	}
	
	@Test
	public void add_Last_Shifts_List() {
		testList.addLast(10);
		assertAll(() -> assertTrue(testList.size() == 11, "Size should be 11 after addition"),
			() -> assertTrue(testList.last() == 10, "Last element should be 10"),
			() -> assertTrue(testList.toString().equals("{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}"), "10 should be at the end")
		);
	}
	
	@Test
	public void zero_Goes_To_End_After_Rotate() {
		testList.rotate();
		assertAll(
			() -> assertTrue(testList.size() == 10, "Size should not change"),
			() -> assertTrue(testList.first() == 1, "1 should be the first"),
			() -> assertTrue(testList.last() == 0, "0 should be at the end"),
			() -> assertTrue(testList.toString().equals("{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}"), "List should be shifted")
		);
	}
	
	@Test
	public void remove_First_Takes_Out_First_Element() {
		assertAll(
			() -> assertTrue(emptyList.removeFirst() == null, "Empty list remove should return null"),
			() -> assertTrue(testList.removeFirst() == 0, "Test list removeFirst should return 0"),
			() -> assertTrue(testList.first() == 1, "First element should be 1 after removal"),
			() -> assertTrue(testList.size() == 9, "Size should be 9 after the removal"),
			() -> assertTrue(testList.toString().equals("{1, 2, 3, 4, 5, 6, 7, 8, 9}"), "List should look like this after removal")
		);
	}
}

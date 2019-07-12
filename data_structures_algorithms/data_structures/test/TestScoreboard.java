package com.uberaemos.data_structures_algorithms.data_structures.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.uberaemos.data_structures_algorithms.data_structures.GameEntry;
import com.uberaemos.data_structures_algorithms.data_structures.Scoreboard;

public class TestScoreboard {
	Scoreboard testBoard;
	Scoreboard fullBoard;
	
	GameEntry game1 = new GameEntry("James", 400);
	GameEntry game2 = new GameEntry("Lemmy", 630);
	GameEntry game3 = new GameEntry("Mikael", 240);
	GameEntry game4 = new GameEntry("Geddy", 330);
	GameEntry game5 = new GameEntry("Tom", 100);
	GameEntry game6 = new GameEntry("Ozzy", 500);
	
	@BeforeEach
	public void init() {
		testBoard = new Scoreboard(4);
		fullBoard = new Scoreboard(4);
		
		fullBoard.add(game1);
		fullBoard.add(game2);
		fullBoard.add(game3);
		fullBoard.add(game4);
	}
	
	@Test
	public void board_Is_Empty_Without_Games_Added() {
		assertTrue(testBoard.toString().equals("{}"));
	}
	
	@Test
	public void games_Are_Added_In_Correct_Order() {
		testBoard.add(game1);
		assertTrue(testBoard.toString().equals("{(James, 400)}"), "List does not contain James' entry correctly");
		testBoard.add(game2);
		assertTrue(testBoard.toString().equals("{(Lemmy, 630), (James, 400)}"), "List does not contain Lemmy's entry correctly");
		testBoard.add(game4);
		testBoard.add(game3);
		assertTrue(testBoard.toString().equals("{(Lemmy, 630), (James, 400), (Geddy, 330), (Mikael, 240)}"), "List does not contain Mikael and Geddy in correct order");
	}
	
	@Test
	public void lower_Score_Entry_Is_Not_Added_When_Board_Is_Full() {
		fullBoard.add(game5);
		assertTrue(fullBoard.toString().equals("{(Lemmy, 630), (James, 400), (Geddy, 330), (Mikael, 240)}"), "Board cannot contain Tom");
	}
	
	@Test
	public void higher_Game_Takes_Out_Lowest_Game() {
		fullBoard.add(game6);
		assertTrue(fullBoard.toString().equals("{(Lemmy, 630), (Ozzy, 500), (James, 400), (Geddy, 330)}"), "Ozzy should take 2nd spot and Mikael should be discarded");
	}
}

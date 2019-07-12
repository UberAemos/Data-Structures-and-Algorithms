package com.uberaemos.data_structures_algorithms.data_structures;
/*
 * Class that stores high scores in an array ascending order
 */
public class Scoreboard {
	// Number of game entries
	private int numEntries = 0;
	
	// Array that holds game entries
	private GameEntry[] board;
	
	// Constructs an empty board with the given capacity
	public Scoreboard(int capacity) {
		board = new GameEntry[capacity];
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{");
		for (int i = 0; i < numEntries; i++) {
			builder.append(board[i].toString());
			if (i < numEntries - 1) builder.append(", ");
		}
		return builder.append("}").toString();
	}
	
	/*
	 * Update methods
	 */
	
	// Adds a new GameEntry to the board if the score is high enough or the capacity is enough
	public void add(GameEntry e) {
		int score = e.getScore();
		
		if (numEntries < board.length || score > board[numEntries-1].getScore()) {
			if (numEntries < board.length) numEntries++;
			
			int j = numEntries - 1;
			// Shift entry j-1 to j if it is smaller than score
			while (j > 0 && board[j-1].getScore() < score) {
				board[j] = board[j -1];
				j--;
			}
			// Add score to the current spot
			board[j] = e;
		}
	}
}

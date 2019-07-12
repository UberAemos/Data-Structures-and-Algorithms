package com.uberaemos.data_structures_algorithms.data_structures;

public class GameEntry {
	// Name of the player that makes the score
	private String name;
	
	// The score value
	private int score;
	
	public GameEntry(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {return name;}
	public int getScore() {	return score;}
	
	
	public String toString() {
		return "(" + name + ", " + score + ")";
	}
}

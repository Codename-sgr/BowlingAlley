package com.sagar.lld.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ScoreBoard {
	private Map<Player, Integer> playerScores;
	private Map<Player, List<List<Integer>>> board;
	
	public ScoreBoard() {
		this.playerScores = new HashMap<Player, Integer>();
		this.board = new HashMap<Player, List<List<Integer>>>();
	}

	public Map<Player, Integer> getPlayerScores() {
		return playerScores;
	}

	public void setPlayerScores(Map<Player, Integer> playerScores) {
		this.playerScores = playerScores;
	}

	public Map<Player, List<List<Integer>>> getBoard() {
		return board;
	}

	public void setBoard(Map<Player, List<List<Integer>>> board) {
		this.board = board;
	}

	public void printScoreBoard() {
		// TODO Auto-generated method stub
		for(Map.Entry<Player, List<List<Integer>>> allPlayersScore: board.entrySet()) {
			System.out.print(allPlayersScore.getKey().getPlayerName()+" : ");
			for(List<Integer> playerScore : allPlayersScore.getValue()) {
				System.out.print("{");
				for(int i:playerScore) {
					if(i==-1) {
						System.out.print("X,");						
					}else {
						if(i==-2) {
							System.out.print("/");
						}else
							System.out.print(i+",");
					}
					
				}
				System.out.print("},");
			}
			System.out.println();
		}
	}
	
	public void printFinalScore() {
		
		System.out.println("FINAL SCOREBOARD");
		Map<Player, Integer> sortedHasMap=sortByValue(playerScores);
		for (Map.Entry<Player, Integer> entry : sortedHasMap.entrySet()) {
			Player key = entry.getKey();
			int val = entry.getValue();
			
			System.out.println(key.getPlayerName()+" - "+val);
			
		}
	}

	private Map<Player, Integer> sortByValue(Map<Player, Integer> playerScores) {
		// TODO Auto-generated method stub
		List<Map.Entry<Player, Integer>> list=new LinkedList<Map.Entry<Player,Integer>>(playerScores.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<Player, Integer>>() {
			@Override
			public int compare(Map.Entry<Player, Integer> o1, Map.Entry<Player, Integer> o2) {
				// TODO Auto-generated method stub
				return ( o1.getValue()).compareTo(o2.getValue());
			}
		});
		
		
		HashMap<Player, Integer> temp=new LinkedHashMap<Player, Integer>();
		for(Map.Entry<Player, Integer> aa:list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}
	
	
	
	
	
}

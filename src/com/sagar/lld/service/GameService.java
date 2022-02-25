package com.sagar.lld.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;import org.w3c.dom.ls.LSInput;

import com.sagar.lld.model.Player;
import com.sagar.lld.model.ScoreBoard;

public class GameService {
	private ScoreBoard board;
	private Queue<Player> players;
	
	public GameService() {
		// TODO Auto-generated constructor stub
		this.board=new ScoreBoard();
		this.players=new LinkedList<Player>();
	}
	
	//Setting Up Game
	
	public void setPlayer(List<Player> player) {
		Map<Player, Integer> playerScores=new HashMap<Player, Integer>();
		for(Player p:player) {
			players.add(p);
			playerScores.put(p, 0);
		}
		board.setPlayerScores(playerScores);
		setScoreBoard(player);
		
	}
	
	
	private void setScoreBoard(List<Player> players) {
		Map<Player, List<List<Integer>>> scoreBoard=new HashMap<Player, List<List<Integer>>>();
		for(Player p:players) {
			scoreBoard.put(p,new ArrayList<List<Integer>>());
		}
		
		board.setBoard(scoreBoard);
	}

	
	// Strike= -1
	// Spare = -2
	public void play(Player currentPlayer, List<Integer> pointsList, int currentPlayerScore) {		
		List<Integer> currentRoundScore=new ArrayList<Integer>();
		List<Integer> bonusRound=null;
		boolean bonus=false;
		
		if(isStrike(pointsList)) {
			currentPlayerScore+=10;
			bonus=true;
			currentRoundScore.add(-1);
		}else if(isSpare(pointsList)) {
			currentPlayerScore+=5;
			bonus=true;
			currentRoundScore.add(pointsList.get(0));
			currentRoundScore.add(-2);
		}else {
			currentRoundScore.add(pointsList.get(0));
			currentRoundScore.add(pointsList.get(1));
		}
		
		board.getBoard().get(currentPlayer).add(currentRoundScore);		
		
		if(pointsList.size()>2) {
			if(bonus) {
				bonusRound=new ArrayList<Integer>();
				if(isStrike(pointsList)) {
					bonusRound.add(pointsList.get(1));
					bonusRound.add(pointsList.get(2));
				}else {
					bonusRound.add(pointsList.get(2));
					bonusRound.add(pointsList.get(3));
				}
				board.getBoard().get(currentPlayer).add(bonusRound);
			}			
		}
		
		int prevScore=board.getPlayerScores().get(currentPlayer);
		board.getPlayerScores().put(currentPlayer, prevScore+currentPlayerScore);
		printScoreBoard(currentPlayer,pointsList);
		
	}

	private boolean isSpare(List<Integer> pointsList) {
		// TODO Auto-generated method stub
		return pointsList.get(0)+pointsList.get(1)==10;
	}

	private boolean isStrike(List<Integer> pointsList) {
		// TODO Auto-generated method stub
		return pointsList.get(0)==10;
	}

	private void printScoreBoard(Player currentPlayer, List<Integer> pointsList) {
		// TODO Auto-generated method stub
		System.out.println("************************************");
		System.out.print(currentPlayer.getPlayerName()+" Score -> ");
		for(int i=1;i<=pointsList.size();i++) {
			System.out.print("Chance"+i+" - "+pointsList.get(i-1)+"pins || ");
		}
		System.out.println();
		System.out.println("************************************");
		printFinalScoreBoard();
	}

	private void printFinalScoreBoard() {
		// TODO Auto-generated method stub
		System.out.println("ScoreBoard : ");
		board.printScoreBoard();
	}
	
	public void printFinalScores() {
		board.printFinalScore();
	}
	
}

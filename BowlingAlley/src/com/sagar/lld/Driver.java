package com.sagar.lld;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.sagar.lld.model.Player;
import com.sagar.lld.service.GameService;

public class Driver {
	public static void main(String[] args) {
		int totalRounds=2;
		Scanner sc=new Scanner(System.in);
		System.out.println("Number of players: ");
		int noOfPlayers=sc.nextInt();
		
		Queue<Player> players=new LinkedList<Player>();
		List<Player> playerList=new ArrayList<Player>();
		
		for(int i=0;i<noOfPlayers;i++) {
			System.out.println("Enter Name of Player"+(i+1)+" : ");
			Player p=new Player(sc.next());
			playerList.add(p);
			players.add(p);
		}
		
		GameService game=new GameService();
		game.setPlayer(playerList);
		
		int currentRound=1;
		Player currentPlayer=null;
		
		while(currentRound<=totalRounds){
			for(int j=0;j<noOfPlayers;j++) {
				currentPlayer=players.poll();
				
				
				int chancesPerRound=2;
				List<Integer> pointsList=new ArrayList<Integer>();
				int currentPlayerScore=0;
				for(int i=1;i<=chancesPerRound;i++) {
					System.out.println("Enter Score for "+currentPlayer.getPlayerName()+" - Chance"+i+": ");
					int point=sc.nextInt();
					pointsList.add(point);
					currentPlayerScore+=point;
					if(currentPlayerScore==10) {
						if(currentRound==totalRounds) {
							chancesPerRound=i+2;							
						}else {
							break;
						}
					}
				}
				
				game.play(currentPlayer,pointsList,currentPlayerScore);
				players.add(currentPlayer);				
			}
			currentRound++;
		}
		game.printFinalScores();
	}

}

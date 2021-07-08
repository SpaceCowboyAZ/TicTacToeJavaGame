package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> Playerplacement = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPlacement = new ArrayList<Integer>();
		
	public static void main(String[] args) {
		
	
		char[][] gameBoard = {{' ',  '|',  ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ',  '|',  ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ',  '|',  ' ', '|', ' '}};
			
		printGameBoard(gameBoard);
				
				while(true) {
					Scanner scan = new Scanner(System.in);
				System.out.println("Enter placement 1 -9");
				int placement = scan.nextInt();
				while(Playerplacement.contains(placement) || cpuPlacement.contains(Playerplacement)) {
					System.out.println("Position is already taken");
				}			
			
		
				placePiece(gameBoard, placement, "player");
				
				
				Random random = new Random();
				int cpuPos = random.nextInt(9) + 1;
				while(Playerplacement.contains(cpuPlacement) || cpuPlacement.contains(cpuPos)) {
					System.out.println("Position is already taken"); 
					cpuPos = random.nextInt(9) + 1;
				}
				placePiece(gameBoard, cpuPos, "cpu");
				
				printGameBoard(gameBoard);
				
				String result = checkWin();
				System.out.println(result);
				}
				
	}

public static void printGameBoard(char[][] gameBoard) {
	for(char[] row : gameBoard) {
		for(char c : row) {
				System.out.print(c);
			}
		System.out.println();
		}

	}

public static void placePiece(char[][] gameBoard, int placement, String user) {
	
	char symbol = ' ';
	if(user.equals("player")) {
		symbol = 'X';
		Playerplacement.add(placement);
	} else if(user.equals("cpu")) {
			symbol = 'O';
			cpuPlacement.add(placement);
	}
	
	switch(placement) {
	case 1: 
		gameBoard[0][0] = symbol;
		break;
	case 2: 
		gameBoard[0][2] = symbol;
		break;
	case 3: 
		gameBoard[0][4] = symbol;
		break;
	case 4: 
		gameBoard[2][0] = symbol;
		break;
	case 5: 
		gameBoard[2][2] = symbol;
		break;
	case 6: 
		gameBoard[2][4] = symbol;
		break;
	case 7: 
		gameBoard[4][0] = symbol;
		break;
	case 8: 
		gameBoard[4][2] = symbol;
		break;
	case 9: 
		gameBoard[4][4] = symbol;
		break;
		default:
			break;
		
}
}

public static String checkWin() {
	
	List topRow = Arrays.asList(1, 2, 3);

	List bottomRow = Arrays.asList(7, 8, 9);

	List midRow = Arrays.asList(4, 5, 6);

	List leftColumn = Arrays.asList(1, 4, 7);

	List rightColumn = Arrays.asList(3, 6, 9);

	List middleColumn = Arrays.asList(8, 5, 8);

	List diag1 = Arrays.asList(1, 5, 9);

	List diag2 = Arrays.asList(7, 5, 3);
	
	List<List> win = new ArrayList<List>();
	win.add(topRow);
	win.add(bottomRow);
	win.add(midRow);
	win.add(leftColumn);
	win.add(rightColumn);
	win.add(middleColumn);
	win.add(diag1);
	win.add(diag2);
	
	for (List l : win) {
		if(Playerplacement.containsAll(l)) {
			return "Player won";
		} else if(cpuPlacement.contains(l)) {
			return "CPU wins! Fatality";
		} else if(Playerplacement.size() + cpuPlacement.size() == 9) {
			return "tie";
		}
	}
	
	return "";
	
}
}

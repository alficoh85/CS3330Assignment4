package hw4.simulation;

import java.util.Scanner;

import hw4.game.Game;
import hw4.maze.Row;
import hw4.player.Movement;
import hw4.player.Player;

public class Main {

	public static void main(String[] args) {
		Game game = new Game(5);
		Row bottomRow = game.getGrid().getRowAtIndex(4);
		Player player = new Player(bottomRow, bottomRow.getCellAtIndex(4));
		Scanner input = new Scanner(System.in);
		int movementInput;
		boolean movementAttempt;
		boolean movementSuccess = false;
		
		while (game.isEscaped() == false) {
			System.out.println("Current Board\n" + game.getGridVisualization(player));
			

			System.out.println("\n1 - Move Up");
			System.out.println("2 - Move Down");
			System.out.println("3 - Move Left");
			System.out.println("4 - Move Right");
			System.out.println("Which way would you like to move? (Enter a valid number): ");
			try {
				movementInput = input.nextInt();
				switch (movementInput) {
					case 1:
						movementAttempt = true;
						movementSuccess = game.play(Movement.UP, player);
						break;
					case 2:
						movementAttempt = true;
						movementSuccess = game.play(Movement.DOWN, player);
						break;
					case 3:
						movementAttempt = true;
						movementSuccess = game.play(Movement.LEFT, player);
						break;
					case 4:
						movementAttempt = true;
						movementSuccess = game.play(Movement.RIGHT, player);
						break;
					default:
						movementAttempt = false;
						System.out.println("\nInput was invalid. Please input a valid number.\n");
				}
				if (movementAttempt == true) {
					if (movementSuccess == true) {
						System.out.println("\nMovement successful!\n");
					}
					else {
						System.out.println("\nMovement failed. Either there is a wall there or you tried to move out of bounds.\n");
					}
				}
			}
			catch (Exception e) {
				System.out.println("\nInput was invalid. Please input a valid number.\n");
			}
		}
		System.out.println("Congratulations! You escaped!");
	}
}
import java.util.Scanner;

public class BattleShip {

	public static void main(String[] args) {

		int[][] com = new int[8][8];
		int[][] pla = new int[8][8];
		char[] sym = { '-', 'O', 'X', '#', '*'};
		int plaX = 0, plaY = 0;
		int comX = 0, comY = 0;
		int shootx = 0, shooty = 0;
		int lifPla = 4, lifCom = 4;
		boolean playerTurn = true;

		Scanner scan = new Scanner(System.in);
		
		// BLANK GROUND
		System.out.print("   ");
		for (int i = 0; i < 8; i++) {
			System.out.print("|"+(i+1));
		}
		System.out.print("|\n   ");
		for (int i = 0; i < 8; i++) {
			System.out.print("__");
		}
		System.out.print("_");
		System.out.println();
        ////////////////////////////////////////
		for (int i = 0; i < 8; i++) {
			System.out.print((i+1)+" | ");
			for (int j = 0; j < 8; j++) {
				System.out.print(sym[0]+" ");
			}
			System.out.println();
		}
       ////////////////////////////////////////
		System.out.println("    ===============");
       ////////////////////////////////////////
		for (int i = 0; i < 8; i++) {
			System.out.print((i+1)+" | ");
			for (int j = 0; j < 8; j++) {
				if (pla[i][j] == 0) {
					System.out.print(sym[0]+" ");
				} else if (pla[i][j] == 1) {
					System.out.print(sym[1]+" ");
				} else if (pla[i][j] == 2) {
					System.out.print(sym[2]+" ");
				}
			}
			System.out.println();
		}
      ////////////////////////////////////////
		System.out.print("   ");
		for (int i = 0; i < 8; i++) {
			System.out.print("__");
		}
		System.out.print("_");

		// PLAYER SHIP INITIALIZATION
		for (int i = 0; i < 4; i++) {
			System.out.println("\n\nEnter the coordinates of your Ship No " + (i + 1) + " -");
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					System.out.print("Enter the X coordinate :");
					plaX = (scan.nextInt() - 1);
				} else {
					System.out.print("Enter the Y coordinate :");
					plaY = (scan.nextInt() - 1);
				}

			}
			if (pla[plaX][plaY] == 1) {
				System.out.println("POSITION ALREADY TAKEN! CHOSE ANOTHER LOCATION");
				i--;
			} else {
				pla[plaX][plaY] = 1;
			}

		}

		// COMPUTER SHIP INITIALIZATION
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 2; j++) {
				int randomInt = (int) (8.0 * Math.random());
				if (j == 0) {
					comX = randomInt;
				} else {
					comY = randomInt;
				}
			}
			if (com[comX][comY] == 1) {
				i--;
			} else {
				com[comX][comY] = 1;
			}
		}

		///// BATTEL GROUND /////
		while (lifCom > 0 && lifPla > 0) {
			if (playerTurn == true) {
				System.out.println("\nPLAYER TURN (Life Remaining : "+lifPla+")\n");
			} else {
				System.out.println("\nCOMPUTER TURN (Life Remaining : "+lifCom+")\n");
			}
			
			System.out.print("   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("|"+(i+1));
			}
			System.out.print("|\n   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("__");
			}
			System.out.print("_");
			System.out.println();
           ////////////////////////////////////////
			for (int i = 0; i < 8; i++) {
				System.out.print((i+1)+" | ");
				for (int j = 0; j < 8; j++) {
					if (com[j][i] == 0) {
						System.out.print(sym[0]+" ");
					} else if (com[j][i] == 1) {
						System.out.print(sym[0]+" ");
					} else if (com[j][i] == 2) {
						System.out.print(sym[2]+" ");
					} else if (com[j][i] == 3) {
						System.out.print(sym[3]+" ");
					} else if (com[j][i] == 4) {
						System.out.print(sym[4]+" ");
					}  
				}
				System.out.println();
			}
           ////////////////////////////////////////
			System.out.println("    ===============");
           /////////////////////////////////////////
			for (int i = 0; i < 8; i++) {
				System.out.print((i+1)+" | ");
				for (int j = 0; j < 8; j++) {
					if (pla[i][j] == 0) {
						System.out.print(sym[0]+" ");
					} else if (pla[i][j] == 1) {
						System.out.print(sym[1]+" ");
					} else if (pla[i][j] == 2) {
						System.out.print(sym[2]+" ");
					}
				}
				System.out.println();
			}
		   ////////////////////////////////////////
			System.out.print("   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("__");
			}
			System.out.println("_");

			if (playerTurn == true) {
				System.out.print("\nTarget Row (Vertical)      : ");
				shootx = (scan.nextInt() - 1);
				System.out.print("Target Column (Horizontal) : ");
				shooty = (scan.nextInt() - 1);
				if (com[shootx][shooty] == 1) {
					com[shootx][shooty] = 2;
					lifCom--;
					System.out.println("COM : You sunk my ship!! Bitch!!");
				}else if(((shootx != 0 && shooty != 0) && (shootx != 7 && shooty != 7)) &&
						((com[shootx-1][shooty-1] == 1 || com[shootx][shooty-1] == 1 || com[shootx+1][shooty-1] == 1) ||
						(com[shootx-1][shooty] == 1 || com[shootx+1][shooty] == 1) ||
						(com[shootx-1][shooty+1] == 1 || com[shootx][shooty+1] == 1 || com[shootx+1][shooty+1] == 1))) {
					
					com[shootx][shooty] = 4;
					
				}else {
					com[shootx][shooty] = 3;
				}
				playerTurn = false;
			} else {
				for (int j = 0; j < 2; j++) {
					int randomInt = (int) (8.0 * Math.random());
					if (j == 0) {
						shootx = randomInt;
						System.out.println("\nTarget Row (Vertical)      : " + (shootx+1));
					} else {
						shooty = randomInt;
						System.out.println("Target Column (Horizontal) : " + (shooty+1));
					}
				}

				if (pla[shooty][shootx] == 1) {
					pla[shooty][shootx] = 2;
					lifPla--;
					System.out.println("PLAYER : You sunk my ship! Motherfucker!!");
				}
				playerTurn = true;
			}
		}

		// FINAL RESULT
		if (lifPla == 0 || lifCom == 0) {
			System.out.print("\n   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("|"+(i+1));
			}
			System.out.print("|\n   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("__");
			}
			System.out.print("_");
			System.out.println();
			for (int i = 0; i < 8; i++) {
				System.out.print((i+1)+" | ");
				for (int j = 0; j < 8; j++) {
					if (com[j][i] == 0 || com[j][i] == 1) {
						System.out.print(sym[0]+" ");
					} else if (com[j][i] == 2) {
						System.out.print(sym[2]+" ");
					} else if (com[j][i] == 3) {
						System.out.print(sym[3]+" ");
					} else if (com[j][i] == 4) {
						System.out.print(sym[4]+" ");
					} 
				}
				System.out.println();
			}

			System.out.println("    ===============");

			for (int i = 0; i < 8; i++) {
				System.out.print((i+1)+" | ");
				for (int j = 0; j < 8; j++) {
					if (pla[j][i] == 0) {
						System.out.print(sym[0]+" ");
					} else if (pla[j][i] == 1) {
						System.out.print(sym[1]+" ");
					} else if (pla[j][i] == 2) {
						System.out.print(sym[2]+" ");
					}
				}
				System.out.println();
			}
			System.out.print("   ");
			for (int i = 0; i < 8; i++) {
				System.out.print("__");
			}
			System.out.println("_");
			
			if (lifCom == 0) {
				System.out.print("Player Wins!");
			} else if (lifPla == 0) {
				System.out.print("Computer Wins!");
			}
		}
		scan.close();
	}
}

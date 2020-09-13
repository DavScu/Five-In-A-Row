import java.util.Scanner;
public class board{
				
				
	public static boolean isOdd(int a){
		if (a % 2 == 1){
			return true;
		}else{
			return false;
		}
	}

	public static String[][] buildBoard(){
		Scanner scanRow = new Scanner(System.in);
		System.out.print("Enter the board's row: ");
		String s = scanRow.nextLine();
		int height = Integer.parseInt(s);
		Scanner scanCol = new Scanner(System.in);
		System.out.print("Enter the board's colume: ");
		String z = scanCol.nextLine();
		int width = Integer.parseInt(z);
		String[][] board = new String[height * 2 + 1][width * 2 + 1];
		for (int i = 0; i < board.length; i ++ ){
			for (int j = 0; j < board[i].length; j ++ ){
				boolean rowBoo = isOdd(i);
				boolean colBoo = isOdd(j);
				if(!rowBoo){
					if(!colBoo){
						board[i][j] = " ";
				}else{
					board[i][j] = "-";
				}
				}else{
					if(!colBoo){
						board[i][j] = "|";
					}else{
						board[i][j] = " ";
					}
				}
			}
				}
		
		return board;
		}


	public static void play(String[][] board, Boolean pointer){

		if(pointer){
			System.out.println("It's O's turn!!!");

			System.out.print("Enter the row: ");
			Scanner putRow = new Scanner(System.in);
			int placeRow = Integer.parseInt(putRow.nextLine());

			System.out.print("Enter the colume: ");
			Scanner putCol = new Scanner(System.in);
			int placeCol = Integer.parseInt(putCol.nextLine());
			if(canStep(board, placeRow, placeCol)){
				board[placeRow * 2 - 1][placeCol * 2 - 1] = "O";
			}else{
				System.out.print("You can't place your point on a existed point!! U lost your chance for this turn!");
			}
			


		}else{
			System.out.println("It's X's turn!!!");

			System.out.print("Enter the row: ");
			Scanner putRow = new Scanner(System.in);
			int placeRow = Integer.parseInt(putRow.nextLine());

			System.out.print("Enter the colume: ");
			Scanner putCol = new Scanner(System.in);
			int placeCol = Integer.parseInt(putCol.nextLine());
			if(canStep(board, placeRow, placeCol)){
				board[(placeRow) * 2 - 1][(placeCol) * 2 - 1] = "X";
			}else{
				System.out.print("You can't place your point on a existed point!! U lost your chance for this turn!");
			}
			
		}


		
	}

	public static boolean canStep(String[][] board, int row, int col){
		return (board[(row) * 2 - 1][(col) * 2 - 1].equals(" "));
	}


	public static void printBoard(String[][] board){
		for(int i = 0; i < board.length; i ++){
			for (int j = 0; j < board[i].length; j ++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static boolean isOver(String[][] board, int row, int col){
		int count = 0;
		int squareSizeRow = (board.length - 1) / 2;
		int squareSizeCol = (board[0].length - 1) / 2;
		String[][] newBoard = new String[squareSizeRow][squareSizeCol];
		for(int i = 0; i < newBoard.length; i ++){
			for (int j = 0; j < newBoard[i].length; j ++){
				newBoard[i][j] = board[2 * i - 1][2 * j - 1];
			}
		}


	}




	public static void main(String[] args){
		Boolean pointer = false;
		boolean finished = false;

		String[][] board = buildBoard();
		printBoard(board);
		
		while(!finished){
			pointer = !pointer;
			play(board, pointer);
			printBoard(board);
		}
			
		
	}
}

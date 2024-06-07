package fifteenpuzzle;

import java.io.*;
import java.util.*;

public class FifteenPuzzle {
	public final static int UP = 0;
	public final static int DOWN = 1;
	public final static int LEFT = 2;
	public final static int RIGHT = 3;

	// size of board
	public final static int SIZE = 4;
	int[][] board;

	
	/**
	 * @param fileName 
	 * @throws FileNotFoundException if file not found
	 * @throws BadBoardException if the board is incorrectly formatted
	 * Reads a board from file and creates the board
	 */
	public FifteenPuzzle(String fileName) throws IOException, BadBoardException {
		// TODO implement me
		board = new int[SIZE][SIZE];
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null && row < 4) {
				String[] values = line.trim().split("\\s+"); // split by whitespace
				for (int col = 0; col < values.length && col < 4; col++) {
					if (!values[col].isEmpty()) {
						board[row][col] = Integer.parseInt(values[col]);
					} else {
						System.out.println("hello empty");
						board[row][col] = 0;
					}
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		printBoard();
	}

	
	/**
	 * Get the number of the tile, and moves it to the specified direction
	 * 
	 * @throws IllegalMoveException if the move is illegal
	 */
	public void makeMove(int tile, int direction) throws IllegalMoveException {
		// TODO implement me
	}

	
	/**
	 * @return true if and only if the board is solved,
	 * i.e., the board has all tiles in their correct positions
	 */
	public boolean isSolved() {
		// TODO implement me
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// TODO implement me
		StringBuilder result = new StringBuilder();
        for (int[] row : board) {
            for (int j = 0; j < row.length; j++) {
                int col = row[j];
				if (col == 0){
					continue;
				}
                if (col < 10) {
                    result.append(" ");
                }
				result.append(col);
                if (j < row.length - 1) {
                    result.append("\t");
                }
            }
            result.append("\n");
        }
		return result.toString();
	}
	private void printBoard(){
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
	}
}

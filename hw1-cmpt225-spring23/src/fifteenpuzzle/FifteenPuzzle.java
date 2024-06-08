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
		board = new int[SIZE][SIZE];

		File file = new File(fileName);
		if (!file.exists()) {
			throw new FileNotFoundException("The file " + fileName + " does not exist.");
		}
		readFromFile(fileName);

		checkBoard();
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
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
        for (int[] row : board) {
            for (int j = 0; j < row.length; j++) {
                int col = row[j];
				if (col == 0){
					result.append((char) 32).append((char) 32);
				}
				else{
					if (col < 10) {
						result.append((char) 32);
					}
					result.append(col);
				}
                if (j < row.length - 1) {
                    result.append((char) 32);
                }
            }
            result.append((char) 10);
        }
		return result.toString();
	}
	private void readFromFile(String fileName){
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			int row = 0;
			while ((line = br.readLine()) != null && row < SIZE) {
				String[] values = line.split("(?<=\\G.{3})"); //split the string every 3 characters

				for (int col = 0; col < values.length && col < SIZE; col++) {
					String value = values[col].trim();
					if (!value.isEmpty()) {
						board[row][col] = Integer.parseInt(value);
					} else {
						board[row][col] = 0;
					}
				}
				row++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//void instead of boolean because we want to throw exception at where error occurs
	private void checkBoard() throws BadBoardException{
		boolean[] seen = new boolean[SIZE*SIZE];

		for (int[] row : board) {
			for (int num : row) {
				if (num < 0 || num >= SIZE*SIZE || seen[num]) { //0 because we store 0 in our 2d array
					throw new BadBoardException("bad board");
				}
				seen[num] = true; // Mark the number as seen
			}
		}

		// Check if all numbers from 1 to 15 have been seen
		for (int i = 0; i <= SIZE*SIZE - 1; i++) {
			if (!seen[i]) {
				throw new BadBoardException("missing number");
			}
		}
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

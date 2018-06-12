package ru.yandex.sergaidm;

public class Board {

	private Shape[] board = new Shape[4];

	public Board(Shape[] board) {
		super();
		this.board = board;
	}

	public Board() {
		super();
	}

	public Shape[] getBoard() {
		return board;
	}

	public void setBoard(Shape[] board) {
		this.board = board;
	}

	public void putShapeOnBoard(int position, Shape shape) {
		if ((position >= 0) && (position < board.length) && (board[position] == null)) {
			board[position] = shape;
		}
	}

	public void deleteShapeFromBoard(int position) {
		if ((position >= 0) && (position < board.length && (board[position] == null))) {
			board[position] = null;
			System.out.println("Shape deleted");
		} else {
			System.out.println("Wrong position");
		}
	}

	public double areaOfAllShapes() {
		double area = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i] != null) {
				area += board[i].getArea();
			}
		}
		return area;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tInformation about figures on the board:" + System.lineSeparator() + System.lineSeparator());
		for (int i = 0; i < board.length; i++) {
			sb.append("  " + (i + 1) + " part - ");
			String text = "";
			if (board[i] != null) {
				text = String.format("%-10.10s Perimeter = %-5.5s   Area = %.2f",
						board[i].getClass().getSimpleName() + ":", board[i].getPerimeter(), board[i].getArea());
			} else {
				text = "Free space on the board";
			}
			sb.append(text + System.lineSeparator());
		}
		sb.append(System.lineSeparator() + String.format("Total area of all figures on the board = %.2f", areaOfAllShapes()));
		return sb.toString();
	}
	
}

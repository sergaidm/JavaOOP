package ru.yandex.sergaidm;

public class Board {

	private Shape[] figure = new Shape[4];

	public Board(Shape[] figure) {
		super();
		this.figure = figure;
	}

	public Board() {
		super();
	}

	public Shape[] getFigure() {
		return figure;
	}

	public void setFigure(Shape[] figure) {
		this.figure = figure;
	}

	public void placeFigOnBoard(int board, Shape shape) {
		if ((board >= 0) & (board < 4)) {
			figure[board] = shape;
		}
	}

	public void delFigfromBoard(int board) {
		if ((board >= 0) & (board < 4)) {
			figure[board] = null;
		}
	}

	public double areaOfAllFig() {

		double S = 0;
		for (int i = 0; i < figure.length; i++) {
			if (figure[i] != null) {
				S += figure[i].getArea();
			}
		}
		return S;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tInformation about figures on the board:" + System.lineSeparator() + System.lineSeparator());
		for (int i = 0; i < figure.length; i++) {
			sb.append("  " + (i + 1) + " part - ");
			String text = "";
			if (figure[i] != null) {
				text = String.format("%-10.10s Perimeter = %-5.5s   Area = %.2f",
						figure[i].getClass().getSimpleName() + ":", figure[i].getPerimetr(), figure[i].getArea());
			} else {
				text = "Free space on the board";
			}
			sb.append(text + System.lineSeparator());
		}
		sb.append(System.lineSeparator() + String.format("Total area of all figures on the board = %.2f", areaOfAllFig()));
		return sb.toString();
	}
}

package ru.yandex.sergaidm;

//Create abstract class Shape. Create class Point with two properties: double x and double y.
//Create classes - subclasses of Shape with properties of class Point, which describe three geometric shapes.
//Create class Board. Board is divided into 4 parts, in each of which you can place one of the figures.
//The board should have methods that put figure to the board and remove figure from the board. 
//There must also be method that displays information about all figures on the board and their total area.

public class Main {

	public static void main(String[] args) {

		Triangle tr = new Triangle(new Point(1, 1), new Point(3, 1), new Point(2, 5));
		Square sq = new Square(new Point(1, 1), new Point(1, 6), new Point(6, 6), new Point(6, 1));
		Circle cr = new Circle(new Point(0, 6), new Point(0, 0));

		Shape sp1 = tr;
		Shape sp2 = sq;
		Shape sp3 = cr;

		Board board = new Board();
		board.placeFigOnBoard(0, sp1);
		board.placeFigOnBoard(1, sp2);
		board.placeFigOnBoard(2, sp3);
		System.out.println(board);
		System.out.println();

		board.placeFigOnBoard(3, sp2);
		System.out.println(board);
		System.out.println();

		board.delFigfromBoard(0);
		board.delFigfromBoard(1);
		System.out.println(board);

	}

}

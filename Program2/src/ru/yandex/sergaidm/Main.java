package ru.yandex.sergaidm;

public class Main {

	public static void main(String[] args) {

		Triangle triangle = new Triangle(new Point(1, 1), new Point(3, 1), new Point(2, 5));
		Rectangle rectangle = new Rectangle(new Point(1, 1), new Point(1, 6), new Point(6, 6), new Point(6, 1));
		Circle circle = new Circle(new Point(0, 6), new Point(0, 0));

		Shape shapeOne = triangle;
		Shape shapeTwo = rectangle;
		Shape shapeThree = circle;

		Board board = new Board();
		board.putShapeOnBoard(0, shapeOne);
		board.putShapeOnBoard(1, shapeTwo);
		board.putShapeOnBoard(2, shapeThree);
		System.out.println(board);
		System.out.println();

		board.putShapeOnBoard(3, shapeTwo);
		System.out.println(board);
		System.out.println();

		board.deleteShapeFromBoard(0);
		board.deleteShapeFromBoard(1);
		System.out.println(board);

	}

}

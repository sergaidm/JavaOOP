package ru.yandex.sergaidm;

public class MultiThreadSorting {

	public static void sort(int[] array, int threadNumber) {
		SingleThreadSorting[] threadArray = new SingleThreadSorting[threadNumber];
		for (int i = 0; i < threadArray.length; i++) {
			int size = array.length / threadNumber;
			int begin = size * i;
			int end = ((i + 1) * size);
			if ((array.length - end) < size) {
				end = array.length;
			}
			threadArray[i] = new SingleThreadSorting(array, begin, end);
		}
		for (int i = 0; i < threadArray.length; i++) {
			try {
				threadArray[i].getThread().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		System.arraycopy(mergeArrays(array, threadArray), 0, array, 0, array.length);
	}

	private static int[] mergeArrays(int[] arrayOne, SingleThreadSorting[] threadArray) {
		int[] arrayTwo = new int[arrayOne.length];
		for (int i = 0; i < arrayTwo.length; i++) {
			int min = Integer.MAX_VALUE;
			int k = -1;
			for (int j = 0; j < threadArray.length; j++) {
				if (!threadArray[j].isStop() && min > threadArray[j].peekElement()) {
					min = threadArray[j].peekElement();
					k = j;
				}
			}
			if (k != -1) {
				arrayTwo[i] = threadArray[k].pollElement();
			}
		}
		return arrayTwo;
	}
	
}
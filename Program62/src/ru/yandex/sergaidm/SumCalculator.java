package ru.yandex.sergaidm;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumCalculator implements Callable<Long> {

	private final int[] array;
	private final int from;
	private final int to;

	public SumCalculator(int[] array, int from, int to) {
		super();
		this.array = array;
		this.from = from;
		this.to = to;
	}

	public static long simpleSumCalculation(int[] array) {
		long sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static long multithreadingSumCalculation(int[] array, int threadsCount, int partLength) {

		ExecutorService service = Executors.newFixedThreadPool(threadsCount);
		CompletionService<Long> cS = new ExecutorCompletionService<>(service);
		
		int offset = 0;
		long result = 0;

		try {
			for (int i = 0; i < threadsCount; i++) {
				SumCalculator counter = new SumCalculator(array, offset, offset + partLength);
				offset += partLength;
				cS.submit(counter);
			}

			for (int i = 0; i < threadsCount; i++) {
				try {
					Future<Long> future = cS.take();
					result += future.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
					return result;
				}
			}
		} finally {
			service.shutdownNow();
		}
		return result;
	}

	@Override
	public Long call() throws Exception {
		long res = 0;
		for (int i = from; i < to; i++) {
			res += array[i];
		}
		return res;
	}

}

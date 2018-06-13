package ru.yandex.sergaidm;

public class SingleThreadSorting implements Runnable {
	
	private int[] array;
	private int begin;
	private int end;
	private Thread thread;
	private int index;
	private boolean stop = false;

	public SingleThreadSorting(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thread = new Thread(this);
		thread.start();
		this.index = begin;
	}

	public Thread getThread() {
		return thread;
	}

	public int peekElement() {
		return array[index];
	}

	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}

	public boolean isStop() {
		return stop;
	}

	@Override
	public void run() {
		int j;
		int temp;
		for (begin = end / 2; begin > 0; begin /= 2) {
			for (int i = begin; i < end; i++) {
				temp = array[i];
				for (j = i; j >= begin; j -= begin) {
					if (temp < array[j - begin])
						array[j] = array[j - begin];
					else
						break;
				}
				array[j] = temp;
			}
		}
	}

	private void check() {
		this.index++;
		if (this.index >= this.end) {
			this.stop = true;
		}
	}
	
}
package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileOperations implements Runnable {

	private static final int THREADS_COUNT = 10;
	private File folderSource;
	private File folderReceiver;
	private int number;

	public FileOperations(File folderSource, File folderReceiver, int number) {
		super();
		this.folderSource = folderSource;
		this.folderReceiver = folderReceiver;
		this.number = number;
	}

	public FileOperations() {
		super();
	}

	public static void createFiles(File folderSource, int number) {
		File[] files = new File[number];
		for (int i = 0; i < files.length; i++) {
			String pathname = number + ".txt";
			files[i] = new File(folderSource.getAbsolutePath() + "\\" + pathname);
			try {
				files[i].createNewFile();
				try (PrintWriter pw = new PrintWriter(files[i])) {
					String text = "";
					StringBuilder sb = new StringBuilder();
					for (int j = 1; j <= 1000000; j++) {
						int n = (int) (Math.random() * 100);
						text = Integer.toString(n);
						sb.append(text + " ");
						if (j % 50 == 0) {
							sb.append(System.lineSeparator());
						}
					}
					text = sb.toString();
					pw.println(text);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println(e);
			}
			number--;
		}
	}

	private static void fileCopy(File folderSource, File folderReceiver, int number) throws IOException {
		File[] files = new File[number];
		for (int i = 0; i < files.length; i++) {
			String pathname = number + ".txt";
			File in = new File(folderSource.getAbsolutePath() + "\\" + pathname);
			File out = new File(folderReceiver.getAbsolutePath() + "\\" + pathname);
			byte[] buffer = new byte[1024 * 1024];
			int readByte = 0;
			try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
				for (; (readByte = fis.read(buffer)) > 0;) {
					fos.write(buffer, 0, readByte);
				}
			} catch (IOException e) {
				throw e;
			}
			number--;
		}
	}

	public static void multithreadingCopyingFiles(File folderSource, int number) {
		File folderReceiver = new File("Receiver");
		folderReceiver.mkdir();
		ExecutorService pool = Executors.newFixedThreadPool(THREADS_COUNT);
		try {
			for (int i = 0; i < THREADS_COUNT; i++) {
				FileOperations copying = new FileOperations(folderSource, folderReceiver, number);
				pool.execute(copying);
			}
		} finally {
			pool.shutdownNow();
		}
	}

	@Override
	public void run() {
		try {
			fileCopy(folderSource, folderReceiver, number);
			System.out.println(Thread.currentThread().getName() + ": Files copied to receiver folder");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completed the work");
	}

}

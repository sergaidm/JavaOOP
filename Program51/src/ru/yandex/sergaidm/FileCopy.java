package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopy {

	public static void fileCopy(File in, File out) throws IOException {
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		try (FileInputStream fis = new FileInputStream(in); FileOutputStream fos = new FileOutputStream(out)) {
			for (; (readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}

		} catch (IOException e) {
			throw e;
		}
	}

	public static void folderCopy(File folderSource, File folderReceiver, MyFileFilter mFF) throws IOException {
		File[] fileList = folderSource.listFiles(mFF);
		for (File file : fileList) {
			try {
				Files.copy(file.toPath(), new File("E:/Receiver" + File.separator + file.getName()).toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
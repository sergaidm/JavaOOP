package ru.yandex.sergaidm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperation {

	public static void fileCopy(File in, File out) throws IOException {
		if (in == null || out == null) {
			throw new IllegalArgumentException("Empty file pointer");
		}
		byte[] buffer = new byte[1024 * 1024];
		int readByte = 0;
		try (InputStream fis = new FileInputStream(in); OutputStream fos = new FileOutputStream(out)) {
			for (; (readByte = fis.read(buffer)) > 0;) {
				fos.write(buffer, 0, readByte);
			}

		} catch (IOException e) {
			throw e;
		}
	}

	public static void folderCopy(File folderSource, File folderReceiver, FileFilterImplementation ffi) throws IOException {
		if (folderSource == null || folderReceiver == null || ffi == null) {
			throw new IllegalArgumentException("Empty file pointer");
		}
		File[] fileList = folderSource.listFiles(ffi);
		for (File file : fileList) {
			try {
				fileCopy(file, new File(folderReceiver, file.getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
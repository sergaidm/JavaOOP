package ru.yandex.sergaidm;

import java.io.File;

public class FileUtils {

	public static void fileCopy(File from, File to) {
		BlockCopyController bcc = new BlockCopyController();
		ReadBlock read = new ReadBlock(bcc, from);
		WriteBlock write = new WriteBlock(bcc, to);
		ProgressPrint prn = new ProgressPrint(bcc, from);
		Thread readThread = new Thread(read);
		Thread writeThread = new Thread(write);
		Thread printThread = new Thread(prn);
		readThread.start();
		writeThread.start();
		printThread.start();
	}

}
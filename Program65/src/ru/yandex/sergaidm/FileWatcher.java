package ru.yandex.sergaidm;

import java.io.File
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileWatcher implements Runnable {

	private File mainFolder;
	private File[] filesArray;

	public FileWatcher(File mainFolder) {
		super();
		this.mainFolder = mainFolder;
		filesArray = this.mainFolder.listFiles();
	}

	public FileWatcher() {
		super();
	}

	public File getMainFolder() {
		return mainFolder;
	}

	private String getFolderInfo() {
		if (mainFolder == null) {
			return "None";
		}
		File[] fileArray = mainFolder.listFiles();
		String text = "";
		if (filesArray.length < fileArray.length) {
			text = "New file is created" + System.lineSeparator();
		}
		if (filesArray.length > fileArray.length) {
			text = "File is deleted" + System.lineSeparator();
		}
		filesArray = fileArray;
		return text;
	}

	public void startFileWatcher() {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS);
		try {
			service.awaitTermination(60, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			service.shutdown();
			if (service.isShutdown() == true) {
				System.out.println("File watcher completed its work");
			}
		}
	}

	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy   hh:mm:ss");
		System.out.println(sdf.format(System.currentTimeMillis()));
		System.out.println(getFolderInfo());
	}

}

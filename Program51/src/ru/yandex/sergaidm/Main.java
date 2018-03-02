package ru.yandex.sergaidm;

/*Write a program that copies files with a predefined 
 * extension (for example, only txt) from the source directory to the 
 * directory-receiver./
 */

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		MyFileFilter mFF = new MyFileFilter("txt");
		File folderSource = new File("E:/Source");
		File folderReceiver = new File("E:/Receiver");

		try {
			FileCopy.folderCopy(folderSource, folderReceiver, mFF);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("Files from folder are copied to the new folder.");

	}

}

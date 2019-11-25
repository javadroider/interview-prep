/**
 * 
 */
package com.javadroider.interviewprep.threads.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *
 */
public class ListFilesRecursive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List<String> files = listFiles(new File("D:/Work/softwares"));
		long end = System.currentTimeMillis();
	//	System.out.println(files);
		System.out.println(files.size());
		System.out.println((end-start)/1000);
	}

	private static List<String> listFiles(File file) {
		List<String> files = new ArrayList<String>();
		if (file.isFile()) {
			files.add(file.getAbsolutePath());
			return files;
		} else {
			File[] fileObjects = file.listFiles();
			if (null != fileObjects) {
				for (File fileObject : fileObjects) {
					if (fileObject.isFile()) {
						files.add(fileObject.getAbsolutePath());
					} else {
						List<String> returnedfiles = listFiles(fileObject);
						files.addAll(returnedfiles);
					}
				}
			}
			return files;
		}
	}
}

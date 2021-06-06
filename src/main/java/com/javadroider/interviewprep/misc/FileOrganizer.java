package com.javadroider.interviewprep.misc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileOrganizer {

    private static final String sourceDirectory = "F:/Record/PhoneRecord/";
    private static final String destinationDirectory = "F:/Record/PhoneRecord1/";

    public static void main(String[] args) throws Exception {


        Files.list(Paths.get(sourceDirectory))
                .forEach(path -> moveFile(path.getFileName().toFile()));

    }

    private static void moveFile(File file) {
        String src = sourceDirectory + file.getName();
        String contactName = file.getName().split("-")[0];
        String destinationDir = destinationDirectory + contactName;
        File destFile = new File(destinationDir);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }

        try {
            copy(new File(src), new File(destinationDir + "/" + file.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copy(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            dest.setLastModified(source.lastModified());
            System.out.println("Copied " + dest.getAbsolutePath());
        } finally {
            is.close();
            os.close();
        }
    }
}

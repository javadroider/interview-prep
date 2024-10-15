package com.javadroider.interviewprep.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DDLExtractor {

    public static void main(String[] args) {
        File folder = new File("D:\\Hero7\\staging-data-main\\scripts\\CombinedUpdates");
        List<String> ddlStatements = new ArrayList<>();

        for (File file : folder.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".sql")) {
                ddlStatements.addAll(extractDDLStatements(file));
            }
        }

        // Print or process DDL statements
        for (String ddl : ddlStatements) {
            System.out.println(ddl);
        }
    }

    private static List<String> extractDDLStatements(File file) {
        List<String> ddlStatements = new ArrayList<>();
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Patterns to match DDL statements
        String alterTablePattern = "(?i)ALTER\\s+TABLE\\s+[^;]+;";
        String createTablePattern = "(?i)CREATE\\s+TABLE\\s+[^;]+;";
        String dropTablePattern = "(?i)DROP\\s+TABLE\\s+[^;]+;";

        ddlStatements.addAll(getMatches(fileContent.toString(), alterTablePattern));
        ddlStatements.addAll(getMatches(fileContent.toString(), createTablePattern));
        ddlStatements.addAll(getMatches(fileContent.toString(), dropTablePattern));

        return ddlStatements;
    }

    private static List<String> getMatches(String content, String pattern) {
        List<String> matches = new ArrayList<>();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);

        while (m.find()) {
            matches.add(m.group());
        }

        return matches;
    }
}

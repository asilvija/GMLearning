package com.app.seminar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Store {
    public Seminar readFromCsvFile(String courseName) {
        BufferedReader csvReader = openReader(courseName + ".csv");
        String row;
        try {
            row = csvReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String courseDetails[] = row.split(";");

        Seminar seminar = new Seminar(CsvRenderer.removeTextDelimiter(courseDetails[3]),
            Integer.parseInt(CsvRenderer.removeTextDelimiter(courseDetails[4])),
            new Course(CsvRenderer.removeTextDelimiter(courseDetails[0]),
                CsvRenderer.removeTextDelimiter(courseDetails[1]),
                CsvRenderer.removeTextDelimiter(courseDetails[2]),
                "23/03/2015"));

        try {
            while ((row = csvReader.readLine()) != null) {
                String readStudentInfo[] = row.split(";");
                seminar.addStudent(new Student(CsvRenderer.removeTextDelimiter(readStudentInfo[0]),
                    CsvRenderer.removeTextDelimiter(readStudentInfo[1])));
                System.out.println(readStudentInfo[0] + " " + readStudentInfo[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(seminar.getName() + " " + seminar.getLocation());
        closeReader(csvReader);
        return seminar;
    }

    public void writeOnFile(String seminarInfo, String fileName) {
        try {
            fileName = fileName.substring(0, 1).toUpperCase() + fileName.substring(1);
            FileWriter fw = new FileWriter(fileName + ".csv");
            fw.write(seminarInfo);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private BufferedReader openReader(String courseName) {
        BufferedReader csvReader;
        try {
            csvReader = new BufferedReader(new FileReader(courseName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return csvReader;
    }

    private void closeReader(BufferedReader csvReader) {
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

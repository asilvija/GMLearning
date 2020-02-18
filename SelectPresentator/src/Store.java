import static java.util.Arrays.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import renderer.CsvRenderer;

public class Store {

    private final String _fileName;

    public Store(String fileName) {
        _fileName = fileName;
    }

    public List<Person> readParticipiantList() throws Exception {
        List<Person> participiants = new ArrayList<>();
        BufferedReader csvReader= null;
     
            createFileIfNotExsists();
            csvReader = new BufferedReader(new FileReader(_fileName));
            addPersonToListFromFile(participiants, csvReader);
            csvReader.close();
        
            csvReader.close();
            
        return participiants;
    }

    private void addPersonToListFromFile(List<Person> participiants, BufferedReader csvReader) throws IOException {
        String row = csvReader.readLine();
        int index = 0;
        while ((row = csvReader.readLine()) != null) {

            String result[] = row.split(",");
            List<String> attributes = Arrays.asList(result);
            Boolean isAbsent = Boolean.parseBoolean(result[2]);
            if (!isAbsent) {
                index++;
            }
            participiants.add(new Person(index, attributes));
        }
    }

    private void createFileIfNotExsists() throws IOException {
        File file = new File(_fileName);
        if (file.createNewFile()) writeCsvColumnNames();
    }

    private String writeCsvColumnNames() {

        List<List<String>> data = new ArrayList<>();
        data.add(asList("firstName", "lastName", "isAbsent"));
        String result = new CsvRenderer(data).render();

        writeOnFile(result, _fileName);
        return result;
    }

    public String writeCsvFile(List<Person> _participiants) {
        List<List<String>> data = new ArrayList<>();
        data.add(asList("firstName", "lastName", "isAbsent"));
        for (Person person : _participiants) {
            data.add(asList(person.getFirstName(), person.getLastName(), String.valueOf(person.isAbsent())));
        }
        String result = new CsvRenderer(data).render();

        writeOnFile(result, _fileName);
        return result;
    }

    private void writeOnFile(String result, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(result);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

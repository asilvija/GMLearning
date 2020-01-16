import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Store {
    
    private final String _fileName;
    private String _csvColumnNames = "";
    private final String _COMMA_DELIMITER = ",";
    private final String _NEW_LINE_SEPARATOR = "\n";

    public Store(String fileName) {
        _fileName = fileName;
    }

    public ArrayList<Person> readParticipiantList() {
        ArrayList<Person> participiants = new ArrayList<>();
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(_fileName));
        } catch (FileNotFoundException e) {
            System.out.println("No file found..");
        }
        String row;
        try {
            row = csvReader.readLine();
            int index = 0;
            while ((row = csvReader.readLine()) != null) {
                String attributes[] = row.split(",");

                String firstName = attributes[0];
                String lastName = attributes[1];
                Boolean isAbsent = Boolean.parseBoolean(attributes[2]);
                if (!isAbsent) {
                    index++;
                }
                Person person = new Person(index, firstName, lastName, isAbsent);
                participiants.add(person);
            }
        } catch (IOException e1) {
            throw new RuntimeException(e1);
        }
        try {
            if (csvReader != null)
                csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return participiants;
    }
    
    public void writeParticipiantList(String[] csvColumnNames, List<Person> participiants) {

        for (int i = 0; i < csvColumnNames.length; i++) {
            if ((i + 1) < csvColumnNames.length) {
                _csvColumnNames += csvColumnNames[i] + _COMMA_DELIMITER;
            } else {
                _csvColumnNames += csvColumnNames[i] + _NEW_LINE_SEPARATOR;
            }
        }
        try {
            
            FileWriter fw = new FileWriter(_fileName);
            fw.write(_csvColumnNames);
            for (Person person : participiants) {
                fw.append(person.getFirstName());
                fw.append(_COMMA_DELIMITER);
                fw.append(person.getLastName());
                fw.append(_COMMA_DELIMITER);
                fw.append(String.valueOf(person.isAbsent()));
                fw.append(_NEW_LINE_SEPARATOR);
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

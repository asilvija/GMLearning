import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCsvFile {
    public static ArrayList<Person> readFile(String fileName) {
        ArrayList<Person> participiants = new ArrayList <>();
        BufferedReader csvReader = null;
        try {
            csvReader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("No file found..");            
        }
        String row;
        try {
            row = csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
               String attributes[]= row.split(",");
               Person person = createPerson(attributes);
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
    private static Person createPerson(String[] attributes) {
        String firstName = attributes[0];
        String lastName = attributes[1];
        Boolean isAbsent = Boolean.parseBoolean(attributes[2]);
                
        return new Person(firstName, lastName, isAbsent);
    }
}
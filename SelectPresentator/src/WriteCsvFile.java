import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCsvFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    public static void writeOnFile(String fileName, List<Person> participiants) {

        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("firstName,lastName,isAbsent");
            fw.append(NEW_LINE_SEPARATOR);
            for (Person person : participiants) {
                fw.append(person.getFirstName());
                fw.append(COMMA_DELIMITER);
                fw.append(person.getLastName());
                fw.append(COMMA_DELIMITER);
                fw.append(String.valueOf(person.isAbsent()));
                fw.append(NEW_LINE_SEPARATOR);
            }
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
            
    }
}

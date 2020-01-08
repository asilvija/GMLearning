import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCsvFile {
    private String _csvColumnNames = "";
    private final String _fileName;
    private final String _COMMA_DELIMITER = ",";
    private final String _NEW_LINE_SEPARATOR = "\n";

    public WriteCsvFile(String fileName) {
        _fileName = fileName;
    }

    public void writeOnFile(String[] csvColumnNames, List<Person> participiants) {

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

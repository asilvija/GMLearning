import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class PrintCsv implements PrintSeminar {

    public String print(Seminar seminar) {
        String result = "\"" + seminar.getNumber() + "\";"
            + "\"" + seminar.getDescription() + "\";"
            + "\"" + seminar.getLocation() + "\";"
            + "\"" + seminar.getSeatsLeft() + "\";"
            + addStudentsInfo(seminar);

        writeOnFile(result, seminar.getName());
        return result;
    }

    private String addStudentsInfo(Seminar seminar) {
        Iterator<Student> i = seminar.getStudentList().iterator();
        String result = "";
        while (i.hasNext()) {
            Student student = i.next();
            result += "\n\"" + student.getName() + "\";\"" + student.getLastName() + "\";";
        }
        return result;
    }

    private void writeOnFile(String seminarInfo, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName + ".csv");
            fw.write(seminarInfo);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

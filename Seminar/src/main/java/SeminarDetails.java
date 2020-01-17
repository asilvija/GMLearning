import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class SeminarDetails {
    public static void main(String[] args) {
        Date courseDate;
        try {
            courseDate = new SimpleDateFormat("dd.MM.yyyy").parse("28.03.2020");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Seminar english = new Seminar("Lugano", 10, new Course("1", "English", "A1", courseDate));
        Seminar deutsch = new Seminar("Lugano", 12, new Course("1", "Deutsch", "B1", courseDate));
        Seminar espagnolo = new Seminar("Lugano", 8, new Course("1", "Espagnolo", "C1", courseDate));

        english.addStudent(new Student("Anna", "Marchi"));
        english.addStudent(new Student("Marco", "Ruggieri"));

        deutsch.addStudent(new Student("Ivan", "Beransconi"));

        espagnolo.addStudent(new Student("Raf", "Bosch"));
        espagnolo.addStudent(new Student("Pillar", "Moura"));
        espagnolo.addStudent(new Student("Rosane", "Miguel"));

        Collection<Seminar> seminars = Arrays.asList(english, deutsch, espagnolo);

        for (Seminar seminar : seminars) {
            System.out.println(seminar.printCsv());
            System.out.println("------------------------------------------------");
        }
    }
}

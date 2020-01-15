import java.util.Arrays;
import java.util.Collection;

public class SeminarDetails {
    public static void main(String[] args) {
        Seminar english = new Seminar("Lugano", 10, new Course("1", "English", "A1"));
        Seminar deutsch = new Seminar("Lugano", 12, new Course("1", "Deutsch", "B1"));
        Seminar espagnolo = new Seminar("Lugano", 8, new Course("1", "Espagnolo", "C1"));

        english.addStudent(new Student("Anna", "Marchi"));
        english.addStudent(new Student("Marco", "Ruggieri"));

        deutsch.addStudent(new Student("Ivan", "Beransconi"));

        espagnolo.addStudent(new Student("Raf", "Bosch"));
        espagnolo.addStudent(new Student("Pillar", "Moura"));
        espagnolo.addStudent(new Student("Rosane", "Miguel"));

        Collection<Seminar> seminars = Arrays.asList(english, deutsch, espagnolo);

        for (Seminar seminar : seminars) {
            System.out.println(seminar.getInfo());
            System.out.println("------------------------------------------------"); 
        }
    }
}

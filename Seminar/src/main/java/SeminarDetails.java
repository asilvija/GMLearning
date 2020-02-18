import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeminarDetails {

    public static void main(String[] args) {

//        String courseDate = "28/03/2020";
//
//        Seminar english = new Seminar("Lugano", 10, new Course("1", "English", "A1", courseDate));
//        Seminar deutsch = new Seminar("Lugano", 12, new Course("1", "Deutsch", "B1", courseDate));
//        Seminar espagnolo = new Seminar("Lugano", 8, new Course("1", "Espagnolo", "C1", courseDate));
//
//        english.addStudent(new Student("Anna", "Marchi"));
//        english.addStudent(new Student("Marco", "Ruggieri"));
//
//        deutsch.addStudent(new Student("Ivan", "Beransconi"));
//
//        espagnolo.addStudent(new Student("Raf", "Bosch"));
//        espagnolo.addStudent(new Student("Pillar", "Moura"));
//        espagnolo.addStudent(new Student("Rosane", "Miguel"));
//
//        Collection<Seminar> seminars = Arrays.asList(english, deutsch, espagnolo);
//
//        english.renderHtml();
//        for (Seminar seminar : seminars) {
//            System.out.println(seminar.renderRaw());
//            System.out.println("------------------------------------------------");
//        }
        try {
            DirectoryStream<Path> results= Files.newDirectoryStream(Paths.get("./"));
            for (Path file : results) {
                if(file.toString().contains(".csv"))
                System.out.println(file.toString());  
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.util.ArrayList;
public class SeminarDetails {
    public static void main(String[] args) {
        Seminar english = new Seminar("Lugano", 10, new Course("1", "English", "A1"));
        Seminar deutsch = new Seminar("Lugano", 12, new Course("1", "Deutsch", "B1"));
        Seminar espagnolo = new Seminar("Lugano", 8, new Course("1", "Espagnolo", "C1"));

        english.addEnrollment(new Enrollment(new Student("Anna", "Marchi")));
        english.addEnrollment(new Enrollment(new Student("Marco", "Ruggieri")));

        deutsch.addEnrollment(new Enrollment(new Student("Ivan", "Beransconi")));

        espagnolo.addEnrollment(new Enrollment(new Student("Raf", "Bosch")));
        espagnolo.addEnrollment(new Enrollment(new Student("Pillar", "Moura")));
        espagnolo.addEnrollment(new Enrollment(new Student("Rosane", "Miguel")));

        ArrayList<Seminar> seminars = new ArrayList<Seminar>();

        seminars.add(english);
        seminars.add(deutsch);
        seminars.add(espagnolo);

        for (Seminar seminar : seminars) {
            System.out.println(seminar.getName() + " " + seminar.getLocation() + " " + seminar.getSeatsLeft() + ":");
            for (Enrollment enrollment : seminar.getStudentList()) {
                System.out.println(enrollment.getInfo());    
            }
            System.out.println("------------------------------------------------");
        }
    }
}

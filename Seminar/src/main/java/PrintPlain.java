import java.util.Iterator;

public class PrintPlain implements SeminarPrint {

    public String print(Seminar seminar) {
        String result = "";
        result += "nome corso: " + seminar.getName() + "\n descrizione: " + seminar.getDescription() + "\n luogo: "
            + seminar.getLocation()
            + "\n posti rimanenti: " + seminar.getSeatsLeft() + "\n partecipanti:\n";
        Iterator<Student> i = seminar.getStudentList().iterator();
        while (i.hasNext()) {
            result += addStudentsInfo(i.next());
        }
        return result;
    }

    private String addStudentsInfo(Student student) {
        String result = "   nome: " + student.getFullName() + "\n";
        return result;
    }

}

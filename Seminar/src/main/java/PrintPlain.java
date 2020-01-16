import java.util.Iterator;

public class PrintPlain implements PrintSeminar {

    public String print(Seminar seminar) {
        return "nome corso: " + seminar.getName() + "\n descrizione: " + seminar.getDescription() + "\n luogo: "
            + seminar.getLocation()
            + "\n posti rimanenti: " + seminar.getSeatsLeft() + "\n partecipanti:\n" + addStudentsInfo(seminar);

    }

    private String addStudentsInfo(Seminar seminar) {
        Iterator<Student> i = seminar.getStudentList().iterator();
        Student student = i.next();
        String result = "";
        while (i.hasNext()) {
            result += "   nome: " + student.getFullName() + "\n";
        }
        return result;
    }

}

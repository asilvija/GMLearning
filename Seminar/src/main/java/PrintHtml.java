import java.util.Iterator;

public class PrintHtml implements SeminarPrint {

    public String print(Seminar seminar) {
        // head
        String result = "<head><title>" + seminar.getName() + "</title></head>";
        // body
        result += "<body><div>nome corso:" + seminar.getName() + "<ul>" +
            "<li>descrizione " + seminar.getDescription() + "</li>" +
            "<li>luogo " + seminar.getLocation() + "</li>" +
            "<li>posti rimanenti " + seminar.getSeatsLeft() + "</li></ul>" +
            "<div>partecipanti:</div>" +
            "<ul>";
        Iterator<Student> i = seminar.getStudentList().iterator();
        while (i.hasNext()) {
            result += addStudentsInfoHtml(i.next());
        }
        result += "</ul></body></html>";
        return result;
    }

    private String addStudentsInfoHtml(Student student) {
        String result = "<li>" + student.getName() + " " + student.getLastName() + "</li>";
        return result;
    }
}

import java.util.Iterator;

public class PrintHtml implements PrintSeminar {

    public String print(Seminar seminar) {
       return
            "<head>"
                + "<title>" + seminar.getName() + "</title>"
                + "</head>"
                + "<body>"
                    + "<div>nome corso:" + seminar.getName()
                    + "<ul>" 
                    + "<li>descrizione " + seminar.getDescription() + "</li>"
                    + "<li>luogo " + seminar.getLocation() + "</li>"
                    + "<li>data " + seminar.getStartDate() + "</li>"
                    + "<li>posti rimanenti " + seminar.getSeatsLeft() + "</li></ul>"
                    + "<div>partecipanti:</div>"
                    + "<ul>" + addStudentsInfoHtml(seminar) + "</ul>"
                + "</body>"
            + "</html>";
    }

    private String addStudentsInfoHtml(Seminar seminar) {
        Iterator<Student> i = seminar.getStudentList().iterator();
        String result = "";
        while (i.hasNext()) {
            Student student = i.next();
            result += "<li>" + student.getName() + " " + student.getLastName() + "</li>";
        }
        return result;
    }
}

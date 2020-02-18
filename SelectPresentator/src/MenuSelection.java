import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuSelection {
    private String _fileName;
    private String _date;
    private final InputStream _input;

 
    public MenuSelection(String date) {
        this(date, System.in);
    }
    
    public MenuSelection(String date, InputStream input) {
        _input = input;
        setDate(date);
        setFileName();
    }

    private void setFileName() {
        _fileName = "participiantsList_"+_date + ".csv";
    }

    public void exec() throws Exception {
        int menuSelection = 0;
        final Scanner in = new Scanner(_input);
        try {
            do {
                showMenuOptions();
                menuSelection = in.nextInt();
               
                switch (menuSelection) {
                case 1:
                    new AddPersonToList(in, _fileName).exec();
                    break;
                case 2:
                    new RemovePersonFromList(in, _fileName, _date).exec();
                    break;
                case 3:
                    new SelectRandomPresentator(_fileName).exec();
                    break;
                default:
                    break;
                }
            } while (menuSelection > 0 && menuSelection < 4);
        } catch (InputMismatchException e) {
            System.out.println("End...");
        }
        in.close();
    }

    public List<Person> viewParticipantList() throws Exception {
        List<Person> _participiants = new Store(_fileName).readParticipiantList();

        System.out.println("Participiants list:\n");
        for (Person person : _participiants) {
            if (!person.isAbsent()) {
                System.out.println(
                    person.getKey() + " " + person.getFullName());
            }
        }
        return _participiants;
    }

    public void showMenuOptions() throws Exception {
        viewParticipantList();
        System.out.println("---------------------------------------------");
        System.out.print(
            "Select one of the options(Press any other key for exit):\n\n"
                + "1. Add person to the participiants list\n"
                + "2. Remove person from the participiants list\n"
                + "3. Choose random presentator\n");
        System.out.println("---------------------------------------------");
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }
}

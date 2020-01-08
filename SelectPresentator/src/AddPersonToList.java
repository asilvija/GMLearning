import java.util.ArrayList;
import java.util.Scanner;

public class AddPersonToList implements Action {

    private Scanner _in;
    private final ArrayList<Person> _participiants;
    private final String _fileName;

    public AddPersonToList(Scanner in, ArrayList<Person> participiants, String fileName) {
        _in = in;
        _participiants = participiants;
        _fileName = fileName;
    }
    
    @Override
    public void exec() {
        // TODO
        // add participants to meeting
        String fullName;
        
        do {
            _in = new Scanner(System.in);
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = _in.nextLine();
            if (!fullName.equals("q")) {
//
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//                Date date = new Date(System.currentTimeMillis());
//                String current_date = formatter.format(date);
              
                String [] result =fullName.split(" ");
                String firstName = result[0];
                String lastName = "";
                if (result.length > 1) {
                    lastName = result[1];
                }
                Person person = new Person(_participiants.size() + 1,firstName, lastName, false);
                _participiants.add(person);
                
            }
        } while (!fullName.equals("q"));
        
        WriteCsvFile.writeOnFile(_fileName, _participiants);
        
        for (Person person : _participiants) {
            System.out.println(person.getIndex() + " " + person.getFullName());
        }
        MenuSelection.showMenuOptions();
    }

}

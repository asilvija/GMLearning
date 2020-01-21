import static java.util.Arrays.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import renderer.CsvRenderer;

public class AddPersonToList implements Action {

    private final Scanner _in;
    private final String _fileName;
    private final Store _store;
    

    public AddPersonToList(InputStream input, String fileName) {
        _in = new Scanner(input);
        _fileName = fileName;
        _store = new Store(_fileName); 
    }
    
    public AddPersonToList(Scanner in, String fileName) {
        _in = in;
        _fileName = fileName;
        _store = new Store(_fileName); 
    }

    @Override
    public void exec() {
        String fullName;
        List<Person> _participiants = _store.readParticipiantList();
        _in.nextLine();
        do {
            System.out.println("Insert participiant full name (Press q to exit):");
            fullName = _in.nextLine();
            if (!fullName.equals("q")) {
                addPersonToList(fullName, _participiants);
            }
        } while (!fullName.equals("q"));

        _store.writeCsvFile(_participiants);
    }

    public String renderCsv(ArrayList<Person> participiants) {
        List<List<String>> data = new ArrayList<>();
        data.add(asList("firstName", "lastName", "isAbsent"));
        for (Person person : participiants) {
            data.add(asList(person.getFirstName(), person.getLastName(), String.valueOf(person.isAbsent())));
        }
        String result = new CsvRenderer(data).render();

        return result;
    }

    private void addPersonToList(String fullName, List<Person> _participiants) {
        String[] result = fullName.split(" ");
        List<String> attributes = new ArrayList<>(Arrays.asList(result));
        attributes.add("false");

        Person person = new Person(_participiants.size() + 1, attributes);
        _participiants.add(person);
    }
}

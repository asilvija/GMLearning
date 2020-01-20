import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Meeting {
    private String _name;
    private String _date;
    private MenuSelection _menuSelection;

    public Meeting(String name, String date) {
        _name = name;
        _date = formatDate(date);
        setMenuSelection(new MenuSelection(date));
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDate() {
        return _date;
    }

    public void setDate(String date) {
        _date = date;
    }

    private String formatDate(String courseDate) {
        Date _courseDate;
        try {
            _courseDate = new SimpleDateFormat("dd.MM.yyyy").parse(courseDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(_courseDate);
    }

    public MenuSelection menuSelection() {
        return _menuSelection;
    }

    public void setMenuSelection(MenuSelection menuSelection) {
        _menuSelection = menuSelection;
    }

}

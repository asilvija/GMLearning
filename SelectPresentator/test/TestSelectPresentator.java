import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Before;

public class TestSelectPresentator {
    private static final String FILE_NAME = "/tmp/participiantsList.csv";
    
    @Before
    public void init() {
        FileUtils.deleteQuietly(new File(FILE_NAME));
        
        //finire di scrivere Test di Store
        //scrivere test di AddPersonToList
        //scrivere test di MenuSelection
    }
    
    
}

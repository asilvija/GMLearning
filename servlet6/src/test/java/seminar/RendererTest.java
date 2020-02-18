package seminar;
import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.app.seminar.view.CsvRenderer;
import com.app.seminar.view.HtmlRenderer;

public class RendererTest {

    @Test
    public void htmlRenderer() {
        HtmlRenderer htmlRenderer = new HtmlRenderer().html(
            new HtmlRenderer().head(
                new HtmlRenderer().title("renderer")),
            new HtmlRenderer().body(
                new HtmlRenderer().div("english"),
                new HtmlRenderer().ul(
                    new HtmlRenderer().li("test1"),
                    new HtmlRenderer().li("test2"))));

        String result = htmlRenderer.render();

        assertThat(result, is(
            "<html><head><title>renderer</title></head><body><div>english</div><ul><li>test1</li><li>test2</li></ul></body></html>"));
    }

    @Test
    public void csvRenderer() {
        List<List<String>> data = new ArrayList<List<String>>();
        data.add(asList("1","english","A1","Lugano","2","10/03/2014"));
        CsvRenderer csvRenderer = new CsvRenderer(data);
        
        String result = csvRenderer.render();
        assertThat(result, is("\"1\";\"english\";\"A1\";\"Lugano\";\"2\";\"10/03/2014\";\n"));
    }
}

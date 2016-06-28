import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class LovePdfFileTest {

    @Test
    public void exists() {
        assertThat(resource(), notNullValue());
    }

    private URL resource() {
        return getClass().getClassLoader().getResource("love.pdf");
    }

    @Test
    public void hasExpectedContent() throws IOException {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String fileName = resource().getFile();
        PDDocument document = PDDocument.load(new File(fileName));
        String content = pdfStripper.getText(document);

        assertThat(content, containsString("Love is everywhere"));
    }
}

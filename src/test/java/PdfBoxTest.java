import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PdfBoxTest extends PdfTest {

    @Test
    public void canExtractTextFromPdf() throws IOException {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument document = PDDocument.load(new File(resource().getFile()));
        String content = pdfStripper.getText(document);

        assertThat(content, containsString("Love is everywhere"));
    }
}

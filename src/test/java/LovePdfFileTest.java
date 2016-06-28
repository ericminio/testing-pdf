import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LovePdfFileTest {

    @Test
    public void exists() {
        assertThat(file().exists(), equalTo(true));
    }

    private File file() {
        return new File(getClass().getClassLoader().getResource("love.pdf").getFile());
    }

    @Test
    public void hasContentOnFirstPage() throws IOException {
        PDDocument document = PDDocument.load(file());
        PDPage page = document.getDocumentCatalog().getPages().get(0);

        assertThat(page.hasContents(), equalTo(true));
    }

    @Test
    public void hasExpectedContent() throws IOException {
        PDDocument document = PDDocument.load(file());
        PDFTextStripper pdfStripper = new PDFTextStripper();
        pdfStripper.setStartPage(1);
        pdfStripper.setEndPage(1);
        String content = pdfStripper.getText(document);

        assertThat(content, containsString("Love is everywhere"));
    }
}

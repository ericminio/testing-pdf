package ericminio.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static ericminio.support.ResourceAccessor.pdfWithName;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class PdfBoxTest {

    @Test
    public void canExtractTextFromPdf() throws IOException {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument document = PDDocument.load(new File(pdfWithName("love")));
        String content = pdfStripper.getText(document);

        assertThat(content, containsString("Love is everywhere"));
    }
}

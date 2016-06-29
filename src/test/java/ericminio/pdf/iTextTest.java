package ericminio.pdf;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.junit.Test;

import java.io.IOException;

import static ericminio.support.ResourceAccessor.pdfWithName;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class iTextTest {

    @Test
    public void canExtractTextFromPdf() throws IOException {
        PdfReader reader = new PdfReader(pdfWithName("love"));
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        TextExtractionStrategy strategy = parser.processContent(1, new SimpleTextExtractionStrategy());
        String content = strategy.getResultantText();

        assertThat(content, containsString("Love is everywhere"));
    }
}

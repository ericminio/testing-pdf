import org.junit.Test;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class PdfTest {

    public URL resource() {
        return getClass().getClassLoader().getResource("love.pdf");
    }

    @Test
    public void resourceExists() {
        assertThat(resource(), notNullValue());
    }
}

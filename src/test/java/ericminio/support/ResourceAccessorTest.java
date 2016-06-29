package ericminio.support;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

public class ResourceAccessorTest {

    @Test
    public void canAccessLovePdf() {
        assertThat(ResourceAccessor.pdfWithName("love"), notNullValue());
    }
}

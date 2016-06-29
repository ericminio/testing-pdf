package ericminio.support;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TddReadyTest {

    @Test
    public void readyToAssert() {
        assertThat(1+1, equalTo(2));
    }
}

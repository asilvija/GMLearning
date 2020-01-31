package profile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class ProfileTest {

    @Test
   
    public void sumTo() {

        assertThat(new Profile().sumTo(100), is(5050));

    }

    @Test
    @Ignore
    public void accumulate() {
        assertThat(new Calc().accumulate(5, 2), is(7));
    }

    @Test
    @Ignore
    public void sumToOptimized() {
        assertThat(new Profile().sumToOptimized(100), is(5050));
    }
    
    @Test
    @Ignore
    public void sumTo1() {
        assertThat(new Profile().sumTo1(100), is(5050));
    }
}

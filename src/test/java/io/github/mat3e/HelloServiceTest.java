package io.github.mat3e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private HelloService SUT = new HelloService();
    @Test
    public void test_prepareGreeting_null_returnsWithFallbackValue() throws Exception {
        //given + when
        var result = SUT.prepareGreeeting(null);
        //then
        assertEquals("Hello " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingwithName() throws Exception {
        //given
        var name = "test";
        // when
        var result = SUT.prepareGreeeting(name);
        //then
        assertEquals("Hello " + name + "!", result);
    }
}

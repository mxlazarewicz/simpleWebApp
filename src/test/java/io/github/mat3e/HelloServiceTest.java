package io.github.mat3e;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloServiceTest {
    private static final String WELCOME = "Hello";
    @Test

    public void test_prepareGreeting_nullName_returnsWithFallbackName() throws Exception {
        //given
        var mockRepository = alwaysReturningHelloRepository();
       var SUT = new HelloService(mockRepository);
        //when
        var result = SUT.prepareGreeeting(null, "-1");
        //then
        assertEquals(WELCOME + " " + HelloService.FALLBACK_NAME + "!", result);
    }

    @Test
    public void test_prepareGreeting_name_returnsGreetingwithName() throws Exception {
        //given
        var name = "test";
        var SUT = new HelloService();
        // when
        var result = SUT.prepareGreeeting(name, "-1");
        //then
        assertEquals(WELCOME + " " + name + "!", result);
    }
    @Test
    public void test_prepareGreeting_nullLang_returnsWithFallbackFallbackIdLang() throws Exception {
        //given
        var fallbackIdWelcome = "Hola";
        var mockRepository = new LangRepository(){
            @Override
            Optional<Lang> findById(Long id) {
                if(id.equals(HelloService.FALLBACK_LANG.getId())){
                    return Optional.of(new Lang(null, fallbackIdWelcome, null));
                }
                return Optional.empty();
            }
        };
        var SUT = new HelloService(mockRepository);
        //when
        var result = SUT.prepareGreeeting(null, null);
        //then
        assertEquals(fallbackIdWelcome + " " + HelloService.FALLBACK_NAME + "!", result);
    }


    private LangRepository alwaysReturningHelloRepository() {
        return new LangRepository() {
            @Override
            Optional<Lang> findById(Long id) {
                return Optional.of(new Lang(null, WELCOME, null));
            }
        };
    }
}


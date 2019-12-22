package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author leon on 03/02/2019.
 */
public class PrintLnTest {
    @Test
    public void test1() {
        String outputString = "The quick brown fox";
        test(outputString);
    }

    @Test
    public void test2() {
        String outputString = "The quick %s fox";
        String[] stringArguments = {"brown"};
        test(outputString, stringArguments);
    }

    @Test
    public void test3() {
        String outputString = "The %s %s fox";
        String[] stringArguments = {"quick", "brown"};
        test(outputString, stringArguments);
    }

    @Test
    public void test5() {
        String outputString = "Over the lazy dog";
        test(outputString);
    }

    @Test
    public void test6() {
        String outputString = "Over the %s dog.";
        String[] stringArguments = {"lazy"};
        test(outputString, stringArguments);
    }

    @Test
    public void test7() {
        String outputString = "Over the %s %s.";
        String[] stringArguments = {"lazy", "dog"};
        test(outputString, stringArguments);
    }

    private void test(String outputString, String... stringArguments) {
        // Given
        String expected = String.format(outputString, stringArguments) + "\n";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOConsole console = new IOConsole(System.in, new PrintStream(outputStream));

        // When
        console.println(outputString, stringArguments);
        String actual = outputStream.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }
}

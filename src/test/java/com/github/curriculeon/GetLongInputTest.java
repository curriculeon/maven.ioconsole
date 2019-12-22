package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author leon on 03/02/2019.
 */
@SuppressWarnings("all")
public class GetLongInputTest {
    private IOConsole console;


    @Test
    public void test1() {
        test("0", 0L);
    }

    @Test
    public void test2() {
        test("1", 1L);
    }

    @Test
    public void test3() {
        test("9223372036854775807", Long.MAX_VALUE);
    }

    @Test
    public void test5() {
        test("-9223372036854775808", Long.MIN_VALUE);
    }

    @Test(expected=NoSuchElementException.class)
    public void test6() {
        test("1.1", 1L);
    }

    @Test(expected=NoSuchElementException.class)
    public void test7() {
        test("_", null);
    }


    private void test(String input, Long expected) {
        // Given
        this.console = getConsoleWithBufferedInput(input);

        // When
        Long actual = console.getLongInput("");

        // Then
        Assert.assertEquals(actual, expected);
    }

    private IOConsole getConsoleWithBufferedInput(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        IOConsole console = new IOConsole(scanner, System.out);
        return console;
    }
}

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
public class GetFloatInputTest {
    private IOConsole console;


    @Test
    public void test1() {
        test("0", 0F);
    }

    @Test
    public void test2() {
        test("1", 1F);
    }

    @Test
    public void test3() {
        test("3.4028235E38", Float.MAX_VALUE);
    }

    @Test
    public void test5() {
        test("1.4E-45", Float.MIN_VALUE);
    }

    @Test
    public void test6() {
        test("1.0", 1F);
    }

    @Test(expected=NoSuchElementException.class)
    public void test7() {
        test("_", null);
    }


    private void test(String input, Float expectedInput) {
        // Given
        this.console = getConsoleWithBufferedInput(input);

        // When
        Float actual = console.getFloatInput("");

        // Then
        Assert.assertEquals(actual, expectedInput);
    }

    private IOConsole getConsoleWithBufferedInput(String inputString) {
        byte[] inputBytes = inputString.getBytes();
        ByteArrayInputStream inputByteArray = new ByteArrayInputStream(inputBytes);
        Scanner scanner = new Scanner(inputByteArray);
        IOConsole console = new IOConsole(scanner, System.out);
        return console;
    }
}

package ru.skuznetsov;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

/**
 * Tests to check output to console.
 */
public class CalculateTest {

  /**
  * Compare output after execution with expected string.
  */
  @Test
  public void whenExecuteMainThenPrintToConsole() {

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    Calculate.main(null);
    assertThat(out.toString(), is("Hello World\r\n"));

  }
}

/**
*<p>This class contains method wich one printing Hello World phrase</p>
* 
*/

package ru.skuznetsov;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import java.io.PrintStream;

/**
 * @author skuznetsov
 * @version 1.0
 * 
 */

public class CalculateTest {

  @Test
public void whenExecuteMainThenPrintToConsole() {

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    Calculate.main(null);
    assertThat(out.toString(), is("Hello World\r\n"));
    
  }
}

package ru.skuznetsov;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
* Test to equal output from console with suggestion
*/
public class CalculateTest{
	
	@Test
	public void whenExecuteMainThenPrintToConsole(){
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		Calculate.main(null);
		assertThat(out.toString(), is("Hello World\r\n"));
	}
}

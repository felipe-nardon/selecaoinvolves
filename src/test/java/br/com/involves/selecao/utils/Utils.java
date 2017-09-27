package br.com.involves.selecao.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import br.com.involves.selecao.commons.Constants;

public class Utils {
	
	private final PrintStream standardOut = System.out;
	private final PrintStream standardErr = System.err;
	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private final ByteArrayOutputStream err = new ByteArrayOutputStream();

	public Utils() {
		
	}
	
	public void setUpStreams() {
		setSystemOut();
		setSystemErr();
	}
	
	public void cleanUpStreams() {
	    setStandardSystemIn();
	    setStandardSystemOut();
	    setStandardSystemErr();
	}
	
	public void printStreams() {
		System.out.println(getOut());
		System.err.println(getErr());
	}

	public void setSystemIn(String command) {
		System.setIn(new ByteArrayInputStream(String.format("%s%sexit", command, Constants.NEW_LINE).getBytes()));
	}
	
	private void setStandardSystemIn() {
		System.setIn(System.in);
	}
	
	private void setSystemOut() {
		System.setOut(new PrintStream(out));
	}
	
	private void setStandardSystemOut() {
		System.setOut(getStandardOut());
	}
	
	private void setSystemErr() {
		System.setErr(new PrintStream(err));
	}
	
	private void setStandardSystemErr() {
		System.setErr(getStandardErr());
	}
	
	public ByteArrayOutputStream getOut() {
		return out;
	}

	public ByteArrayOutputStream getErr() {
		return err;
	}

	public PrintStream getStandardOut() {
		return standardOut;
	}

	public PrintStream getStandardErr() {
		return standardErr;
	}
	
}

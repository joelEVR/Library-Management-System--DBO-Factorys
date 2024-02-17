package com.algonquin.cst8288.assignment2.logger;


//auto generate all code 
public class LMSLogger {
	
	private static LMSLogger instance;

	private LMSLogger() {
		
	}

	public static LMSLogger getInstance() {
		if (instance == null) {
			instance = new LMSLogger();
		}
		return instance;
	}

	public void log(String message) {
		System.out.println(message);
	}

	public void logError(String message) {
		System.err.println(message);
	}

	public void logException(Exception e) {
		e.printStackTrace();
	}

	public void logException(String message, Exception e) {
		System.err.println(message);
		e.printStackTrace();
	}

	public void logException(String message, Throwable t) {
		System.err.println(message);
		t.printStackTrace();
	}

	public void logException(Throwable t) {
		t.printStackTrace();
	}

	public void logError(String message, Throwable t) {
		System.err.println(message);
		t.printStackTrace();
	}

	public void logError(Throwable t) {
		t.printStackTrace();
	}

	public void logError(Exception e) {
		e.printStackTrace();
	}

	public void logDebug(String message) {
		System.out.println(message);
	}

	public void logInfo(String message) {
		System.out.println(message);
	}

	public void logWarn(String message) {
		System.out.println(message);
	}

	public void logFatal(String message) {
		System.err.println(message);
	}

	public void logFatal(String message, Throwable t) {
		System.err.println(message);
		t.printStackTrace();
	}

	public void logFatal(Throwable t) {
		t.printStackTrace();
	}

	public void logFatal(Exception e) {
		e.printStackTrace();
	}

	public void logTrace(String message) {
		System.out.println(message);
	}

	public void logTrace(String message, Throwable t) {
		System.out.println(message);
		t.printStackTrace();
	}

	public void logTrace(Throwable t) {
		t.printStackTrace();
	}

	public void logTrace(Exception e) {
		e.printStackTrace();
	}

	public void logTrace(String message, Exception e) {
		System.out.println(message);
		e.printStackTrace();
	}

	public void logTrace(String message, Throwable t, Exception e) {
		System.out.println(message);
		t.printStackTrace();
		e.printStackTrace();
	}

	public void logTrace(Throwable t, Exception e) {
		t.printStackTrace();
		e.printStackTrace();
	}

	public void logTrace(Exception e, Throwable t) {
	
}

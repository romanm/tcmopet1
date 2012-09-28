package org.tasclin1.mopet1.controller;

public class QException extends RuntimeException{

	private String customMsg;

	public QException(String customMsg) {
		this.customMsg = customMsg;
	}
 
}
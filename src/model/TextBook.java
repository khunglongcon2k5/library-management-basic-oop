/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package model;

import java.util.Scanner;

public class TextBook extends Book {
	private String subject;
	
	public TextBook() {
		
	}
	
	public TextBook(String id, String title, String author, double price, String subject) {
		super(id, title, author, price);
		this.subject = subject;
	}
	
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return "TextBook|" + super.toString() + subject;
	}

	public void nhapTextBook(Scanner sc) {
		super.nhapBook(sc);
		System.out.print("- Nhập Subject: "); this.subject = sc.nextLine();
	}
	
	@Override
	public double calculateValue() {
		return this.getPrice();
	}
}

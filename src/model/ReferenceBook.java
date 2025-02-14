/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package model;

import java.util.Scanner;

public class ReferenceBook extends Book {
	private String field;
	
	public ReferenceBook() {
		
	}
	
	public ReferenceBook(String id, String title, String author, double price, String field) {
		super(id, title, author, price);
		this.field = field;
	}
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "ReferenceBook|" + super.toString() + field;
	}

	public void nhapReferenceBook(Scanner sc) {
		super.nhapBook(sc);
		System.out.print("- Nhập Field: "); this.field = sc.nextLine();
	}
	
	@Override
	public double calculateValue() {
		return this.getPrice();
	}
}

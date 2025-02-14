/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package model;

import java.util.Scanner;

public class EBook extends Book {
	private double fileSize;
	private String fileFormat;
	
	public EBook() {
		
	}
	
	public EBook(String id, String title, String author, double price, double fileSize, String fileFormat) {
		super(id, title, author, price);
		this.fileSize = fileSize;
		this.fileFormat = fileFormat;
	}
	
	/**
	 * @return the fileSize
	 */
	public double getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the fileFormat
	 */
	public String getFileFormat() {
		return fileFormat;
	}

	/**
	 * @param fileFormat the fileFormat to set
	 */
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	@Override
	public String toString() {
		return "EBook|" + super.toString() + fileSize + "|" + fileFormat;
	}

	public void nhapEBook(Scanner sc) {
		super.nhapBook(sc);
		System.out.print("- Nhập File Size: ");
		this.fileSize = sc.nextDouble();
		sc.nextLine();
		System.out.print("- Nhập File Format: ");
		this.fileFormat = sc.nextLine();
	}
	
	@Override
	public double calculateValue() {
		return this.getPrice();
	}
}

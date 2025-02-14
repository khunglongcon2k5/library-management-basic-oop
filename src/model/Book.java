/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package model;

import java.util.Scanner;

public abstract class Book {
	private String id;
	private String title;
	private String author;
	private double price;
	
	public Book() {
		
	}
	
	public Book(String id, String title, String author, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return id + "|" + title + "|" + author + "|" + price + "|";
	}
	
	public void nhapBook(Scanner sc) {
		System.out.print("- Nhập ID: "); 
		this.id = sc.nextLine();
		System.out.print("- Nhập Title: "); 
		this.title = sc.nextLine();
		System.out.print("- Nhập Author: ");
		this.author = sc.nextLine();
		System.out.print("- Nhập Price: ");
		this.price = sc.nextDouble();
		sc.nextLine();
	}
	
	public abstract double calculateValue();
}

/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Book;
import model.EBook;
import model.ReferenceBook;
import model.TextBook;

public class LibraryManager implements FileOperations {
	private List<Book> bookList = new ArrayList<>();
	
	public void addBook(Book book) {
		bookList.add(book);
	}
	
	public boolean removeBook(String title) {
		return bookList.removeIf(book -> book.getTitle().equalsIgnoreCase(title.trim()));
	}
	
	public void displayBook() {
		bookList.forEach(System.out::println);
	}
	
	public boolean updateBook(String id, Scanner sc) {
		for (Book book : bookList) {
			if (book.getId().equalsIgnoreCase(id)) {
				System.out.print("- Nhập ID mới: ");
				book.setId(sc.nextLine());
				System.out.print("- Nhập Title mới: ");
				book.setTitle(sc.nextLine());
				System.out.print("- Nhập Author mới: ");
				book.setAuthor(sc.nextLine());
				System.out.print("- Nhập Price mới: ");
				book.setPrice(sc.nextDouble());
				sc.nextLine();
				
				if (book instanceof TextBook textBook) {
					System.out.print("- Nhập Subject mới: ");
					textBook.setSubject(sc.nextLine());
				} else if (book instanceof ReferenceBook referenceBook) {
					System.out.print("- Nhập Field mới: ");
					referenceBook.setField(sc.nextLine());
				} else if (book instanceof EBook eBook) {
					System.out.print("- Nhập File size mới: ");
					eBook.setFileSize(sc.nextDouble());
					sc.nextLine();
					System.out.print("- Nhập File format mới: ");
					eBook.setFileFormat(sc.nextLine());
				}
			}
			return true;
		}
		return false;
	}
	
	public double calculateTotalValue() {
		double totalValue = 0;
		for (Book book : bookList) {
			totalValue += book.calculateValue();
		}
		return totalValue;
	}
	
	public List<Book> findBookByTitle(String title) {
		List<Book> books = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public void saveToFile(String file) {
		try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
			for (Book book : bookList) {
				if (book instanceof TextBook) {
					bw.write(book.toString());
					bw.newLine();
				}
			}
			
			for (Book book : bookList) {
				if (book instanceof ReferenceBook) {
					bw.write(book.toString());
					bw.newLine();
				}
			}
			
			for (Book book : bookList) {
				if (book instanceof EBook) {
					bw.write(book.toString());
					bw.newLine();
				}
			}
			bw.write("Total value: " + calculateTotalValue());
		} catch (IOException e) {
			System.out.println("Lỗi save file: " + e.getMessage());
		}
	}

	@Override
	public void loadFromFile(String file) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("TextBook")) {
					String[] fields = line.split("\\|");
					String id = fields[1];
					String title = fields[2];
					String author = fields[3];
					double price = Double.parseDouble(fields[4]);
					String subject = fields[5];
					bookList.add(new TextBook(id, title, author, price, subject));
				} else if (line.startsWith("ReferenceBook")) {
					String[] fields = line.split("\\|");
					String id = fields[1];
					String title = fields[2];
					String author = fields[3];
					double price = Double.parseDouble(fields[4]);
					String field = fields[5];
					bookList.add(new ReferenceBook(id, title, author, price, field));
				} else if (line.startsWith("EBook")) {
					String[] fields = line.split("\\|");
					String id = fields[1];
					String title = fields[2];
					String author = fields[3];
					double price = Double.parseDouble(fields[4]);
					double fileSize = Double.parseDouble(fields[5]);
					String fileFormat = fields[6];
					bookList.add(new EBook(id, title, author, price, fileSize, fileFormat));
				}
			}
			System.out.println("Load file dữ liệu lên thành công!!!");
		} catch (Exception e) {
			System.out.println("Lỗi load file: " + e.getMessage());
		}
		
	}
	
}

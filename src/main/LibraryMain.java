/*
 * 
 * @author NguyenHung
 * @date Jan 18, 2025
 * @version 1.0
 *
 */

package main;

import java.util.List;
import java.util.Scanner;

import model.Book;
import model.EBook;
import model.ReferenceBook;
import model.TextBook;
import service.LibraryManager;

public class LibraryMain {
	private static Scanner sc = new Scanner(System.in);
	private static LibraryManager libraryManager = new LibraryManager();
	
	public static void main(String[] args) {
		int option = 0;
		do {
			Menu();
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
				case 1:
					typeBookMenu();
					int typeBook = sc.nextInt();
					sc.nextLine();
					
					if (typeBook == 1) {
						TextBook textBook = new TextBook();
						textBook.nhapTextBook(sc);
						libraryManager.addBook(textBook);
						System.out.println("Đã thêm thành công TextBook!!!");
					} else if (typeBook == 2) {
						ReferenceBook referenceBook = new ReferenceBook();
						referenceBook.nhapReferenceBook(sc);
						libraryManager.addBook(referenceBook);
						System.out.println("Đã thêm thành công ReferenceBook!!!");
					} else if (typeBook == 3) {
						EBook eBook = new EBook();
						eBook.nhapEBook(sc);
						libraryManager.addBook(eBook);
						System.out.println("Đã thêm thành công EBook!!!");
					}
					break;
				case 2:
					System.out.print("Nhập Title sách cần xóa: "); 
					String title = sc.nextLine();
					if (libraryManager.removeBook(title)) {
						System.out.println("Đã xóa thành công sách có title là: " + title);
					} else {
						System.out.println("Không tìm thấy sách có title là: " + title);
					}
					break;
				case 3:
					System.out.print("Nhập ID sách cần cập nhật: ");
					String bookID = sc.nextLine();
					if (libraryManager.updateBook(bookID, sc)) {
						System.out.println("Đã cập nhật thành công sách có ID là: " + bookID);
					} else {
						System.out.println("Không tìm thấy sách có ID là: " + bookID);
					}
					break;
				case 4:
					System.out.print("Nhập Title sách cần tìm: ");
					String titleBook = sc.nextLine();
					List<Book> books = libraryManager.findBookByTitle(titleBook);
					System.out.println(books);
					break;
				case 5:
					System.out.println("=============================== LIST BOOK ================================");
					libraryManager.displayBook();
					break;
				case 6:
					System.out.print("Nhập tên file cần save: ");
					String file = sc.nextLine();
					libraryManager.saveToFile(file);
					break;
				case 7:
					System.out.print("Nhập tên file cần load: ");
					String files = sc.nextLine();
					libraryManager.loadFromFile(files);
					break;
				case 8:
					System.out.println("Total value: " + libraryManager.calculateTotalValue());
					break;
				case 9:
					return;
			}
		} while (option != 9);
	}
	
	public static void Menu() {
		System.out.println("||===============================||");
		System.out.println("||             MENU              ||");
		System.out.println("||       LIBRARY MANAGEMENT      ||");
		System.out.println("||===============================||");
		System.out.println("|| 1. Thêm sách.                 ||");
		System.out.println("|| 2. Xóa sách theo title.       ||");
		System.out.println("|| 3. Cập nhật sách.             ||");
		System.out.println("|| 4. Tìm sách theo title.       ||");
		System.out.println("|| 5. Hiển thị sách hiện có.     ||");
		System.out.println("|| 6. Save to file.              ||");
		System.out.println("|| 7. Load from file.            ||");
		System.out.println("|| 8. Calculate total value.     ||");
		System.out.println("|| 9. Đăng xuất.                 ||");
		System.out.println("||===============================||");
		System.out.print("Nhập lựa chọn của bạn tại đây: ");
	}
	
	public static void typeBookMenu() {
		System.out.println("||===============================||");
		System.out.println("||           TYPE BOOK           ||");
		System.out.println("||===============================||");
		System.out.println("|| 1. TextBook.                  ||");
		System.out.println("|| 2. ReferenceBook.             ||");
		System.out.println("|| 3. EBook.                     ||");
		System.out.println("||===============================||");
		System.out.print("Chọn loại sách cần thêm: ");
	}
}

package pb_book;

import java.util.Scanner;

public class PbookApp {

	public static void main(String[] args) {
		PbookController pc = new PbookController();
		System.out.println("****************************************");
		System.out.println("**WELCOME, PHONEBOOK MANAGEMENT SYSTEM**");
		System.out.println("****************************************");
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		while(flag) {
			scanner.reset();
			System.out.println("1. LIST, 2. ADD, 3. DELETE, 4. SEARCH, 5. EXIT");
	        System.out.println("________________________________________");
	        System.out.print("MENU>");
			String menu = scanner.next();
			if ("1".equals(menu)) {
				pc.listPbook();
			}else if ("2".equals(menu)) {
				pc.insertPbook();
			}else if ("3".equals(menu)) {
				pc.deletePbook();
			}else if ("4".equals(menu)) {
				pc.searchPbook();
			}else if ("5".equals(menu)) {
				flag = false;
				System.out.println("******************************");
                System.out.println("**********THANK YOU***********");
                System.out.println("******************************");
			}else {
				System.out.println("Please write again");
			}
		}
		scanner.close();

	}
}

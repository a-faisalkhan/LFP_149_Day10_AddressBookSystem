package com.bridgelabz.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.bridgelabz.services.AddressBookService;

public class AddressBookMain {
	
	public static void main(String[] args) {
		System.out.println("<-------------Welcome To Address Book----------------->");

		Scanner scanner = new Scanner(System.in);
		HashMap<String, AddressBookService> services = new HashMap<>();
		System.out.println("*****Enter Unique Address Book Name*****");
		String addressBookNameAsKey = scanner.nextLine().toUpperCase();
		System.out.println(addressBookNameAsKey);
		AddressBookService addressBookNameValue = new AddressBookService();
		services.put(addressBookNameAsKey, addressBookNameValue);

		boolean exit = false;
		System.out.println("Enter Your Choice");

		while (!exit) {
			System.out
					.println("1.Create/Add Contact\t 2.Update Contact\t 3.Delete Contact\t 4.Search Contact\t 5.Quit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Add New Contact");
				services.get(addressBookNameAsKey).addContact(null);
				break;
			case 2:
				System.out.println("Update Contact");
				services.get(addressBookNameAsKey).editContact();
				break;
			case 3:
				System.out.println("Delete Contact");
				services.get(addressBookNameAsKey).deleteContactByName();
				break;
			case 4:
				System.out.println("Search Contact");
				services.get(addressBookNameAsKey).searchContact();
				System.out.println("AddressBook name is : " + addressBookNameAsKey);
				break;
			case 5:
				exit = true;
				System.out.println("Thank you.....!!!");
				break;
			default:
				System.out.println("Application is quit...");
				break;
			}
		}
		System.out.println("You are out of choice of multiple addressbook");
	}

}

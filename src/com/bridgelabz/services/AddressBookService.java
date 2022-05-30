package com.bridgelabz.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.entity.Contact;

public class AddressBookService {

	List<Contact> listContact = new ArrayList<Contact>();
	Contact con = new Contact(toString(), toString(), toString(), toString(), toString(), toString(), toString(),
			toString());
	static Scanner scanner = new Scanner(System.in);

	// Create Contacts
	public void createContact() {
		System.out.println("Enter Person Details:");
		System.out.println("Enter first Name");
		String firstName = scanner.next();

		System.out.println("Enter last Name");
		String lastName = scanner.next();

		System.out.println("Enter Email");
		String email = scanner.next();

		System.out.println("Enter phone number");
		String phoneNumber = scanner.next();

		System.out.println("Enter address");
		String address = scanner.next();

		System.out.println("Enter state");
		String state = scanner.next();

		System.out.println("Enter city");
		String city = scanner.next();

		System.out.println("Enter zip");
		String zip = scanner.next();

		listContact.add(new Contact(firstName, lastName, email, phoneNumber, address, state, city, zip));
		// printContacts();
	}

	// Adding new contact method
	public void addContact(Contact contact) {
		try {
			createContact();
			System.out.println("Enter firstname and lastname");
			String name = scanner.next() + "" + scanner.next();

			Iterator<Contact> iterator = listContact.listIterator();

			while (iterator.hasNext()) {
				Contact contacts = iterator.next();
				if (name.equals(contacts.getFirstName() + "" + contacts.getLastName())) {
					System.out.println("Duplicate entry add new contact press 1 ");
				} else {
					System.out.println("Enter Person Details:");

					System.out.println("Enter first Name");
					String firstName = scanner.next();

					System.out.println("Enter last Name");
					String lastName = scanner.next();

					System.out.println("Enter Email");
					String email = scanner.next();

					System.out.println("Enter phone number");
					String phoneNumber = scanner.next();

					System.out.println("Enter address");
					String address = scanner.next();

					System.out.println("Enter state");
					String state = scanner.next();

					System.out.println("Enter city");
					String city = scanner.next();

					System.out.println("Enter zip");
					String zip = scanner.next();

					listContact.add(new Contact(firstName, lastName, email, phoneNumber, address, state, city, zip));
					printContacts();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Print Contacts
	public Contact printContacts() {
		if (listContact.isEmpty()) {
			System.out.println("No Records!!!");
		} else {
			for (Contact contacts : listContact) {
				System.out.println(contacts);
			}
		}
		return con;
	}

	// Edit and update Contacts
	public void editContact() {
		System.out.println("Enter the person name for update");
		String firstName = scanner.next();

		Iterator<Contact> iterator = listContact.listIterator();

		while (iterator.hasNext()) {
			Contact contacts = iterator.next();
			if (firstName.equals(contacts.getFirstName())) {
				System.out.println("Edit the details of person");
				System.out.println("Enter first Name");
				String firstName1 = scanner.next();
				contacts.setFirstName(firstName1);

				System.out.println("Enter last Name");
				String lastName = scanner.next();
				contacts.setLastName(lastName);

				System.out.println("Enter Email");
				String email = scanner.next();
				contacts.setEmail(email);

				System.out.println("Enter phone number");
				String phoneNumber = scanner.next();
				contacts.setPhoneNumber(phoneNumber);

				System.out.println("Enter state");
				String state = scanner.next();
				contacts.setState(state);

				System.out.println("Enter city");
				String city = scanner.next();
				contacts.setCity(city);

				System.out.println("Enter zip");
				String zip = scanner.next();
				contacts.setZip(zip);

				printContacts();

			} else {
				System.out.println("Person not found");
			}
		}
	}

	// Delete contacts
	public void deleteContactByName() {
		try {
			System.out.println("Enter first name for delete contact:");
			String firstName = scanner.next();

			Iterator<Contact> iterator = listContact.listIterator();

			while (iterator.hasNext()) {
				Contact contacts = iterator.next();
				if (firstName.equals(contacts.getFirstName())) {
					listContact.remove(contacts);
					System.out.println("Contact: " + contacts.getFirstName() + " " + "deleted successfully...");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		printContacts();
	}

	// Search contact with city name
	public void searchContact() {
		boolean exit = false;
		System.out.println("Enter Your Choice");

		while (!exit) {

			System.out.println("1.Search by city \t 2.Search by state  \t *.Default");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("****Search person by city****");
				System.out.println("Enter city name ");
				String city = scanner.next();
				int countCity = 0;
				if (listContact.isEmpty()) {
					System.out.println("No Records!!!");
				}
				for (Contact result : listContact) {
					if (city.equalsIgnoreCase(result.getCity())) {
						System.out.println("View persons contact by searching city :");
						System.out.println(result);
						countCity++;
						System.out.println("The number of persons in city :" + countCity);
					} else {
						System.out.println();
					}
				}
				break;
			case 2:
				System.out.println("****Search person by state****");
				System.out.println("Enter state name");
				String state = scanner.next();
				int countState = 0;
				if (listContact.isEmpty()) {
					System.out.println("No Records!!!");
				}
				for (Contact result : listContact) {
					if (state.equalsIgnoreCase(result.getState())) {
						System.out.println("View persons contact by searching state :");
						System.out.println(result);
						countState++;
						System.out.println("The number of persons in state :" + countState);
					} else {
						System.out.println();
					}
				}
			default:
				exit = true;
				System.out.println("Exit Choices");
				break;

			}
		}
	}
}

package com.example.tests;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3){
			System.out.println("Please specify parameters: <amount of test data> <file> <format>");
			return;	
		}
		
		int amount = Integer.parseInt(args[0]);
		File file = new File(args[1]);
		String format = args[2];
		
		if (file.exists()) {
			System.out.println("File already exist, please remove it manually: " + file);
			return;	
		}
		
		List<ContactData> contacts = generateRandomContacts(amount);
		if("csv".equals(format)) {
			saveContactsToCsvFile(contacts, file);
		} else if("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
		}
	}

	public static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		}
	
	private static List<ContactData> loadContactsFromXmlFile(File file) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + "," + contact.getAddress() + "\n");
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		for (int i=0; i < amount; i++){
			ContactData contact = new ContactData()
			.withFirstname(generateRandomString())
			.withLastname(generateRandomString())
			.withAddress(generateRandomString());
			list.add(contact);	
		}
		return list;
	}
	
	public static String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0){
			return  "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
}

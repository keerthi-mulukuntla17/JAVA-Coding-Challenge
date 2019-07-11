package Transactions;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import au.com.bytecode.opencsv.CSVReader;

public class ParseCSV {
	public static void main(String[] args) throws Exception {

		// Enter data using BufferReader
		System.out.println("Please enter the Account ID");
		BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

		// Reading account id data using readLine
		String account = reader1.readLine();
		// Printing the read line
		System.out.println("You entered the Account ID: " + account);
		System.out.println("---------------------------");
		System.out.println("Please enter the from Date and Time");

		// Reading and Printing "From DateandTime" data using readLine
		String f = reader1.readLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");
		// convert String to LocalDate
		LocalDateTime localDate = LocalDateTime.parse(f, formatter);
		System.out.println("You entered the from DateandTime: " + localDate.toString());
		System.out.println("---------------------------");

		// Reading and Printing "To DateandTime" data using readLine
		System.out.println("Please enter the To Date and Time");
		String t = reader1.readLine();
		// convert String to LocalDate
		LocalDateTime localDate1 = LocalDateTime.parse(t, formatter);
		System.out.println("You entered the To DateandTime: " + localDate1.toString());
		System.out.println("---------------------------");

		ParseCSV csv = new ParseCSV();

		csv.calc(account, localDate, localDate1);

	}

	public void calc(String accountID, LocalDateTime f, LocalDateTime t) {
		int count = 0;
		double balance = 0.00;
		final String PAYMENT = "PAYMENT";
		// convert String to LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HH:mm:ss");

		try {
			// Build reader instance
			// Read Input.csv
			// Default separator is comma
			// Default quote character is double quote
			CSVReader reader = new CSVReader(new FileReader("/Users/664524/Desktop/Input.csv"), ',', '"', 1);
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				if (nextLine != null) {
					// System.out.println(Arrays.toString(nextLine));
					MyPOJO myPOJO = new MyPOJO();
					myPOJO.setFromAccountId(nextLine[1]);
					myPOJO.setToAccountId(nextLine[2]);
					myPOJO.setCreatedAt(LocalDateTime.parse(nextLine[3], formatter)); // Changing the date and time
																						// format
					myPOJO.setAmount(Double.parseDouble(nextLine[4])); // Converting String into double
					myPOJO.setTransactionType(nextLine[5]);

					if (myPOJO.getCreatedAt().isAfter(f) && myPOJO.getCreatedAt().isBefore(t)) {
						if (myPOJO.getTransactionType().equals(PAYMENT)) {

							if (myPOJO.getFromAccountId().equals(accountID)) {
								count += 1;
								balance -= myPOJO.getAmount();
							}
							if (myPOJO.getToAccountId().equals(accountID)) {
								count += 1;
								balance += myPOJO.getAmount();

							}
						} else
							count += 1;

					}
				}
			}

			System.out.println("Relative balance for the period = " + balance + "$");
			System.out.println("Number of transactions included =" + count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

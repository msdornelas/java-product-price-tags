package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of products: ");
		Integer numberOfProducts = sc.nextInt();
		sc.nextLine();

		List<Product> products = new ArrayList<>();

		for (int i = 1; i <= numberOfProducts; i++) {
			Product p;

			System.out.println("Product #" + i + " data:");

			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.nextLine().charAt(0);

			System.out.print("Name: ");
			String name = sc.nextLine();

			System.out.print("Price: ");
			Double price = sc.nextDouble();
			sc.nextLine();

			if (type == 'i') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				sc.nextLine();

				p = new ImportedProduct(name, price, customsFee);
			} else if (type == 'u') {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.nextLine());

				p = new UsedProduct(name, price, manufactureDate);
			} else {
				p = new Product(name, price);
			}
			
			products.add(p);
		}

		System.out.println("PRICE TAGS:");

		for (Product p : products) {
			System.out.println(p);
		}

		sc.close();
	}

}

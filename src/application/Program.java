package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println();
		System.out.println("Enter order data:");
		System.out.print("Status:");
		String status = sc.next();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.print("How many items to this order ? ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + " item data");
			
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			order.addItem(orderItem);
			System.out.println();
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: " + sdf1.format(order.getDate()));
		System.out.println("Order status: " + order.getStatus());
		System.out.println("Client: " + client.getName() + " (" + sdf.format(client.getBirthDate()) + ")" + " - " + client.getEmail());
		System.out.println("Order Items:");
		for (OrderItem item : order.getItens()) {
			System.out.println(item.getProduct().getName() + ", $" + item.getPrice() + ", Quantity: " + item.getQuantity() + ", Subtotal: " + item.subTotal());
		}
		System.out.println("Total price: " + order.total());
		
		
		
		sc.close();
	}
}

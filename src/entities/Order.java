package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date date = new Date();
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	
	public Order() {
		super();
	}

	public Order(Date date, OrderStatus status, Client client) {
		super();
		this.date = date;
		this.status = status;
		this.client = client;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItens() {
		return itens;
	}
	
	public void addItem(OrderItem item) {
		this.itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.itens.remove(item);
	}
	
	public double total() {
		double sum =0.0;
		
		for (OrderItem item : itens) {
			sum += item.subTotal();
		}
		
		return sum;
	}
	
	
}

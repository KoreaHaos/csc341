package assignment09;

public class Order {
	private Client client;
	private Item[] items;
	private OrderState state;

	public Order(Client client, Item[] items) {
		this.client = client;
		this.items = items;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Item[] getItems() {
		return items;
	}
	
	public void setItems(Item[] items) {
		this.items = items;
	}
	
	public OrderState getState() {
		return state;
	}
	
	public void setState(OrderState state) {
		this.state = state;
	}
	
}

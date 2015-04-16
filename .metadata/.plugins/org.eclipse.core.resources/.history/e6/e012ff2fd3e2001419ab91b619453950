package assignment09;

import java.util.List;
import java.util.Queue;

public class Orders {
	private List<Order> PendingOrders;
	private Queue<Order> ApprovedOrders;
	
	public void add(Order order) {
		if (order.getClient().getStateConstant() == CCState.Pending) PendingOrders.add(order);
		else ApprovedOrders.add(order);
	}
	
	public void remove(Order order) {
		if (PendingOrders.contains(order)) PendingOrders.remove(order);
		else if (ApprovedOrders.contains(order)) ApprovedOrders.remove(order);
		else return;
	}
	
	public void update() {
		for (Order o : PendingOrders) {
			if (o.getClient().getStateConstant() == CCState.Approved) {
				ApprovedOrders.add(PendingOrders.get(PendingOrders.indexOf(o)));
			}
		}
	}
	
	public Order search(String name) {
		Order _order = null;
		
		for (Order o : PendingOrders) {
			if (o.getClient().getName().equalsIgnoreCase(name)) _order = o;
		}
		
		if (_order == null) {
			for (Order o : ApprovedOrders) {
				if (o.getClient().getName().equalsIgnoreCase(name)) _order = o;
			}
		}
		
		return _order;
	}
}

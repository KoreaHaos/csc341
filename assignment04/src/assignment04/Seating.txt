package assignment04;

public class Seating {
	
	// checks if seating request is available
	public Response request(String position) {
		Response response = new Response(){};
		
		// check if seating  is available
		// return response with success or fail w/reason
		
		return response;
	}
	
	// checks if seating for multiple seats are available
	public Response request(String[] positions) {
		Response response = new Response(){};
		
		// check if seating  is available
		// return response with success or fail w/reason
		
		return response;
	}
	
	public Response bookSeat(Customer customer, String position) {
		Response response = new Response(){};
		
		// create booking
		// process payment info
		// return response with success or fail w/reason
		
		return response;		
	}
	
	public Response bookSeat(Customer[] customers, String[] positions) {
		Response response = new Response(){};
		
		// create booking
		// process payment info
		// return response with success or fail w/reason
		
		return response;
	}
	
	// cancels seat on plane
	public Response cancellation(Seat seat) {
		Response response = new Response(){};
		
		// remove data from plane's database
		_deleteBooking(seat);
		// refund money
		_refundMoney(seat.customerData);
		
		return response;
	}
	
	// refunds money to customer
	private void _refundMoney(Customer customer) {
		// This contacts separate program or user notifying them to refund customer.
	}
	
	// deletes seat request
	private void _deleteBooking(Seat seat) {
		// connect to database and remove the customer from seat.
	}
}

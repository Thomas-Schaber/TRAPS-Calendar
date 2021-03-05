import java.awt.event.ActionEvent;

import javax.swing.*;

public class TRAPSCalendarInterface {
	WidgetViewer window = new WidgetViewer(900, 600);
	private JLabel eventLabel = new JLabel("Event Name");
	private JTextField eventBox = new JTextField();
	private JLabel venueLabel = new JLabel("Event Venue");
	private JTextField venueBox = new JTextField();
	private JLabel venueCapacityLabel = new JLabel("Venue Capacity");
	private JTextField venueCapacityBox = new JTextField();
	private JLabel eventDateLabel = new JLabel("Event Date");
	private JTextField eventDateBox = new JTextField("2020-");
	private JLabel ticketsSoldLabel = new JLabel("Tickets Sold");
	private JTextField ticketsSoldBox = new JTextField();
	private JLabel ticketPriceLabel = new JLabel("Ticket Price");
	private JTextField ticketPriceBox = new JTextField();
	private JLabel overheadCostLabel = new JLabel("Overhead Costs");
	private JTextField overheadCostBox = new JTextField();
	private JButton createEventButton = new JButton("Create an Event");
	private JButton sellTicketsButton = new JButton("Sell tickets");
	private JButton resetListButton = new JButton("Reset List");
	private JButton sortByDateButton = new JButton("Sort by Date");
	private JButton sortByProfitButton = new JButton("Sort by Profit");
	private JTextArea displayCal = new JTextArea();
	
	
	public TRAPSCalendarInterface() {
		TRAPSCalendar cal = new TRAPSCalendar();
		//Event e1 = new Event("Event 1", "RBC Center", 100, "2020-05-05", 23, 10, 30);
		//Event e2 = new Event("Event 2", "RBC Center", 100, "2020-05-03", 23, 14, 30);
		//cal.add(e1);
		//cal.add(e2);
				
		window.add(eventLabel,20, 20, 200, 20 );
		window.add(eventBox,20, 40, 200, 20 );
		window.add(venueLabel, 20, 60, 200, 20);
		window.add(venueBox, 20, 80, 200, 20);
		window.add(venueCapacityLabel,20, 100, 200, 20 );
		window.add(venueCapacityBox,20, 120, 200, 20 );
		window.add(eventDateLabel, 20, 140, 200, 20);
		window.add(eventDateBox, 20, 160, 200, 20);
		window.add(ticketsSoldLabel,20, 180, 200, 20 );
		window.add(ticketsSoldBox,20, 200, 200, 20 );
		window.add(ticketPriceLabel, 20, 220, 200, 20);
		window.add(ticketPriceBox, 20, 240, 200, 20);
		window.add(overheadCostLabel, 20, 260, 200, 20);
		window.add(overheadCostBox, 20, 280, 200, 20);
		window.add(createEventButton, 20, 300, 200, 20);
		createEventButton.addActionListener(new CreateEvent(cal, eventBox, venueBox, venueCapacityBox, eventDateBox, ticketsSoldBox, ticketPriceBox, overheadCostBox, displayCal));
		
		window.add(sellTicketsButton, 20, 320, 200, 20);
		sellTicketsButton.addActionListener(new SellTicketsEvent(cal, eventBox, ticketsSoldBox, displayCal));
		
		window.add(resetListButton, 20, 340, 200, 20);
		resetListButton.addActionListener(new resetListEvent(cal, displayCal));
		
		window.add(sortByDateButton, 20, 360, 200, 20);
		sortByDateButton.addActionListener(new sortEvent("sortByDate", cal, displayCal));
		window.add(sortByProfitButton, 20, 380, 200, 20);
		sortByProfitButton.addActionListener(new sortEvent("sortByProfit", cal, displayCal));
		window.add(displayCal, 20, 410, 850, 100);



		
		
		
	}
}

	class CreateEvent extends WidgetViewerActionEvent {
		
		private TRAPSCalendar cal;
		private JTextField eventName;
		private JTextField venue;
		private JTextField venueCapacity;
		private JTextField eventDate; 
		private JTextField ticketsSold;
		private JTextField ticketPrice;
		private JTextField overheadCost;
		private JTextArea displayCal;
		
		
		public CreateEvent(TRAPSCalendar cal, JTextField eventName, JTextField venue, JTextField venueCapacity, JTextField eventDate, JTextField ticketsSold, JTextField ticketPrice, JTextField overheadCost, JTextArea displayCal) {
			this.cal = cal;
			this.eventName = eventName;
			this.venue = venue;
			this.venueCapacity = venueCapacity;
			this.eventDate = eventDate; 
			this.ticketsSold = ticketsSold;
			this.ticketPrice = ticketPrice;
			this.overheadCost = overheadCost;
			this.displayCal = displayCal;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Event event1;
			boolean addEvent = true;
			String eventNamestr = eventName.getText();
			String eventVenuestr = venue.getText();
			String eventDatestr = eventDate.getText();
			//int ticketsSoldNum = Integer.parseInt(ticketsSold.getText());
			


			//lines(110-137) Search characters in input for letters where digits are expected
			for(int x = 0; x <= venueCapacity.getText().length() - 1; x++) {
				if(!Character.isDigit(venueCapacity.getText().charAt(x))) {
					venueCapacity.setText("Invalid input");
					addEvent = false;
					break;
				} 
			}
			for(int x = 0; x <= ticketsSold.getText().length() - 1; x++) {
				if(!Character.isDigit(ticketsSold.getText().charAt(x))) {
					ticketsSold.setText("Invalid input");
					addEvent = false;
					break;
				} 
			}
			for(int x = 0; x <= ticketPrice.getText().length() - 1; x++) {
				if(!Character.isDigit(ticketPrice.getText().charAt(x))) {
					ticketPrice.setText("Invalid input");
					addEvent = false;
					break;
				} 
			}
			for(int x = 0; x <= overheadCost.getText().length() - 1; x++) {
				if(!Character.isDigit(overheadCost.getText().charAt(x))) {
					overheadCost.setText("Invalid input");
					addEvent = false;
					break;
				} 
			}
			//event1.setVenueCapacity​(Integer.parseInt(venueCapacity.getText()));

			//event1.setTicketsSold​(Integer.parseInt(ticketsSold.getText()));
			//event1.setTicketPrice​(Integer.parseInt(ticketPrice.getText()));
			//event1.setOverhead​(Integer.parseInt(overheadCost.getText()));
			if(addEvent) {
				//only create an instance of Event object when addEvent is true(prevents creation of a null event)
				event1 = new Event();
				if(cal.add(event1)) {
					
					
					event1.setEventName​(eventNamestr);
					event1.setEventVenue​(eventVenuestr);
					event1.setDate​(eventDatestr);
					event1.setVenueCapacity​(Integer.parseInt(venueCapacity.getText()));
					event1.setTicketsSold​(Integer.parseInt(ticketsSold.getText()));
					event1.setTicketPrice​(Integer.parseInt(ticketPrice.getText()));
					event1.setOverhead​(Integer.parseInt(overheadCost.getText()));
				
					displayCal.setText(cal.list().toString());
					//System.out.println(addEvent);
					eventName.setText("");
					venue.setText("");
					venueCapacity.setText("");
					eventDate.setText("2020-");
					ticketsSold.setText("");
					ticketPrice.setText("");
					overheadCost.setText("");	
				}
			}
			addEvent = true;

		

		}
		
		
	}
	
	class SellTicketsEvent extends WidgetViewerActionEvent {
		private TRAPSCalendar cal;
		private JTextField eventName;
		private JTextField ticketsSold;
		private JTextArea display;
		
		
		
		public SellTicketsEvent(TRAPSCalendar cal, JTextField eventName, JTextField ticketsSold, JTextArea display) {
			this.cal = cal;
			this.eventName = eventName; 
			this.ticketsSold = ticketsSold;
			this.display = display;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String eventNamestr = eventName.getText();
			Event eventObj = cal.get(eventNamestr);
			if(eventObj != null) {
				if(eventObj.sellTickets(Integer.parseInt(ticketsSold.getText()))){
					eventObj.setTicketsSold​(eventObj.getTicketsSold() + Integer.parseInt(ticketsSold.getText()));
					//System.out.println(eventObj.getTicketsSold());
					display.setText(cal.list().toString());
					
				} else {
					ticketsSold.setText("Error: " + (eventObj.getVenueCapacity() - eventObj.getTicketsSold()) + " Ticket/s left");
				}	
			}
		}
	}

	class resetListEvent extends WidgetViewerActionEvent{
		private TRAPSCalendar cal;
		private JTextArea displayCal;
		
		public resetListEvent(TRAPSCalendar cal, JTextArea displayCal) {
			this.cal = cal;
			this.displayCal = displayCal;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			displayCal.setText(cal.list().toString());
			//System.out.println(cal.toString());
		}
		
		
	}
	
	class sortEvent extends WidgetViewerActionEvent {
		private String sortBy;
		private TRAPSCalendar cal;
		private JTextArea display;
		
		public sortEvent(String sortBy, TRAPSCalendar cal, JTextArea display) {
			this.sortBy = sortBy;
			this.cal = cal;
			this.display = display;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(sortBy.equals("sortByDate") && cal.size() > 0) {
				display.setText(cal.sortByDate().toString());
				//System.out.println(cal.sortByDate());
				
				
			} else if (cal.size() > 0) {
				display.setText(cal.sortByProfit().toString());
				//System.out.println(cal.sortByProfit());
			}
			
			
		}
	}
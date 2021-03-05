import java.util.ArrayList;
import java.util.Arrays;

public class TRAPSCalendar {
	private ArrayList<Event> calendar = new ArrayList<Event>(10);	
	
	public TRAPSCalendar() {
		
	}
	
	public boolean add(Event evt) {
		return calendar.add(evt);
	}
	
	public Event get​(int i) {
		if(i <= calendar.size() -1) {
			return calendar.get(i);
		}
		
		return null;
	}
	
	public Event get(String name) {
		for(int x = 0; x <= calendar.size() -1; x++) {
			if(calendar.get(x).getEventName().equals(name)) {
				return calendar.get(x);
			}
		}
		return null;
	}
	
	public int size() {
		return calendar.size();
	}
	
	public ArrayList<Event> list() {
		ArrayList<Event> list = new ArrayList<Event>(calendar.size() -1);
		for(int x = 0; x <= calendar.size() -1; x++) {
			list.add(calendar.get(x));
		}
		return list;
	}
	
	public ArrayList<Event> sortByProfit() {
		ArrayList<Event> copy = new ArrayList<Event>(calendar.size());
		ArrayList<Event> sorted = new ArrayList<Event>(calendar.size());

		Event[] list = new Event[copy.size()];
		for(int x = 0; x <= calendar.size() -1; x++) {
			copy.add(calendar.get(x));
		}
		list = copy.toArray(list);
		
		///for(int y = 0; y < list.length; y++) {
			//System.out.println(list[y] + " ");
		//}
		 for (int i = 0; i < list.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      Event currentMin = list[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < list.length; j++) {
		        if (currentMin.getProfit() > list[j].getProfit()) {
		          currentMin = list[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        list[currentMinIndex] = list[i];
		        list[i] = currentMin;
		      }
		    }
		 for (int x = 0; x < list.length; x++) {
			 sorted.add(x, list[x]);
		 }
		 
	

		return sorted;
		
	}
	
	public ArrayList<Event> sortByName() {
		ArrayList<Event> copy = new ArrayList<Event>(calendar.size());
		ArrayList<Event> sorted = new ArrayList<Event>(calendar.size());

		Event[] list = new Event[copy.size()];
		for(int x = 0; x <= calendar.size() -1; x++) {
			copy.add(calendar.get(x));
		}
		list = copy.toArray(list);
		
		 for (int i = 0; i < list.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      Event currentMin = list[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < list.length; j++) {
		        if (currentMin.compareName​(list[j]) > 0) {
		          currentMin = list[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        list[currentMinIndex] = list[i];
		        list[i] = currentMin;
		      }
		    }
		 for (int x = 0; x < list.length; x++) {
			 sorted.add(x, list[x]);
		 }

		return sorted;
	}
	
	public ArrayList<Event> sortByDate(){
		ArrayList<Event> copy = new ArrayList<Event>(calendar.size());
		ArrayList<Event> sorted = new ArrayList<Event>(calendar.size());

		Event[] list = new Event[copy.size()];
		for(int x = 0; x <= calendar.size() -1; x++) {
			copy.add(calendar.get(x));
		}
		list = copy.toArray(list);
		

		 for (int i = 0; i < list.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      Event currentMin = list[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < list.length; j++) {
		        if (currentMin.compareDate​(list[j]) > 0) {
		          currentMin = list[j];
		          currentMinIndex = j;
		        }
		      }

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		        list[currentMinIndex] = list[i];
		        list[i] = currentMin;
		      }
		    }
		 for (int x = 0; x < list.length; x++) {
			 sorted.add(x, list[x]);
		 }
		 
	
		return sorted;
	} 
	
	
	public String toString() {
		String str = "";
		for (int x = 0; x <= calendar.size() -1; x++) {
				str += calendar.get(x) + " ";
		}
		return str;
	}
}
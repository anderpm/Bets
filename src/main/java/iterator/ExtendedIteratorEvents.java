package iterator;

import java.util.Vector;

import domain.Event;


public class ExtendedIteratorEvents implements ExtendedIterator {

	Vector<Event> events;
	int i = 0;
	
	public ExtendedIteratorEvents(Vector<Event> bektorea) {
		this.events = bektorea;
		
	}
	
	@Override
	public boolean hasNext() {
		return events.size()>i;
	}

	@Override
	public Object next() {
		Event e = events.get(i);
		i++;
		return e;
	}

	@Override
	public Object previous() {
		Event e = events.get(i);
		i--;
		return e;
	}

	@Override
	public boolean hasPrevious() {
		return i>=0;
	}

	@Override
	public void goFirst() {
		i=0;
	}

	@Override
	public void goLast() {
		i=events.size()-1;
	}

}
package iterator;

import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.BusinessLogicFactory;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;

public class Main {
	
	public static void main(String[] args) {
		
		BusinessLogicFactory bsl = new BusinessLogicFactory();
		
		try {
			BLFacade facade = bsl.initBusinessLogicFactory(ConfigXML.getInstance());
			
			Date data = new SimpleDateFormat("yyyy-MM-dd").parse("2021-12-17"); 
			
			ExtendedIterator<Event> ei = facade.getEventsIt(data);
			
			Event e;
			
			System.out.println("--------------------------------");

			System.out.println("Event-ak ordenean:");
			while(ei.hasNext()) {
				e = ei.next();
				System.out.println(e.getEventNumber() + " " + e.getDescription());
			}
			
			System.out.println("--------------------------------");
			
			System.out.println("Event-ak alderantzizko ordenean:");
			ei.goLast();
			while(ei.hasPrevious()) {
				e = ei.previous();
				System.out.println(e.getEventNumber() + " " + e.getDescription());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
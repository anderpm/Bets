package adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.BLFacade;
import businessLogic.BusinessLogicFactory;
import configuration.ConfigXML;
import configuration.UtilDate;
import dataAccess.DataAccess;
import domain.Bezeroa;
import domain.Event;
import domain.Question;
import domain.User;

public class Main {

	public static void main(String[] args) {
		
		BusinessLogicFactory bsl = new BusinessLogicFactory();
		BLFacade facade;
		try {
			facade = bsl.initBusinessLogicFactory(ConfigXML.getInstance());
			
			User u = facade.getUserByUserName("ander");			
			Bezeroa be = (Bezeroa)u;
			
			ErabiltzaileApustuAdapter model = new ErabiltzaileApustuAdapter(be);			

			JFrame j = new JFrame();
			JTable table = new JTable(model);
			j.add(new JScrollPane(table));

			j.setTitle(be.getUserName() + "-en apustuak:");
			j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			j.pack();
			j.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

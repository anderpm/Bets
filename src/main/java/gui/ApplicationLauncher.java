package gui;

import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.BusinessLogicFactory;

public class ApplicationLauncher { 
	
	public static void main(String[] args) {

		ConfigXML c = ConfigXML.getInstance();
		System.out.println(c.getLocale());
		Locale.setDefault(new Locale(c.getLocale()));
		System.out.println("Locale: " + Locale.getDefault());
		
		MainGUI a = new MainGUI();
		a.setVisible(true);
		
		BusinessLogicFactory blf = new BusinessLogicFactory();
		BLFacade appFacadeInterface;
		
		try {
			appFacadeInterface = blf.initBusinessLogicFactory(c);
			MainGUI.setBussinessLogic(appFacadeInterface);
		} catch (Exception e) {
			System.out.println("Error in ApplicationLauncher: " + e.toString());
		}	
		
	}
	
}


package businessLogic;

import java.net.URL;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class BusinessLogicFactory {

	public BLFacade initBusinessLogicFactory(ConfigXML c) throws Exception{
						
		BLFacade appFacadeInterface;
		UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		
		if(c.isBusinessLogicLocal()) {
			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			appFacadeInterface=new BLFacadeImplementation(da);
		} else {
			String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
			URL url = new URL(serviceName);
			QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
			Service service = Service.create(url, qname);
			appFacadeInterface = service.getPort(BLFacade.class);
		}
		
		return appFacadeInterface;
		
	}
	
}


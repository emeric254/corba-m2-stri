package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Main.MessageImpl;

public class Server extends Thread {

	private String[] args;
	private org.omg.CORBA.ORB orb;
	private POA rootPOA;
	private MessageImpl myMsg;
	
	public Server (String[] a) {
		args=a;
	}

	public void corbaInitS() {
		try {
			orb = org.omg.CORBA.ORB.init(args,null);
	        rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	        myMsg = new MessageImpl();
	        rootPOA.activate_object(myMsg);
	        rootPOA.the_POAManager().activate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void nameRegister() {
		try {
			NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	        org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
	        System.out.println("Sous quel nom voulez-vous vous enregistrer ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String nomObj = in.readLine();
	        nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");
	        nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(myMsg));
	        System.out.println("'"+ nomObj + "' est maintenant enregistré.");
	        System.out.println("Thread notifié");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void run () {
        orb.run();
	}
	
}

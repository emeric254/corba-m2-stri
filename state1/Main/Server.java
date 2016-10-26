package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import Main.MessageImpl;

public class Server {

public static void main (String[] args) {
	try {
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

        POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

        MessageImpl myMsg = new MessageImpl();

        rootPOA.activate_object(myMsg);

        rootPOA.the_POAManager().activate();

        NamingContext nameRoot=org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

        org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
        System.out.println("Sous quel nom voulez-vous vous enregistrer ?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String nomObj = in.readLine();
        nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj,"");

        nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(myMsg));
        System.out.println("'"+ nomObj + "' est maintenant enregistré.");
        
        orb.run();

    }
	catch (Exception e) {
		e.printStackTrace();
	}
}
	
}

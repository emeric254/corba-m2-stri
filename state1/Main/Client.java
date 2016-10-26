package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Talk.Message;

public class Client {

	public static Talk.Step1 myMsg;
	
	public static void main (String[] args) {
		try {
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
	
	        System.out.println("Quel objet Corba voulez-vous contacter ?");
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String idObj = in.readLine();
	
	        org.omg.CosNaming.NamingContext nameRoot =
	        		org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
	
	        org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
	         nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");
	
	        org.omg.CORBA.Object distantMessage = nameRoot.resolve(nameToFind);
	
	        myMsg = Talk.Step1Helper.narrow(distantMessage);
	        
	        // Demander un messsage, un nom d'auteur et un dest
	        
	        Message m = new Message("Pomme","Auteur = Moi","Dst = nous");
	        myMsg.printMsg(m);

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

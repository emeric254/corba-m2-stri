package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server
{
    public static void main (String[] args)
    {
        try
        {
        	// Init
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            
            // Activation
            ChatImpl chat = new ChatImpl();
            rootPOA.activate_object(chat);
            rootPOA.the_POAManager().activate();

            // Launching the naming service
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];

            // Obtaining the name of the chat to register
            System.out.println("Register with a name:");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String nomObj = in.readLine();

            // Registering the chat
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(chat));
            System.out.println("'" + nomObj + "' is now registered and waiting for messages.");

            // Supervising the chat (signing up & broadcasting messages)
            orb.run();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

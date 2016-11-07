package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.omg.CosNaming.NamingContext;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import Talk.Message;

public class Client extends Thread
{
    public static Talk.Chat chat;

    public static void main (String[] args)
    {
        try
        {
            /********************************
             * Creation of the Step1 object *
             ********************************/
            // Init
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            // Activation
            MessageImpl mImp = new MessageImpl();
            rootPOA.activate_object(mImp);
            rootPOA.the_POAManager().activate();
            // Naming service launch
            NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToRegister = new org.omg.CosNaming.NameComponent[1];
            // Obtaining the client's name
            System.out.println("Register with a name:");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String nomObj = in.readLine();
            // Registering the client's name
            nameToRegister[0] = new org.omg.CosNaming.NameComponent(nomObj, "");
            nameRoot.rebind(nameToRegister,rootPOA.servant_to_reference(mImp));

            /*****************************
             * Resolve Chat object name  *
             *****************************/
            // Obtaining the chat's name
            System.out.println("What's the receiver name ?");
            String idObj = in.readLine();
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
            // Searching for the chat name
            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");
            org.omg.CORBA.Object distantReceiver = nameRoot.resolve(nameToFind);
            chat = Talk.ChatHelper.narrow(distantReceiver);
            // Registering to the chat
            chat.inscription(Talk.Step1Helper.narrow(rootPOA.servant_to_reference(mImp)));

            // Sending messages
            Message m = new Message("", nomObj);
            System.out.println("Write your messages (one line per message):");
            while (true)
            {
                try
                {
                    m.msg = in.readLine();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                chat.diffusion(m);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Talk.Message;

public class Client extends Thread
{
    public Talk.Step1 myMsg;
    private String[] args;
    private org.omg.CORBA.ORB orb;

    public Client (String[] a)
    {
        args = a;
    }

    public void corbaInitC()
    {
        orb = org.omg.CORBA.ORB.init(args, null);
    }

    public String findContact()
    {
        try
        {
            System.out.println("What's the receiver name ?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String idObj = in.readLine();

            org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];

            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");
            org.omg.CORBA.Object distantMessage = nameRoot.resolve(nameToFind);

            myMsg = Talk.Step1Helper.narrow(distantMessage);
            return idObj;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void run ()
    {
        try
        {
            String id = findContact();
            Message m = new Message("", "Client", id);

            System.out.println("Write your messages (one line per message):");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                m.msg = input.readLine();
                myMsg.printMsg(m);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

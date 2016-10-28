package Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import Talk.Message;

public class Client
{
    public static Talk.Step1 myMsg;

    public static void main (String[] args)
    {
        try
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
            org.omg.CosNaming.NamingContext nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
            org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];

            System.out.println("What's the receiver name ?");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String idObj = in.readLine();

            nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj, "");
            org.omg.CORBA.Object distantReceiver = nameRoot.resolve(nameToFind);
            myMsg = Talk.Step1Helper.narrow(distantReceiver);

            Message m = new Message("", "Myself", idObj);
            System.out.println("Write your messages (one line per message):");
            while (true)
            {
                m.msg = in.readLine();
                myMsg.printMsg(m);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

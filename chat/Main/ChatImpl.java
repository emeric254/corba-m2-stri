package Main;

import java.util.ArrayList;
import Talk.Message;

public class ChatImpl extends Talk.ChatPOA
{
    private ArrayList<Talk.Step1> register;

    public ChatImpl()
    {
        register = new ArrayList<Talk.Step1>();
    }

    // Add a member to the chat
    public void inscription (Talk.Step1 s)
    {
        register.add(s);
    }

    // Broadcast a message to the registered users
    public void diffusion(Message m)
    {
        System.out.println(register.size());
        for (int i=0;i<register.size();i++)
        {
            System.out.println(register.get(i));
            register.get(i).printMsg(m);
        }
    }

}

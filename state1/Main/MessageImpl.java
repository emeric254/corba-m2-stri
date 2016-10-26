package Main;

import Talk.Message;

public class MessageImpl extends Talk.Step1POA {

	public void printMsg(Message m) {
		System.out.println(m.author+" a écrit : "+m.msg);
	}
	
}

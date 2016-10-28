package Main;

public class Main {
	
	public static void main (String[] args) {
		// Init the server
		Server s = new Server(args);
		s.corbaInitS();
		s.nameRegister();
		
		// Init the client
		Client c = new Client(args);
		c.corbaInitC();
		
		// Thread
		s.start();
		c.start();
	}
	
}

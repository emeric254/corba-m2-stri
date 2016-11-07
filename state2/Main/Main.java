package Main;

public class Main
{
    public static void main (String[] args)
    {
        // Create and Init the server part
        Server s = new Server(args);
        s.corbaInitS();
        s.nameRegister();

        // Create and Init the client part
        Client c = new Client(args);
        c.corbaInitC();

        // Launch server and client (Threads)
        s.start();
        c.start();
    }
}

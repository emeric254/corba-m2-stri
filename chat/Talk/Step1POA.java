package Talk;


/**
* Talk/Step1POA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* vendredi 4 novembre 2016 15 h 14 CET
*/

public abstract class Step1POA extends org.omg.PortableServer.Servant
 implements Talk.Step1Operations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("printMsg", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Talk/Step1/printMsg
       {
         Talk.Message m = Talk.MessageHelper.read (in);
         this.printMsg (m);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Talk/Step1:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Step1 _this() 
  {
    return Step1Helper.narrow(
    super._this_object());
  }

  public Step1 _this(org.omg.CORBA.ORB orb) 
  {
    return Step1Helper.narrow(
    super._this_object(orb));
  }


} // class Step1POA

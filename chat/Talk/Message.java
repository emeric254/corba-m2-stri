package Talk;


/**
* Talk/Message.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* vendredi 4 novembre 2016 15 h 14 CET
*/

public final class Message implements org.omg.CORBA.portable.IDLEntity
{
  public String msg = null;
  public String author = null;

  public Message ()
  {
  } // ctor

  public Message (String _msg, String _author)
  {
    msg = _msg;
    author = _author;
  } // ctor

} // class Message

package Talk;

/**
* Talk/MessageHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* vendredi 4 novembre 2016 15 h 14 CET
*/

public final class MessageHolder implements org.omg.CORBA.portable.Streamable
{
  public Talk.Message value = null;

  public MessageHolder ()
  {
  }

  public MessageHolder (Talk.Message initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Talk.MessageHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Talk.MessageHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Talk.MessageHelper.type ();
  }

}

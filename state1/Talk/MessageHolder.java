package Talk;

/**
* Talk/MessageHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* mercredi 26 octobre 2016 14 h 34 CEST
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

package Talk;

/**
* Talk/genericErrorHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* vendredi 28 octobre 2016 19 h 50 CEST
*/

public final class genericErrorHolder implements org.omg.CORBA.portable.Streamable
{
  public Talk.genericError value = null;

  public genericErrorHolder ()
  {
  }

  public genericErrorHolder (Talk.genericError initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Talk.genericErrorHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Talk.genericErrorHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Talk.genericErrorHelper.type ();
  }

}

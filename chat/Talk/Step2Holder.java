package Talk;

/**
* Talk/Step2Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* jeudi 3 novembre 2016 17 h 12 CET
*/

public final class Step2Holder implements org.omg.CORBA.portable.Streamable
{
  public Talk.Step2 value = null;

  public Step2Holder ()
  {
  }

  public Step2Holder (Talk.Step2 initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Talk.Step2Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Talk.Step2Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Talk.Step2Helper.type ();
  }

}
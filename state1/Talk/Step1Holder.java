package Talk;

/**
* Talk/Step1Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Contract.idl
* mercredi 26 octobre 2016 14 h 34 CEST
*/

public final class Step1Holder implements org.omg.CORBA.portable.Streamable
{
  public Talk.Step1 value = null;

  public Step1Holder ()
  {
  }

  public Step1Holder (Talk.Step1 initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Talk.Step1Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Talk.Step1Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Talk.Step1Helper.type ();
  }

}
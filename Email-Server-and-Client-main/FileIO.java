import java.io.*;
public class FileIO
{
    public static int openMessagesFile (String fileName)
    {
	try
	{
	    Globals.msg = new RandomAccessFile (fileName, "rw");
	    Globals.totalRecordsInMessageFile = (int) Globals.msg.length () / Globals.RECORD_LEN;
	}
	catch (IOException e)
	{
	    return Globals.PROCESS_ERROR;
	}
	return Globals.PROCESS_OK;
    }


    public static int closeMessagesFile ()
    {
	try
	{
	    Globals.msg.close ();
	}
	catch (IOException e)
	{
	    return Globals.PROCESS_ERROR;
	}
	return Globals.PROCESS_OK;
    }


    public static int saveAvailableList (String fileName)
    {
	try
	{
	    RandomAccessFile f = new RandomAccessFile (fileName, "rw");
	    f.setLength(0);
	    for (Available p = Globals.availableList.getHead () ; p != null ; p = p.getNext ())
	    {
		f.writeInt (p.getRecordNumber ());
	    }
	    f.close();
	}
	catch (IOException e)
	{
	    return Globals.PROCESS_ERROR;
	}
	return Globals.PROCESS_OK;
    }


    public static int retrieveAvailableList (String fileName)
    {
	try
	{
	    RandomAccessFile f = new RandomAccessFile (fileName, "r");
	    int recordNumber = -1;
	    long totalNodes = f.length()/Globals.INT_LEN;
	    Globals.availableList = new AvailableList ();
	    for (int i = 1; i <= totalNodes; i++)
	    {
		recordNumber = f.readInt();
		Globals.availableList.addRecord(recordNumber);
	    }
	    f.close();
	}
	catch (IOException e)
	{
	    return Globals.PROCESS_ERROR;
	}
	return Globals.PROCESS_OK;
    }
}

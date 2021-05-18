
public class AvailableList
{
    private Available head = new Available ();
    private Available tail = new Available ();

    public AvailableList ()
    {
	head = null;
	tail = null;
    }


    public AvailableList (Available h, Available t)
    {
	head = h;
	tail = t;
    }


    public Available getHead ()
    {
	return head;
    }


    public Available getTail ()
    {
	return tail;
    }


    public void setHead (Available p)
    {
	head = p;
    }


    public void setTail (Available p)
    {
	tail = p;
    }


    public void addRecord (int recordNumber)
    {
	Available p = new Available (recordNumber);

	if (head == null)
	{
	    head = p;
	    tail = p;
	}
	else
	{
	    tail.setNext (p);
	    tail = p;
	}
    }


    public int getNextRecord ()  // return the recordNUmber that we are goint to rewrite on
    {
	if (head == null)
	{
	    return Globals.EMPTY_AVAILABLE_LIST;
	}
	else
	{
	    tail = head == tail ? null:
	    tail;
	    int r = head.getRecordNumber ();
	    head = head.getNext ();
	    return r;
	}
    }


    public void buildFromMessageFile ()  // if this method is call then it is called with an empty list
    {
	Record record = new Record ();
	for (int r = 0 ; r < Globals.totalRecordsInMessageFile ; r++)
	{
	    record.readFromMessageFile (r);
	    if (record.getData ().charAt (0) == Globals.DELETED)
	    {
		addRecord (r);
	    }
	}
    }


    public String toString ()
    {
	if (head == null)
	{
	    return "[empty]";
	}
	else
	{
	    String s = "";
	    for (Available p = head ; p != null ; p = p.getNext ())
	    {
		s = s + "Node: "+ p.toString () + "\n";
	    }
	    return s;
	}
    } 
}



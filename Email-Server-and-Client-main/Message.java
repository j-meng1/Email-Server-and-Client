import java.util.Date;
public class Message
{
    private char command = Globals.CHR_NULL;
    private String sender = Globals.STR_NULL;
    private String receiver = Globals.STR_NULL;
    private String dateTime = Globals.STR_NULL;
    private char firstRecordMarker = Globals.CHR_NULL;
    private String subject = Globals.STR_NULL;
    private char eosMarker = Globals.CHR_NULL;
    private String text = Globals.STR_NULL;

    public Message ()
    {
	char command = Globals.CHR_NULL;
	String sender = Globals.STR_NULL;
	String receiver = Globals.STR_NULL;
	String dateTime = Globals.STR_NULL;
	char firstRecordMarker = Globals.CHR_NULL;
	String subject = Globals.STR_NULL;
	char eosMarker = Globals.CHR_NULL;
	String text = Globals.STR_NULL;
    }


    public Message (String s)
    {
	setMessage (s);
    }


    // setMessage() method breaks the string s into each of the fields
    // of a message (see slide 24 of Unit 2 case study server pdf)

    public void setMessage (String s)
    {
	command = s.charAt (Globals.COMMAND_POS);
	sender = s.substring (Globals.SENDER_POS, Globals.RECEIVER_POS);
	receiver = s.substring (Globals.RECEIVER_POS, Globals.DATE_TIME_POS);
	dateTime = s.substring (Globals.DATE_TIME_POS, Globals.DATE_TIME_POS + Globals.DATE_TIME_LEN);
	firstRecordMarker = s.charAt (Globals.FIRST_RECORD_MARKER_POS);

	// for subject and text an overloaded version of indexof() is used
	// because we need to skip the dateTime field when searching
	// for the END_OF_SUBJECT_MARKER in the string s

	subject = s.substring (Globals.FIRST_RECORD_MARKER_POS + 1, s.indexOf (Globals.END_OF_SUBJECT_MARKER, Globals.FIRST_RECORD_MARKER_POS + 1));
	eosMarker = Globals.END_OF_SUBJECT_MARKER;
	text = s.substring (s.indexOf (Globals.END_OF_SUBJECT_MARKER, Globals.FIRST_RECORD_MARKER_POS + 1) + 1);
    }


    public String getMessage ()
    {
	return command + sender + receiver + dateTime + firstRecordMarker + subject + eosMarker + text;
    }


    public String getText ()
    {
	return text;
    }


    public String getIdSenderFirst ()
    {
	return sender + receiver + dateTime;
    }


    public String getIdReceiverFirst ()
    {
	return receiver + sender + dateTime;
    }


    public void readFromMessagesFile (int recordNumber)
    {
	String data = Globals.STR_NULL;
	Record record = new Record ();

	do
	{
	    record.readFromMessageFile (recordNumber);
	    data = data + record.getData ();
	    recordNumber = record.getNext ();

	}
	while (recordNumber != Globals.END_OF_MESSAGE);

	setMessage (data);
    }



    public int writeToMessagesFile ()
    {
	String s = getMessage ();
	int recordNumber = -1;
	int nextRecordNumber = -1;
	int startRecordNumber = Globals.availableList == null ? Globals.totalRecordsInMessageFile:
	Globals.availableList.getHead ().getRecordNumber ();


	Record record = null;

	while (s.length () > 0)
	{
	    if (Globals.availableList == null)
	    {
		recordNumber = Globals.totalRecordsInMessageFile;

		if (s.length () <= Globals.RECORD_DATA_LEN)
		{
		    record = new Record (s, Globals.END_OF_MESSAGE);
		    s = Globals.STR_NULL; // Forces to end loop
		}
		else
		{
		    record = new Record (s.substring (0, Globals.RECORD_DATA_LEN), recordNumber + 1);
		    s = s.substring (Globals.RECORD_DATA_LEN);
		}
		record.writeToMessageFile (recordNumber, Globals.APPEND);
	    }
	    else
	    {
		recordNumber = Globals.availableList.getNextRecord ();
		if (s.length () <= Globals.RECORD_DATA_LEN)
		{
		    record = new Record (s, Globals.END_OF_MESSAGE);
		    s = Globals.STR_NULL;
		}
		else
		{
		    nextRecordNumber = Globals.availableList.getHead () == null ? Globals.totalRecordsInMessageFile:
		    Globals.availableList.getHead ().getRecordNumber ();

		    record = new Record (s.substring (0, Globals.RECORD_DATA_LEN), nextRecordNumber);
		    s = s.substring (Globals.RECORD_DATA_LEN);

		}
		record.writeToMessageFile (recordNumber, Globals.MODIFY);
	    }
	}


	return startRecordNumber;

    }


    public void deleteFromMessageFile (int recordNumber)
    {
	Record record = new Record ();
	while (recordNumber != Globals.END_OF_MESSAGE)
	{
	    record.deleteFromMessagesFile (recordNumber);
	    recordNumber = record.getNext (); // information restored in record class
	}
    }



    public String toString ()
    {
	Date date = new Date (Utils.bytesStrToLong (dateTime));
	return "Command     : " + command + "\n" +
	    "Sender      : " + sender + "\n" +
	    "Receiver    : " + receiver + "\n" +
	    "Date/Time   : " + date.toString () + "\n" +
	    "FR Marker   : " + firstRecordMarker + "\n" +
	    "Subject     : " + subject + "\n" +
	    "EOS Marker  : " + eosMarker + "\n" +
	    "Message text: " + text + "\n";

    }





















}



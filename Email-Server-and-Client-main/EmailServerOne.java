import java.io.*;
public class EmailServerOne
{
    public static void main (String[] args)
    {
	// int errorCode = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	//
	// if (errorCode == Globals.PROCESS_OK)
	// {
	//     String record = "12345678901234567890123456789012345678901234567890123456789012345678901234567890";
	//
	//     for (int i = 0 ; i < 500 ; i++)
	//     {
	//         try
	//         {
	//             Globals.msg.writeBytes (record);
	//             Globals.msg.writeInt (-1);
	//         }
	//         catch (IOException e)
	//         {
	//         }
	//     }
	//
	//     errorCode = FileIO.closeMessagesFile ();
	//
	//     if (errorCode == Globals.PROCESS_OK)
	//     {
	//         errorCode = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	//
	//         if (errorCode == Globals.PROCESS_OK)
	//         {
	//             System.out.println (Globals.totalRecordsInMessageFile);
	//             errorCode = FileIO.closeMessagesFile ();
	//         }
	//         else
	//         {
	//             System.out.println ("Unable to reopen _messages.dat file");
	//         }
	//     }
	//     else
	//     {
	//         System.out.println ("Unable to close _messages.dat file");
	//     }
	// }
	// else
	// {
	//     System.out.println ("Uable to open _message.dat file");
	//
	// }


	// int errorCode = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	// if (errorCode == Globals.PROCESS_OK)
	// {
	//     /*Record record = new Record ("Today is Wednesday", 76);
	//     record.writeToMessageFile (0, Globals.APPEND);
	//
	//     record.setData ("Today is Tednesday", 77);
	//     record.writeToMessageFile (1, Globals.APPEND);
	//
	//     record.setData ("Today is Fednesday", 78);
	//     record.writeToMessageFile (2, Globals.APPEND);
	//
	//     record.setData ("Today is Sednesday", 79);
	//     record.writeToMessageFile (3, Globals.APPEND);
	//
	//     record.setData ("Today is Sunday", 80);
	//     record.writeToMessageFile (4, Globals.APPEND);*/
	//
	//     // Record record = new Record();
	//     //
	//     // for (int i = 4 ; i >= 0 ; i--)
	//     // {
	//     //     record.readFromMessageFile (i);
	//     //     System.out.println(record);
	//     // }
	//     //
	//     // // record.readFromMessageFile (0);
	//     // // System.out.println(record);
	//     // FileIO.closeMessagesFile ();
	//
	//
	// }
	// else
	// {
	//     System.out.println ("hi");
	// }

	//     int errorCode = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	//     if (errorCode == Globals.PROCESS_OK)
	//     {
	//         String s = "SBillGatesSteveJobs^&#@45!!+Hey" + Globals.END_OF_SUBJECT_MARKER +
	//             "Hey Steve, are you still making money with the Apple MacIntosh?";
	//
	//         int recordNumber = Globals.totalRecordsInMessageFile;
	//
	//         Message message = new Message (s);
	//
	//         message.writeToMessagesFile ();
	//
	//         message = new Message ();
	//
	//         message.readFromMessagesFile (recordNumber);
	//         System.out.println (message);
	//
	//         FileIO.closeMessagesFile ();
	//     }
	//     else
	//     {
	//         System.out.println ("Unable to open the file");
	//     }
	//
	// }

	// Globals.availableList = new AvailableList ();
	// Message message = new Message();
	//
	// int error = FileIO.openMessagesFile(Globals.MESSAGES_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     message.deleteFromMessageFile(1);
	//     message.deleteFromMessageFile(0);
	//     System.out.println (Globals.availableList);
	// }
	// else
	// {
	//     System.out.println ("error opening _messages.dat");
	// }



	// Globals.availableList = new AvailableList ();
	// int errorCode = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	// if (errorCode == Globals.PROCESS_OK)
	// {
	//     Globals.availableList.buildFromMessageFile();
	//     System.out.println(Globals.availableList);
	//     String s = "S012345678ABCDEFGHI00000000+Tracing exercise" + (char)30 + "This message is going to help us see what will happen when the system tries to write all this text in the messages file. There are some spots available so the file will not grow at all.";
	//     Message message = new Message(s);
	//     int startRecordNumber = message.writeToMessagesFile();
	//     System.out.println(Globals.availableList);
	//     message = new Message();//eliminate al the info we have before in the previous message
	//     message.readFromMessagesFile(startRecordNumber);
	//     System.out.println(message);
	//
	// }
	// else
	// {
	//     System.out.println ("Unable to open messages file");
	// }

	// Globals.availableList = new AvailableList ();
	// System.out.println (Globals.availableList);
	// Globals.availableList.addRecord (10);
	// Globals.availableList.addRecord (6);
	// Globals.availableList.addRecord (12);
	// Globals.availableList.addRecord (239);
	// System.out.println (Globals.availableList);
	//
	// int error = FileIO.saveAvailableList (Globals.AVAILABLE_LIST_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     Globals.availableList = new AvailableList ();
	//     System.out.println (Globals.availableList);
	//     error = FileIO.retrieveAvailableList (Globals.AVAILABLE_LIST_FILE);
	//     if (error == Globals.PROCESS_OK)
	//     {
	//         System.out.println(Globals.availableList);
	//     }
	//     else
	//     {
	//         System.out.println("Error retrieving Globals.availableList");
	//     }
	// }
	// else
	// {
	//     System.out.println("Error saving Globals.availableList");
	// }
	//
	// Globals.availableList = new AvailableList ();
	// Globals.availableList.addRecord (200);
	// System.out.println(Globals.availableList);
	// error = FileIO.saveAvailableList (Globals.AVAILABLE_LIST_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     Globals.availableList = new AvailableList ();
	//     System.out.println (Globals.availableList);
	//     error = FileIO.retrieveAvailableList (Globals.AVAILABLE_LIST_FILE);
	//     if (error == Globals.PROCESS_OK)
	//     {
	//         System.out.println(Globals.availableList);
	//     }
	//     else
	//     {
	//         System.out.println("Error retrieving Globals.availableList");
	//     }
	// }
	// else
	// {
	//     System.out.println("Error saving Globals.availableList");
	// }

	// Globals.availableList = new AvailableList ();
	// System.out.println (Globals.availableList);
	// Globals.availableList.addRecord (10);
	// Globals.availableList.addRecord (11);
	// Globals.availableList.addRecord (12);
	// Globals.availableList.addRecord (13);
	// Globals.availableList.addRecord (14);
	// Globals.availableList.addRecord (15);
	// Globals.availableList.addRecord (16);
	// Globals.availableList.addRecord (17);
	// Globals.availableList.addRecord (18);
	// Globals.availableList.addRecord (19);
	// Globals.availableList.addRecord (20);
	// System.out.println (Globals.availableList);
	// Globals.availableList.getHead().setNext (null);
	// System.out.println (Globals.availableList);
	// System.out.println (Globals.availableList.getTail());



    }
}

public class Testing
{
    public static void main (String[] args)
    {
	// AvailableList list = new AvailableList();
	// list.addRecord(87);
	// list.addRecord(55);
	// list.addRecord(23);
	// list.addRecord(12);
	// System.out.println(list);


	// AvailableList list = new AvailableList ();
	// list.addRecord (12); // adds node with recordNumber 12
	// list.addRecord (6); // adds node with recordNumber 6
	// list.addRecord (18); // adds node with recordNumber 18
	// System.out.println (list);
	// System.out.println ();
	// int r = list.getNextRecord ();
	// System.out.println (r);
	// System.out.println (list);
	// System.out.println ();
	// r = list.getNextRecord ();
	// System.out.println (r);
	// System.out.println (list);
	// System.out.println ();
	// r = list.getNextRecord ();
	// System.out.println (r);
	// System.out.println (list);
	// System.out.println ();
	// r = list.getNextRecord ();
	// System.out.println (r);
	// System.out.println (list);

	// TreeNode p = new TreeNode ("ABC", 99, null, null, null);
	// TreeNode q = new TreeNode ("DEF", 20, null, null, null);
	// p.setRight(q);
	// q.setParent(p);
	// System.out.println(p.getRight());
	// System.out.println(q.getParent());


	// Tree t = new Tree();
	// TreeNode p = new TreeNode();
	//
	// p = new TreeNode("andrew_pgsuperhero9&*029H^", 351, null, null, null);
	// t.insertNode(p);
	// p = new TreeNode("00000john00elisaGSa*&0-7j2", 176, null, null, null);
	// t.insertNode(p);
	// p = new TreeNode("0theFlash00penguin--+=4gnb", 14, null, null, null);
	// t.insertNode(p);
	//
	// t.printTree();



	// Tree t = new Tree ();
	// TreeNode p = new TreeNode ("065", 134, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("028", 78, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("108", 1928, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("040", 14, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("078", 785, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("140", 32, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("131", 147, null, null, null);
	// t.insertNode (p);
	// t.printTree ();


	// Tree t = new Tree ();
	// TreeNode p = new TreeNode ("065", 134, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("028", 78, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("108", 1928, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("040", 14, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("078", 785, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("140", 32, null, null, null);
	// t.insertNode (p);
	// p = new TreeNode ("131", 147, null, null, null);
	// t.insertNode (p);
	// t.printTree (0);



	// int error = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     Globals.senderIndex.buildFromMessagesFile ();
	//     Globals.receiverIndex.buildFromMessagesFile ();
	//
	//     System.out.println ("SENDER INDEX");
	//     Globals.senderIndex.printTree (0);
	//
	//     System.out.println ("RECEIVER INDEX");
	//     Globals.receiverIndex.printTree (0);
	//
	//
	//     FileIO.closeMessagesFile ();
	// }
	// else
	// {
	//     System.out.println ("Unable to open _message.dat");
	// }


	// int error = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     Globals.senderIndex = new Tree ();
	//     Globals.senderIndex.buildFromMessagesFile ();
	//     String id = "manager  susan.pat" +
	//         (char) 0 + (char) 0 + (char) 1 + (char) 110 + (char) 3 + (char) 193 + (char) 103 + (char) 123;
	//     TreeNode p = Globals.senderIndex.findNode (id);
	//     System.out.println (p);
	//     if (p != null)
	//     {
	//         System.out.println ("Node with identification: " + id + " found");
	//         int recordNumber = p.getRecordNumber ();
	//         Message message = new Message ();
	//         message.readFromMessagesFile (recordNumber);
	//         System.out.println (message);
	//     }
	//     else
	//     {
	//         System.out.println ("***Cannot find node with identification " + id);
	//     }
	// }
	// else
	// {
	//     System.out.println ("unable to open _messages.dat");
	// }



	// Tree tree = new Tree ();
	// TreeNode p = new TreeNode ();
	// for (int i = 0 ; i < 200 ; i++)
	// {
	//     p = new TreeNode ("" + (char) (200 - i), i, null, null, null);
	//     tree.insertNode (p);
	// }
	// String id = "" + (char) (200 - 150);
	// System.out.println (tree.findNode (id));


	// int error = FileIO.openMessagesFile (Globals.MESSAGES_FILE);
	// if (error == Globals.PROCESS_OK)
	// {
	//     // System.out.println (Globals.totalRecordsInMessageFile);
	//     // Record record = new Record ();
	//     // for (int i = 0 ; i < Globals.totalRecordsInMessageFile ; i++)
	//     // {
	//     //     record.readFromMessageFile (i);
	//     //     if (i % 2 == 1)
	//     //     {
	//     //         record.setData (record.getData (), -1);
	//     //     }
	//     //     else
	//     //     {
	//     //         record.setData (record.getData (), i + 1);
	//     //     }
	//     // }
	//     //
	//     // System.out.println (record);
	//     // System.out.printlnrecord.getNext ();
	//     // record.writeToMessageFile (i, Globals.MODIFY);
	//     // System.out.println (record.getData ().charAt (Globals.FIRST_RECORD_MARKER_POS));
	//
	//
	//
	//
	//     Globals.senderIndex = new Tree ();
	//     Globals.senderIndex.buildFromMessagesFile ();
	//     //Globals.senderIndex.printTree (0);
	//
	//
	//
	//     String s = "jax";
	//     TreeNode p = Globals.senderIndex.findNode (s, Globals.LOWEST);
	//     System.out.println (p);
	//     TreeNode q = Globals.senderIndex.findNode (s, Globals.HIGHEST);
	//     System.out.println (q);
	//
	//     if (p != null)
	//     {
	//         if (q != null)
	//         {
	//             int recordNumber = p.getRecordNumber ();
	//             Message message = new Message ();
	//             message.readFromMessagesFile (recordNumber);
	//             System.out.println (message);
	//
	//             recordNumber = q.getRecordNumber ();
	//             message = new Message ();
	//             message.readFromMessagesFile (recordNumber);
	//             System.out.println (message);
	//
	//             System.out.println ();
	//             Globals.senderIndex.printTree (p, q);
	//         }
	//         else
	//         {
	//             System.out.println (" * * * Cannot find in senderIndex the highest alphabetical node that starts with 111 ");
	//         }
	//     }
	//     else
	//     {
	//         System.out.println ("* * * Cannot find in senderIndex the lowest alphabetical node that starts with 111");
	//     }
	// }
	// else
	// {
	//     System.out.println ("unable to open _messages.dat");
	//
	// }

	Tree t = new Tree ();
	TreeNode p = new TreeNode ("11111111122222222200000003", 0, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111111111111100000003", 1, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111133333333300000003", 2, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111111111111100000000", 3, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111111111111100000005", 4, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111133333333300000000", 5, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111144444444400000003", 6, null, null, null);
	t.insertNode (p);
	p = new TreeNode ("11111111111111111100000009", 7, null, null, null);
	t.insertNode (p);
	t.printTree (0);

	System.out.println ("");
	TreeNode n = new TreeNode ("11111111111111111100000005", 4, null, null, null);
	t.deleteNode (n);
	t.printTree (0);






    }
}



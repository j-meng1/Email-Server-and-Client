public class Tree
{
    private TreeNode root = null;

    public Tree ()
    {
	root = null;
    }


    public Tree (TreeNode r)
    {
	root = r;
    }


    public TreeNode getRoot ()
    {
	return root;
    }


    public void setRoot (TreeNode r)
    {
	root = r;
    }


    public void insertNode (TreeNode p)
    {
	if (root == null)
	{
	    root = p;
	}
	else if (p.getId ().compareTo (root.getId ()) < 0)
	{
	    if (root.getLeft () == null)
	    {
		root.setLeft (p);
		p.setParent (root);
	    }
	    else
	    {
		Tree t = new Tree (root.getLeft ());
		t.insertNode (p);
	    }
	}
	else if (p.getId ().compareTo (root.getId ()) > 0)
	{
	    if (root.getRight () == null)
	    {
		root.setRight (p);
		p.setParent (root);
	    }
	    else
	    {
		Tree t = new Tree (root.getRight ());
		t.insertNode (p);
	    }
	}
	else
	{
	    System.out.println ("Error: attempting to insert an identification that already exists in tree");
	}
    }


    public void printTree ()
    {
	if (root != null)
	{
	    Tree t = new Tree (root.getLeft ());
	    t.printTree ();

	    System.out.println (root);

	    t = new Tree (root.getRight ());
	    t.printTree ();
	}
    }


    public void printTree (int level)
    {
	if (root != null)
	{
	    Tree t = new Tree (root.getLeft ());
	    t.printTree (level + 1);

	    System.out.print (root);
	    System.out.println ("     level: " + level);

	    t = new Tree (root.getRight ());
	    t.printTree (level + 1);
	}
    }


    public void buildFromMessagesFile ()
    {
	int recordNumber = 0;
	Record record = new Record ();
	for (recordNumber = 0 ; recordNumber < Globals.totalRecordsInMessageFile ; recordNumber++)
	{
	    record.readFromMessageFile (recordNumber);
	    //System.out.println ("outside" + "\t" + recordNumber);
	    if ((record.getData ().charAt (0) != Globals.DELETED) &&
		    (record.getData ().charAt (Globals.FIRST_RECORD_MARKER_POS) == Globals.FIRST_RECORD_MARKER))
	    {
		String key = this == Globals.senderIndex ? record.getIdSenderFirst ():
		record.getIdReceiverFirst ();
		TreeNode p = new TreeNode (key, recordNumber, null, null, null);
		insertNode (p);
		//System.out.println ("inside" + "\t" + recordNumber);
	    }
	}
    }


    public TreeNode findNode (String id)
    {
	if (root == null)
	{
	    return null;
	}
	else if (id.equals (root.getId ()))
	{
	    return root;
	}
	else if (id.compareTo (root.getId ()) < 0)
	{
	    Tree tree = new Tree (root.getLeft ());
	    return tree.findNode (id);
	}
	else if (id.compareTo (root.getId ()) > 0)
	{
	    Tree tree = new Tree (root.getRight ());
	    return tree.findNode (id);
	}
	else
	{
	    System.out.println ("Fatal error in findNode(String)");
	    return null;
	}
    }


    public TreeNode findNode (String partialKey, int where)
    {
	if (partialKey.length () == Globals.KEY_LEN)
	{
	    return findNode (partialKey);
	}
	else if (root == null)
	{
	    return null;
	}
	else
	{
	    int n = partialKey.length ();
	    if (partialKey.compareTo (root.getId ().substring (0, n)) < 0)
	    {
		Tree tree = new Tree (root.getLeft ());
		return tree.findNode (partialKey, where);
	    }
	    else if (partialKey.compareTo (root.getId ().substring (0, n)) > 0)
	    {
		Tree tree = new Tree (root.getRight ());
		return tree.findNode (partialKey, where);
	    }
	    else
	    {
		// a node has been found whose identification starts with partialKey; now we need to find the node whose identification
		// starts with partialKey and is the smallest or the largest (depending on the value of where)
		TreeNode p = root;

		if (where == Globals.HIGHEST)
		{
		    TreeNode q = p.getRight ();

		    while (q != null)
		    {
			if ((q.getId ().substring (0, n).compareTo (partialKey) == 0))
			{
			    p = q;
			    q = p.getRight ();
			}
			else
			{
			    q = q.getLeft ();
			}
		    }
		}
		else
		{ // we move down the left subtree to find the smallest key that contains partialKey
		    TreeNode q = p.getLeft ();

		    while (q != null)
		    {
			if ((q.getId ().substring (0, n).compareTo (partialKey) == 0))
			{
			    p = q;
			    q = p.getLeft ();
			}

			else
			{
			    q = q.getRight ();
			}
		    }
		}
		return p;
	    }
	}
    }



    public void printTree (TreeNode start, TreeNode end)
    {
	if (start != null && end != null)
	{
	    if (start.getId ().compareTo (end.getId ()) <= 0)
	    {
		if (start.getId ().compareTo (root.getId ()) <= 0 && root.getId ().compareTo (end.getId ()) <= 0)
		{
		    TreeNode p = start;
		    while (p != null && p != root)
		    { // work on left side of the root
			System.out.println (p);
			Tree rTree = new Tree (p.getRight ());
			rTree.printTree ();
			do
			{
			    p = p.getParent ();
			}
			while (p != null && p.getId ().compareTo (start.getId ()) < 0); //move up to ancestor within range
		    }
		    System.out.println (root); // print the root
		    p = root.getRight (); // work on the right side of the root
		    while (p != null)
		    {
			if (p.getId ().compareTo (end.getId ()) <= 0)
			{
			    Tree lTree = new Tree (p.getLeft ());
			    lTree.printTree ();
			    System.out.println (p);
			    p = p.getRight ();
			}
			else
			{
			    p = p.getLeft ();
			}
		    }
		}
		else if (end.getId ().compareTo (root.getId ()) < 0)
		{ // start and end are in left subtree
		    Tree lTree = new Tree (root.getLeft ());
		    lTree.printTree (start, end);
		}
		else if (start.getId ().compareTo (root.getId ()) > 0)
		{ // start and end are in right subtree
		    Tree rTree = new Tree (root.getRight ());
		    rTree.printTree (start, end);
		}
	    }
	}
    }




    private void setParentsChildLink (TreeNode p, TreeNode q)
    {
	if (p.getId ().compareTo (p.getParent ().getId ()) < 0)
	    p.getParent ().setLeft (q);
	else if (p.getId ().compareTo (p.getParent ().getId ()) > 0)
	    p.getParent ().setRight (q);
	else
	    System.out.println ("error in deleting root setting a parents child link");
    }




    public void deleteNode (TreeNode p)
    {
	if (p != null)
	{
	    TreeNode q = null;
	    TreeNode r = null;
	    if (p.getLeft () == null && p.getRight () == null)
	    { // case 1: p is leaf
		r = p.getParent (); // there is no node shift
		if (p == root && p.getParent () == null)
		    root = null;                                         // link that points to p
		else
		    setParentsChildLink (p, null);     // becomes null
	    }
	    else if (p.getLeft () != null && p.getRight () == null ||  // cases 2: p has a left subtree
		    p.getLeft () == null && p.getRight () != null)
	    { // cases 3: p has a right subtree
		q = (p.getLeft () != null) ? p.getLeft ():
		p.getRight ();                                          // determine which side p is in
		if (p == root)
		    root = q;                // q becomes the child of p's parent
		else
		    setParentsChildLink (p, q);
		q.setParent (p.getParent ()); // p's parent becomes q's parent
		r = q.getParent (); // there has been node shift
	    }
	    else if (p.getLeft () != null && p.getRight () != null)
	    { // cases 4, 5: p has two subtrees; p's left child has no right child
		q = p.getLeft ();
		if (p.getLeft ().getRight () == null)
		{ // cases 4, 5a
		    if (p == root)
			root = q;                // q becomes the child of p's parent
		    else
			setParentsChildLink (p, q);
		    q.setParent (p.getParent ()); // p's parent becomes q's parent
		    q.setRight (p.getRight ()); // q's right subtree becomes p's right subtree
		    q.getRight ().setParent (q); // q becomes p's right child's parent
		    r = q; // there has been a node shift
		}
		else
		{ // cases 5b, 5c
		    while (q.getRight () != null)
			q = q.getRight ();                             // find right most node of left subtree of p
		    r = q.getParent (); // there has been a node shift
		    q.getParent ().setRight (q.getLeft ()); // move the left subtree of q up one level
		    if (q.getLeft () != null)
			q.getLeft ().setParent (q.getParent ());
		    if (p == root)
			root = q;                // q becomes the child of p's parent
		    else
			setParentsChildLink (p, q);     // setParentsChildLink(p, q) but q is always a right child
		    q.setParent (p.getParent ()); // p's parent becomes q's parent
		    q.setLeft (p.getLeft ()); // p's left child becomes q's left child
		    p.getLeft ().setParent (q); // q becomes the parent of p's left child
		    q.setRight (p.getRight ()); // p's right child becomes q's right child
		    p.getRight ().setParent (q); // q becomes the parent of p's right child
		}
	    }
	    // These four statement need to be uncommented once the height and balance methods have been implemented
	    // Tree tree = new Tree(r);
	    // tree.updateTreeHeightsOfThisAndBelow();
	    // updateTreeHeightsAbove(r);
	    // balance(r);
	    p.setLeft (null);
	    p.setRight (null);
	    //p.setParent (null);
	    p = null;
	}
    }


    public String toString ()
    {
	if (root == null)
	{
	    return "Null root";
	}
	else
	{
	    return "Id: " + root.getId () + " Record number: " + root.getRecordNumber ();
	}
    }
}

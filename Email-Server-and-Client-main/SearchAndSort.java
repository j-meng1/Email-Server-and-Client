public class SearchAndSort
{
    public static void selectionSort (String list[], int startByte, boolean ascending)
    {

	for (int i = list.length - 1 ; i >= 1 ; i--)
	{

	    swapStrings (list, indexOfLargest (list, i, startByte, ascending), i);
	}
    }


    public static void bubbleSort (String toSort[])
    {
	for (int limit = toSort.length - 1 ; limit >= 1 ; limit--)
	{
	    for (int i = 0 ; i < limit ; i++)
	    {
		if (toSort [i].compareTo (toSort [i + 1]) > 0)
		{
		    swapStrings (toSort, i, i + 1);
		}
	    }

	}
    }


    public static void swapStrings (String[] list, int i, int j)
    {
	String temp = list [i];
	list [i] = list [j];
	list [j] = temp;
    }


    public static int indexOfLargest (String[] list, int end, int positionOfKey, boolean ascending)
    {
	int positionOfLargest = 0;
	for (int i = 0 ; i <= end ; i++)
	{
	    if (ascending)
	    {
		positionOfLargest = (list [i].substring (positionOfKey).compareToIgnoreCase (list [positionOfLargest].substring (positionOfKey))) > 0 ? i:
		positionOfLargest;
	    }
	    else
	    {
		positionOfLargest = (list [i].substring (positionOfKey).compareToIgnoreCase (list [positionOfLargest].substring (positionOfKey))) < 0 ? i:
		positionOfLargest;

	    }
	}
	return positionOfLargest;
    }



    public static void insertionSort (int[] list)
    {
	for (int i = 1 ; i < list.length ; i++)
	{
	    boolean largerFound = false;
	    int j = 0;
	    for (j = 0 ; j < i && !largerFound ; j++)
	    {
		largerFound = list [i] < list [j] ? true:
		false;

	    }
	    if (largerFound)
	    {
		int temp = list [i];
		shiftArrayDownOnePosition (list, j - 1, i - 1);
		list [j - 1] = temp;
	    }
	}
    }


    private static void shiftArrayDownOnePosition (int[] list, int start, int end)
    {
	for (int i = end ; i >= start ; i--)
	{
	    list [i + 1] = list [i];



	}
    }


    public static int linearSearch (String list[], String key)
    {
	int i = 0;
	for (; i < list.length && !key.equals (list [i]) ; i++)
	    ;
	return i == list.length ? -1:
	i;

    }


    public static int binarySearch (String[] list, String key)
    {
	int start = 0;
	int end = list.length - 1;
	int idx = (start + end) / 2;

	while (list [idx].compareTo (key) != 0 && start <= end)
	{
	    if (list [idx].compareTo (key) < 0)
		start = idx + 1;
	    else
		end = idx - 1;

	    idx = (start + end) / 2;
	}
	if (start > end)
	    return -1;
	else
	    return idx;
    }
}

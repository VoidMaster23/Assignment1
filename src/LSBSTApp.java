/**
 * Class containing all the methods for data handling for the BST solution
 * @author Edson Shivuri
 **/
public class LSBSTApp{
	//BST to store scheduleItem nodes
	static BST<ScheduleItem> itemBST;

	//instrumentation
	private static int finCount;
	private static int insCount;

	/**
	 * Drives the program and calls all necessary funtions
	 * @param args string array to take in parameters to start the program with
	 **/
	public static void main(String[] args){
		ReadFile readFile = new ReadFile();
		readFile.read();
		itemBST = readFile.getItemsBST();
		System.out.println(itemBST.getSize());
	}

}


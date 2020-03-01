/**
 * Class containing all the methods for data handling for the standard array solution
 * @author Edson Shivuri
 **/
public class LSArrayApp{
 	//The array to store ScheduleItem objects
	ScheduleItem[] itemArr;



	/**
	 * Drives the program and calls all neccesarry functions 
	 * @param args string array to take in any parameters to start the program with
	 **/
	public static void main(String[] args){
		ReadFile readFile = new ReadFile();
		readFile.read();
		itemArr = readFile.getItemsArray();	
	
	}





}


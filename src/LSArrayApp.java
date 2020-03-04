/**
 * Class containing all the methods for data handling for the standard array solution
 * @author Edson Shivuri
 **/
public class LSArrayApp{
 	//The array to store ScheduleItem objects
	 static ScheduleItem[] itemArr;

	 //instrumentation
	 private static int finCount;



	/**
	 * Drives the program and calls all neccesarry functions 
	 * @param args string array to take in any parameters to start the program with
	 **/
	public static void main(String[] args){
		ReadFile readFile = new ReadFile();

		if(args.length == 4){
			readFile.read(args[3]);
		}else{
			readFile.read(null);
		}

		
		itemArr = readFile.getItemsArray().clone();
		

		if(args.length == 0){
			printAllAreas();
		}else if(args.length == 3 || args.length == 4 ){
			printAreas(args[0], args[1], args[2]);
		}else{
			System.out.println("Your input should be of the format xx yy zz ");
		}
	
	}

	/**Prints all loadshedding details
	 **/
	public static void printAllAreas(){
		for(int i = 0; i < itemArr.length; i++){
			System.out.println(itemArr[i].toString());
		}
	}



	/**
	 * Prints out the list of areas for the first matching combination of the supplied parameters that it is found or "Areas not found" if there is no match 
	 * @param stage stage of the loadshedding
	 * @param day day of the month the loadshedding will take place
	 * @param startTime starting hour of the loadshedding, e.g 8pm will be  20 
	 **/
	public static void printAreas(String stage, String day, String startTime){
		//build the key
		String toFind = CommonMethods.makeKey(stage, day, startTime);

		//find the item
		String result = find(toFind);

		//output
		System.out.println(CommonMethods.breakKey(toFind));
		System.out.println("Areas Affected: "+result);
		System.out.println("Number of operations for find: "+Integer.toString(finCount));
		System.out.println();
		

		//Experiment Code
		//System.out.print(finCount);
	}

	/**
	 * Finds the ScheduleItem object with a matching key
	 * @param key this is the ScheduleItem to look for 
	 * @return the list of areas for the first matching combination of the supplied key or a not found message
	 **/
	private static String find(String key){
		finCount = 0;
		for(int i = 0; i < itemArr.length; i++){
			//equality check

			finCount++;
			if(itemArr[i].getKey().equals(key)){
				return itemArr[i].getAreasAffected();
			}
		}

		return "Areas not Found";
	}





}


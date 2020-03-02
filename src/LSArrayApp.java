/**
 * Class containing all the methods for data handling for the standard array solution
 * @author Edson Shivuri
 **/
public class LSArrayApp{
 	//The array to store ScheduleItem objects
	 static ScheduleItem[] itemArr;



	/**
	 * Drives the program and calls all neccesarry functions 
	 * @param args string array to take in any parameters to start the program with
	 **/
	public static void main(String[] args){
		ReadFile readFile = new ReadFile();
		readFile.read();
		itemArr = readFile.getItemsArray().clone();
		

		if(args.length == 0){
			printAllAreas();
		}else if(args.length == 3){
			printAreas(args[0], args[1], args[2]);
		}else{
			System.out.println("Your input should be of the format xx yy zz ");
		}
	
	}

	/**Prints all loadshedding details
	 **/
	public static void printAllAreas(){
		for(int i = 0; i < itemArr.length; i++){
			String info = breakKey(itemArr[i].getKey());
			String areas = "Areas Affected: "+itemArr[i].getAreasAffected();
			System.out.println(info);
			System.out.println(areas);
			System.out.println();
		}
	}

	/**
	 * Splits a key into its stage, day and start time formatted for output
	 * @param key the key to be split up 
	 * @return the split up key in the format "Stage: x, Day: y, Start Time: z:00"
	 **/
	public static String breakKey(String key){
		String[] info = key.split("_");
		return "Stage: "+info[0]+", Day: "+info[1]+", Start Time: "+info[2]+":00";

	}



	/**
	 * Prints out the list of areas for the first matching combination of the supplied parameters that it is found or "Areas not found" if there is no match 
	 * @param stage stage of the loadshedding
	 * @param day day of the month the loadshedding will take place
	 * @param startTime starting hour of the loadshedding, e.g 8pm will be  20 
	 **/
	public static void printAreas(String stage, String day, String startTime){
		//build the key
		String toFind = makeKey(stage, day, startTime);

		//find the item
		String result = find(toFind);

		//output
		System.out.println(breakKey(toFind));
		System.out.println("Areas Affected: "+result);

	}


	/**
	 *Generates a key that can be used to search the array
	 *@param stage stage of the loadshedding
         *@param day day of the month the loadshedding will take place
         *@param startTime starting hour of the loadshedding, e.g 8pm will be  20
	 *@return A key of type String that can be used to search the array
	 **/ 
	private static String makeKey(String stage, String day, String startTime){
		return stage+"_"+day+"_"+startTime;
	}

	/**
	 * Finds the ScheduleItem object with a matching key
	 * @param key this is the ScheduleItem to look for 
	 * @return the list of areas for the first matching combination of the supplied key or a not found message
	 **/
	private static String find(String key){
		boolean found = false;
		for(int i = 0; i < itemArr.length; i++){
			//equality check
			if(itemArr[i].getKey().equals(key)){
				return itemArr[i].getAreasAffected();
			}
		}

		return "Areas not Found";
	}





}


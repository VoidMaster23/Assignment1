//import statement
import java.io.*;
import java.util.Scanner;




/** 
 * Reusable class to handle file reading in both the BSTApp and the Array app
 * @author Edson Shivuri
 **/
public class ReadFile{
	//boolean to store the whether or not the array app called 
	private  boolean fromArr;

	//Array that will be used in the Array app
	private ScheduleItem[] itemArr;
	private  int numElements;

	
	/**
	 *Constructor for a ReadFile object that instantiates the instance vatiables and determines which which add method to use
	 **/
	public ReadFile(){
		itemArr = new ScheduleItem[2976];
		numElements = 0;	
		
		//determine which class called the read
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if(stackTraceElements[2].getClassName().equals("LSArrayApp")){
                          fromArr = true; 
                  }else{  
                          fromArr = false;
                  }

	

	}


	/**
	 * Reads data from the file
	 **/
	public void read(){

	try{
		File toRead = new File("../res/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt");// allows the program to work with this
	
		//declare the scanner
		Scanner scanner  = new Scanner(toRead);
		
		//iterate through the file to be read
		while(scanner.hasNextLine() && numElements < 2976){
			String[] line = scanner.nextLine().split(" ", 2);//takes in the line and splits into a key and then items
			String key = line[0];
			String areas = line[1];

			//create object
			ScheduleItem item = new ScheduleItem(key, areas);

			//add the object to the appropriate DS
			if(fromArr){
				arrAdd(item);
				numElements++;	
			}

		}//while
	}catch(Exception e){
			System.out.println("Error: File Not Found in Directory");
			System.exit(0);	
		}

	}//read method	

	
	
	/**
	 * Adds scheduleItem objects to the array
	 *
	 **/
	private void arrAdd(ScheduleItem item){
		itemArr[numElements] = item;
		
	}


	/**
	 * returns the array to be used by the LSArrayApp
	 * @return Array of ScheduleItem objects
	 **/
	public ScheduleItem[] getItemsArray(){
		ScheduleItem[] myItems = itemArr.clone();
		return myItems;
	}




}

//Derek Hartford
//Java Programming for Beginners
//11-01-2015
//Instructor: Bineet Sharma

/**This program is a simple calculator and is written without Object Oriented Programming. It will 
 * display a menu and check to make sure the user enters a valid input between 1 and 5 by calling 
 * the getUserChoice function. getUserChoice will also return the correct input. The returned value
 * will then be used in a switch statement to determine which calculation to perform. In all cases
 * the program will call the getTwoFloats function to ask the user to input two numbers, which will 
 * accept only integers or decimal numbers. Then, depending on what the user choose do to as a 
 * calculation, the program will call either the add function, sub function, mul function, or div 
 * function. The result of the calculation will be out-putted to the console. Finally, the user will 
 * be prompted to press enter to continue via a call to the pressEnter function. The whole process 
 * is then repeated until the user enters '5' to exit the program.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput = new Scanner(System.in);
		
		int myChoice;
		float[] myNums = new float[2];
		
		//show menu and get user input
		myChoice = getUserChoice(myInput);
		
		//loop until user enters '5' to exit
		while (myChoice != 5) {
			
			//use the users input to perform a calculation
			switch (myChoice) {
			
				case 1:
					System.out.print("Please enter two floats to add, separated by a space: ");
					getTwoFloats(myNums, myInput);
					add(myNums[0], myNums[1]);
					break; //exit switch
				case 2:
					System.out.print("Please enter two floats to subtract, separated by a space: ");
					getTwoFloats(myNums, myInput);
					sub(myNums[0], myNums[1]);
					break; //exit switch
				case 3:
					System.out.print("Please enter two floats to multiply, separated by a space: ");
					getTwoFloats(myNums, myInput);
					mul(myNums[0], myNums[1]);
					break; //exit switch
				case 4:
					System.out.print("Please enter two floats to divide, separated by a space: ");
					getTwoFloats(myNums, myInput);
					while (myNums[1] == 0) {
						System.out.print("You can't divide by zero, please re-enter both floats: ");
						getTwoFloats(myNums, myInput);
					} //end while
					div(myNums[0], myNums[1]);
					break; //exit switch
					
			} //end switch
			
			//prompt user to press enter to continue
			pressEnter(myInput);
			
			//show menu and get user input
			myChoice = getUserChoice(myInput);
		} //end while
		
		System.out.println("Thank you for using Derek Hartford's Handy Calculator");
	} // end main
	
	
	
	//////FUNCTION DEFINITIONS//////
	
	//Show menu, get user input, make sure only an integer between 1 and 5 is entered, return input
	public static int getUserChoice(Scanner userInput) {
		
		int choice;
		
		System.out.println("Welcome to Derek Hartford's Handy Calculator\n\n\t1."
				+ " Addition\n\t2. Subtraction\n\t3. Multiplication\n\t4. Division\n\t5. Exit\n\n ");
		System.out.print("What would you like to do? ");
		
		do {
			System.out.print("");
			try {
				choice = userInput.nextInt();
				if (choice >= 1 && choice <= 5) {
					break; //if user inputs between 1 and 5, exit loop
				}
				else {
					System.out.print("You have entered an invalid choice, please re-enter a number between 1 and 5: ");
					continue;  //if user inputs numbers not between 1 and 5, display error message, loop and get new input
				}
			} //end try
			catch (final InputMismatchException e) {
				System.out.print("You have entered an invalid choice, please re-enter your choice: ");
				userInput.nextLine();
				continue; //if user inputs invalid values, display error message, clean buffer, loop and get new input
			} //end catch
		} while (true); //end do
		
		System.out.println("");
		return choice;
	} //end getUserChoice
	
	//Obtain two float numbers
	public static void getTwoFloats(float[] myTwoFloats, Scanner getFloats) {
		
		do {
			System.out.print("");
			try {
				myTwoFloats[0] = getFloats.nextFloat();
				myTwoFloats[1] = getFloats.nextFloat();
				break; //if user input two correct numbers, exit loop
			} //end try
			catch (final InputMismatchException e) {
				System.out.print("You have entered invalid floats, please re-enter: ");
				getFloats.nextLine();
				continue; //if user inputs invalid values, display error message, clean buffer, loop and get new input
			} //end catch
		} while (true);  //end do
		
		//clear buffer
		getFloats.nextLine();
	} // end getTwoFloats
	
	//adding two numbers
	public static void add(double num1, double num2) {
		double sum;
		sum = num1 + num2;
		System.out.printf("Result of adding %.2f and %.2f is %.2f.\n", num1, num2, sum);
	} //end add
	
	//subtracting two numbers
	public static void sub(double num1, double num2) {
		double result;
		result = num1 - num2;
		System.out.printf("Result of subtracting %.2f and %.2f is %.2f.\n", num1, num2, result);
	} //end sub
	
	//multiplying two numbers
	public static void mul(double num1, double num2) {
		double product;
		product = num1 * num2;
		System.out.printf("Result of multiplying %.2f and %.2f is %.2f.\n", num1, num2, product);
	} //end multiply
	
	//dividing two numbers
	public static void div(double num1, double num2) {
		double quotient;
		quotient = num1 / num2;
		System.out.printf("Result of dividing %.2f and %.2f is %.2f.\n", num1, num2, quotient);
	}//end divide
	
	//pressing enter to continue
	public static void pressEnter(Scanner press) {
		System.out.println("\nPress enter key to continue. . . .");
		press.nextLine();
	} //end pressEnter
	
} //end class
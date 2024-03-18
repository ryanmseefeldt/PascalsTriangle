//Programmer: Ryan Seefeldt 
//Class: CS& 145 Lab 5
//Date:02/28/24
//Purpose: The purpose of this Lab is to create a program to generate 
//   Pascal's Triangle.
//   This Java program generates Pascal's Triangle and allows the user 
//   to specify the number of rows. It calculates the values using the
//   formula for combinations (n choose r) and the factorial function.
//   This program demonstrates the calculation and printing of Pascal's 
//   Triangle using BigInteger to handle large numbers accurately and 
//   efficiently. It provides a user-friendly interface for generating 
//   and displaying Pascal's Triangle.   


import java.io.*;
import java.util.Scanner;
import java.math.BigInteger;
 
class pascal {
    //  The factorial method calculates the factorial of a given 
    //  BigInteger number recursively.
    //  Inside the method, it first checks if the number is less than or
    //  equal to BigInteger.ONE. If so, it returns BigInteger.ONE because
    //  the factorial of 0 or 1 is always 1.
    //  If the number is greater than 1, it recursively calls the factorial
    //  method with the parameter number.subtract(BigInteger.ONE), 
    // effectively reducing the number by 1 in each recursive call.
    public BigInteger factorial(BigInteger number) {
    
        if (number.compareTo(BigInteger.ONE) <=0)
            return BigInteger.ONE;
        // It multiplies the number with the result of the factorial of 
        // number.subtract(BigInteger.ONE) and returns the result.    
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
        
    }
    
    // In the main method, the program repeatedly prompts the user to 
    // choose an option: generate Pascal's Triangle or quit the program.
    public static void main(String[] args)    {
         
         printIntro();
         
         boolean contEntry = true;
         do  {
          
              
              char command = getCommand();
                
              switch (command) {
                  // If the user chooses to generate Pascal's Triangle 
                  // ('g'), the program prompts for the number of rows 
                  // and then calculates and prints the triangle.
                  // The calculation involves finding the value for 
                  // each position in the triangle using the 
                  // combination formula (n choose r) and the factorial
                  // function
                  case 'g': {
                       
                       int number = getInt(); 
                       int i, j;
                       pascal g = new pascal();
                       //  This variable will be used to keep track of the
                       //  total sum of values in each row of the triangle.
                       BigInteger totalCount = BigInteger.ZERO;
                       
                       // Outer loop iterates over each row of the triangle.
                       for (i = 0; i <= number; i++) {
 
                           // Inner loop prints spaces for left alignment
                           // based on the row number (i) to create the 
                           // triangular shape of Pascal's Triangle.
                           for (j = 0; j <= number - i; j++) {
      
                               // for left spacing
                               System.out.print(" ");
                           }
                           
                           // Inner loop calculates and prints the values of 
                           // each element in the current row of Pascal's 
                           // Triangle.
                           for (j = 0; j <= i; j++) {
     
                               // Calculates the value of the current element
                               // using the combination formula (n choose r). 
                               // It calls the factorial method of the pascal 
                               // class to compute factorials of i, i - j, and j, 
                               // and then applies the combination formula
                               BigInteger value = g.factorial(BigInteger.valueOf(i))
                                   .divide((g.factorial(BigInteger.valueOf(i - j)))
                                     .multiply(g.factorial(BigInteger.valueOf(j))));
                               System.out.print(" " + value);
                               totalCount = totalCount.add(value);
                           }
 
                           
                           System.out.print(" = " + totalCount);                      
                           totalCount = BigInteger.ZERO; // reinitialize totalCount
                           System.out.println();
                       }

                       break;
                  }
                  // The program continues to run until the user chooses to quit ('q').
                  case 'q': {

                       contEntry = false;
                  
                       break;
                  }
                  default: {
                       System.out.println("Invalid Entry\n");
                  }
                            
             } // end of switch
     
          } while (contEntry);
      

    }  // end of main
    
    // The printIntro() method in the provided code is a simple 
    // utility method used to print an introduction message when 
    // the program starts.
    public static void printIntro() {

          System.out.println("Welcome to my program to print Pascal's Triangle ");


     } // end of printIntro

    // The getCommand() method in the provided code is responsible for prompting
    //  the user to select an option from a menu and returning their choice as 
    // a character.  
    public static char getCommand() {

         Scanner reader = new Scanner(System.in);    
         char command;
         
         System.out.println("\nPlease select an option:");
         System.out.println("Generate a pascal's triangle (g)");
         System.out.println("Quit the program (q)");
         System.out.print("Enter choice: ");
         
         command= reader.next().charAt(0);
         return command;                                                              

    } // end of getcommand
    
   // The getInt() method in the provided code is responsible for prompting
   // the user to enter an integer representing the size of the triangle 
   // and returning that integer. 
   public static int getInt() {

         Scanner reader = new Scanner(System.in);    
         int number;
         System.out.print("\nEnter integer for size of triangle: ");

         number = reader.nextInt();         
         return number;                                                              

    } // end of getcommand


} // end of pascal
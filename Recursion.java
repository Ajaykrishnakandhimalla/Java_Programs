// "static void main" must be defined in a public class.
import java.util.*; // Import the Scanner class
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.lang.StringBuffer;

public class Assignment4 {
    
    public String recur(int decimalNumber,StringBuilder sb){
        if(decimalNumber==0){
            return sb.reverse().toString();
        }
        int quo = decimalNumber/2;
        sb.append(decimalNumber%2);
        return recur(quo,sb);
    }
    
    public static void main(String[] args) {
        Assignment4 sol = new Assignment4();
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number to convert:");

        int decimalNumber = myObj.nextInt();  
        String result = sol.recur(decimalNumber,new StringBuilder());
        System.out.println("Decimal Number:"+ decimalNumber+"   Binary Equivalent:"+result);
        
    }
}
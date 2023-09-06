package hackerank;

import java.io.*;
import java.util.*;

public class JavaStringTokens_RegEx {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim(); // remove leading and trailing spaces
        // Write your code here.
        scan.close();
        
        if(input.isEmpty()){
            System.out.println(0);
        } else{
            String[] a = input.split("[^\\p{Alpha}]+");

            System.out.println(a.length);
            for(String iString : a) {
                System.out.println(iString);
            }
        }

        
    }
    
}


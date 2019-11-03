package point_jour_p2DuplicateCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCounter	
{
   private Map<String, Integer> wordCounter;
  
   public DuplicateCounter(){
       wordCounter = new HashMap<String,Integer>();
   }
  
   public void count(String filename){
       //Read the input file
       Scanner infile = null;
       try {
           infile = new Scanner(new File(filename));
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
           return;
       }
       infile.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+"); 	//Use characters digits, spaces or punctuation marks to extract words
       while(infile.hasNext()) {
           String word = infile.next().toLowerCase();
           Integer count = wordCounter.get(word); 		//Get count from map
           if(count == null)
               count = 1;
           else
               count = count + 1;
           wordCounter.put(word, count);
       }
       infile.close();
   }
  
   public void write(String filename){
       //Write to file
       try {
           PrintWriter outfile = new PrintWriter(new File(filename));
           for(String k : wordCounter.keySet()) {
               outfile.println(k + " " + wordCounter.get(k));
           }
           outfile.close();
           //Check output file
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       }
   }
  
}
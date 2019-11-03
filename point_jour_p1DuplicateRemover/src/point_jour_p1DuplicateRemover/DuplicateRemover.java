package point_jour_p1DuplicateRemover;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicateRemover {
   private Set<String> uniqueWords;
   //This method takes the file name as input, and removes the duplicate words using Set
   public void remove(String dataFile) throws FileNotFoundException
   {
       String word;
       uniqueWords = new HashSet<String>();
       Scanner sc=new Scanner(new File(dataFile));
       while(sc.hasNext())
       {
           word=sc.next();
           uniqueWords.add(word);
       }
       sc.close();
      
      
   }
  
   //This method writes contents of Set to output file
   public void Write(String outputFile) throws IOException
   {
File f;
FileWriter fw = null;

f = new File(outputFile);
//If file exists, write data to existing file
if(f.exists()) {
fw=new FileWriter(f,true);
Iterator<String> itr=uniqueWords.iterator();

while(itr.hasNext())
{
   String str=(String)itr.next();
   fw.write(str+"\n");     
}
fw.close();
System.out.println("Data Written to File");
  
}
else
{
//If no file exists. Then create new File
f.createNewFile();
fw=new FileWriter(f);
Iterator<String> itr= uniqueWords.iterator();

while(itr.hasNext())
{
   String str=(String)itr.next();
   fw.write(str+"\n");     
}
fw.close();
System.out.println("Data Written to File");
}

   }

}
/*****************************
  Компьютерный практикум №1
  ФИ-52, Я. Кратт, М. Бурлака
 *****************************/
package cryptolab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 *
 * @author raccoon
 */
public class Filter {
    public Filter(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
      String path="D://STUDY//крипта//cryptoLab1//"+inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"CP1251")); 
      FileWriter writer = new FileWriter("D://STUDY//крипта//cryptoLab1//"+outFileName, true);
      String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+line;
        }
        bigLine=bigLine.replaceAll("[^А-Яа-я]", " ");
            bigLine=bigLine.replaceAll("\\s+", " ");
            bigLine=bigLine.toLowerCase();
             bigLine=bigLine+"\n";
            writer.write(bigLine);
        writer.close();
        
        
}
    void removeSpaces(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException
    {
        String path="D://STUDY//крипта//cryptoLab1//"+inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8")); 
      FileWriter writer = new FileWriter("D://STUDY//крипта//cryptoLab1//"+outFileName, true);
      String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+line;
        }
            bigLine=bigLine.replaceAll(" ", "");
             bigLine=bigLine+"\n";
            writer.write(bigLine);
        writer.close();
    }
}
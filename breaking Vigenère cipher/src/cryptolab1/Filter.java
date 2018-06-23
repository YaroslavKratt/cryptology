/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     Filter(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
      String path="D://STUDY//крипта//cryptoLab2//"+inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"CP1251")); 
      FileWriter writer = new FileWriter("D://STUDY//крипта//cryptoLab2//"+outFileName, true);
      String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+"\n"+line;
        }
        bigLine=bigLine.replaceAll("[^А-Яа-я]", " ");
            bigLine=bigLine.replaceAll("\\s+", " ");
            bigLine=bigLine.toLowerCase();
            writer.write(bigLine);
        writer.close();
        
        
    }

    public Filter() {
        
    }

    /**
     *
     */
    public void filter(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
      String path="D://STUDY//крипта//cryptoLab2//"+inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"CP1251")); 
      FileWriter writer = new FileWriter("D://STUDY//крипта//cryptoLab2//"+outFileName, false);
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

}


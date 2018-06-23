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
/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
public class Filter {
     Filter(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
      String path=".//"+inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"CP1251"));
      FileWriter writer = new FileWriter(".//"+outFileName, true);
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
      String path=inFileName;
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"utf8"));
      FileWriter writer = new FileWriter(outFileName, false);
      String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+line;
        }
        bigLine=bigLine.replaceAll("[^А-Яа-я]", " ");
            bigLine=bigLine.replaceAll("\\s+", "");
        bigLine=bigLine.replaceAll("ё", "е");

        bigLine=bigLine.toLowerCase();
             bigLine=bigLine+"\n";
            writer.write(bigLine);
        writer.close();
        
        
    }
    public void filter1(String inFileName, String outFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{
        String path="./"+inFileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        FileWriter writer = new FileWriter("./"+outFileName, false);
        String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+line;
        }
        bigLine=bigLine.replaceAll("\\s", "");
        bigLine=bigLine+"\n";
        writer.write(bigLine);
        writer.close();


    }
    public void encoding(String inFileName, String outFileName) throws IOException {
        String path=inFileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"CP1251"));
        FileWriter writer = new FileWriter(".//"+outFileName, true);
        String line,bigLine="";
        while((line = br.readLine()) != null){
            bigLine=bigLine+"\n"+line;
        }

        writer.write(bigLine);
        writer.close();


    }

}





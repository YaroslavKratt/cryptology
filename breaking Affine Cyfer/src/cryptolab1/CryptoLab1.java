/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
package cryptolab1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.Character.toLowerCase;
import java.util.regex.*;




/**
 *
 * @author raccoon
 */
public class CryptoLab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException, IOException   {
        //Filter f=new Filter();
        Frequency fr1=new Frequency();
        //fr1.symbolFreq("./Decrepted.txt");
        fr1.printTable(fr1.bigramFreq1());
        fr1.bigramFreq2();
     
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolab2;
import cryptolab1.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author raccoon
 */
public class CryptoLab2 extends CryptoLab1{

   
    public static void main(String[] args) throws UnsupportedEncodingException, IOException, IOException {
       Filter f = new Filter();
        f.filter("text2.txt","filtered2.txt");
       Visionaere v=new Visionaere("keys2.txt","filtered2.txt");
       v.encrypt();
}
}
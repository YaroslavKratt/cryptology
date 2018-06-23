/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolab2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author raccoon
 */
public class Visionaere {
    private char [] alphabet= {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' '};
    private String line,allText;
    private String []keys;
    private char[] key;
    private char[] txt;
    private String encryptedTxt;
    
    
Visionaere(String keysFile,String inFileName) throws FileNotFoundException, UnsupportedEncodingException, IOException{        
    keys=new String [5] ;  
    allText="";
    encryptedTxt="";
    String keyPath = "D://STUDY//крипта//cryptoLab2//"+keysFile;
       BufferedReader brk = new BufferedReader(new InputStreamReader(new FileInputStream(keyPath),"UTF8"));
      int i=0;
       while((line=brk.readLine())!=null)
       {
           keys[i]=line;
           i++;
       }
       line="";
       String path = "D://STUDY//крипта//cryptoLab2//"+inFileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        allText="";
        while((line=br.readLine())!=null)
        {
            allText=allText+line;
        }
        

}
int getCharactersNumber(char c)
{   int k=0;
    for(int i=0; i<alphabet.length; i++)  
    {
        if(alphabet[i]==c)
            k=i;
    }
    return k;
    
}
char getCharacterByNumber(int n)
{
    return alphabet[n];
}
void encrypt() throws IOException 
{    FileWriter writer = new FileWriter("D://STUDY//крипта//cryptoLab2//encrypted2.txt", false);
    for(int i=0; i<5; i++)
        {   
            key=keys[i].toCharArray();
            writer.write("key "+"'"+keys[i]+"'"+":"+"\n");
            txt=allText.toCharArray();
            int maxIndexOfKey=key.length;
            encryptedTxt="";
            for(int j=0; j<txt.length; j++)
            {encryptedTxt=encryptedTxt+Character.toString(getCharacterByNumber((getCharactersNumber(txt[j])+getCharactersNumber(key[j%maxIndexOfKey]))%34));
            }
             encryptedTxt=encryptedTxt+"\n";
            writer.write(encryptedTxt);
            writer.write("");
        
        
        }
    writer.close();
    }
}

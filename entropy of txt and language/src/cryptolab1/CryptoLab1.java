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
import static java.lang.Character.toLowerCase;
import java.util.regex.*;




/**
 *
 * @author raccoon
 */
public class CryptoLab1 {

    private final static   char   alphabet1[] ={'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' '};
    private final  static char   alphabet2[] ={'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};

    public static void main(String[] args) throws UnsupportedEncodingException, IOException   {
       //Filter f=new Filter("text1.txt","filtered.txt");
        //f.removeSpaces("filtered.txt","filteredWitoutSpaces.txt");
        Frequency fr1=new Frequency();
        fr1.symbolFreq("filtered.txt", 33);
        fr1.printTable(fr1.bigramFreq1("filtered.txt"),alphabet1);
        fr1.printTable(fr1.bigramFreq2("filtered.txt"),alphabet1);
        System.out.println("Для текста без пробелов:");
        fr1.symbolFreq("filteredWitoutSpaces.txt",32);
        fr1.printTable(fr1.bigramFreq1("filteredWitoutSpaces.txt"),alphabet2);
        fr1.printTable(fr1.bigramFreq2("filteredWitoutSpaces.txt"),alphabet2);
     
}
}

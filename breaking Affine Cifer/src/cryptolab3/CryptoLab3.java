/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
package cryptolab3;
import cryptolab1.Filter;
import cryptolab1.Frequency;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class CryptoLab3 {
    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        long start = System.currentTimeMillis();
        // поиск смысла жизни ...
        Filter f=new Filter();
        f.encoding("/home/raccoon/IdeaProjects/symCryptoLab3(Affine Cifer)/src/variants/05.txt","v5UTF8");
        Operations o=new Operations();
        //System.out.println(o.lenearComprasion(4,4,32));
        Frequency fr1=new Frequency();
        AffineCipher a=new AffineCipher();
        a.findKeys(a.solveSystem(fr1.bigramFreq2()),"/home/raccoon/IdeaProjects/symCryptoLab3(Affine Cifer)/v5UTF8");
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println("time of work: "+timeConsumedMillis/1000+" seconds");
}
}
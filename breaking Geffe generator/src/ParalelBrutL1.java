/*****************************
 Компьютерный практикум №4
 ФИ-52, Я. Кратт, М. Бурлака
 *****************************/
import java.util.ArrayList;
import java.util.concurrent.*;

public class ParalelBrutL1 implements Callable<ArrayList<Long>>
{   long start;
    long end;
  String z ="10010000011000011000001110001100001101100100111000000110100111101010001001100011110110011001111011110010110011011010000101000011100000111111011000011010111000110110100001101111010011111000110111100011110100110010011110001100011001100111001000000111100100010100110101101011010100110110100001000100001000110000011000111101110001011111111001010001100101010100000010010100001000010010110001000110110111010110001110110101000110000110011101111010111101101010111000000111001101100000100100111101110101011100111000110101111110100100011101101001010010111010100010111101001010110010100010111001111000011000010001001000010111111010110101001101111100011010000101001001010111010010011100000010110000010100010010111111110011100010110100011001100110101111100010000001010111100111011000001101100001101010011110000101010011001110000111000101000101001110101100111000000000110010110001100100011100101010101111100110100111010111011001101110111110000101101000000010011010011010101111010100111011110000000000101101011011101001000010110110011011101100110111101001001011001011011111010001000011101001011010011111000111011111100101010100110011110110111010000000010001010011000100110101100011110101110111111001001111111101010011100111001100000011010101101000100011101111101000100101001111110000101001111010100110011010101101101100000011011101100111010100100110100100001110010010110010001000010100010111111100011010000110100001000000010110111110011111100000011000100011010111110001100001111011101000001001001110111001001110011110100001011001010011011000111000010000100010010100110101110000000111010110001111101010001011001101010011000010000001000000110011010101011011101001110100000111110100100011110011110000011100001111101111110101011101101100101000001100001111111000000010110011010100101011010000011110010010111010111010101101001001000011000110001100001010111010110011011110010000111010010011010011100100110001100100001000101110011011000111001101110110001001000100010010010001110001000011111111011100100110011110100111101000111100100101000001101111000110110010100110010110";

    int arr[]=new int [z.toCharArray().length];
    long x;
    long y;

    ParalelBrutL1(long start, long end)
    {
        this.start=start;
        this.end=end;
        for(int i=0; i<z.toCharArray().length;i++) {
            arr[i] = Integer.parseInt(String.valueOf(z.toCharArray()[i]));
        }
    }
    public ArrayList<Long> call()
    {
        ArrayList<Long> res=new ArrayList<Long>();
        long min=1000;
        for (long i = start; i < end; i++)
        {
            long R1 = 0;
            Geffe l = new Geffe(i, i, i);
            for (int j = 0; j < l.N1; j++) {
                R1 =R1+  (l.L1() ^ arr[j]);
            }
            if(min>R1)
                min=R1;
                if (R1 <= l.C1)
                {
                    System.out.println("added "+i);
                    res.add(i);
                }
            }
        System.out.println("min" + min);

        return res;
    }
}

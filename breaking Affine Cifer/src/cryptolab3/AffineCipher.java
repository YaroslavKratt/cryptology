/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
package cryptolab3;
import cryptolab1.Frequency;
import cryptolab1.SymbolResult;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeMap;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class AffineCipher {
    private  char   alphabet[] ={'а','б','в','г','д','е','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ь','ы','э','ю','я'};
    private String[] frequentRussianbigrams={"ст", "но", "то", "на", "ен"};
    private TreeMap<Integer,String> bigramsAndNumbers=new TreeMap<Integer, String>();
    private ArrayList<SymbolResult> frequenceInRus=new ArrayList<SymbolResult>();
    AffineCipher()
    {   String tempStr="";
        for(int i=0;i<alphabet.length;i++)
            for(int j=0; j<alphabet.length; j++)
            {
                tempStr=new StringBuilder().append(alphabet[i]).append(alphabet[j]).toString();
                bigramsAndNumbers.put(getBigramNumber(tempStr),tempStr);
                tempStr="";
            }
         System.out.println();

        frequenceInRus.add(new SymbolResult((float) 10.97,'о',0, 0));
        frequenceInRus.add(new SymbolResult((float)8.45,'е',0, 0));
        frequenceInRus.add(new SymbolResult((float)8.01,'а',0, 0));
        frequenceInRus.add(new SymbolResult((float)7.35,'и',0, 0));
        frequenceInRus.add(new SymbolResult((float)6.7,'н',0, 0));
        frequenceInRus.add(new SymbolResult((float)6.26,'т',0, 0));
        frequenceInRus.add(new SymbolResult((float)5.47,'с',0, 0));
        frequenceInRus.add(new SymbolResult((float)4.73,'р',0, 0));
        frequenceInRus.add(new SymbolResult((float)4.54,'в',0, 0));
        frequenceInRus.add(new SymbolResult((float)4.4,'л',0, 0));
        frequenceInRus.add(new SymbolResult((float)3.49,'к',0, 0));
        frequenceInRus.add(new SymbolResult((float)3.21,'м',0, 0));
        frequenceInRus.add(new SymbolResult((float)2.98,'д',0, 0));
        frequenceInRus.add(new SymbolResult((float)2.81,'п',0, 0));
        frequenceInRus.add(new SymbolResult((float)2.01,'я',0, 0));
        frequenceInRus.add(new SymbolResult((float)1.90,'ы',0, 0));
        frequenceInRus.add(new SymbolResult((float)1.74,'ь',0, 0));
        frequenceInRus.add(new SymbolResult((float)1.65,'з',0, 0));
        frequenceInRus.add(new SymbolResult((float)1.44,'ч',0, 0));
        frequenceInRus.add(new SymbolResult((float)1.21,'й',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.97,'х',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.94,'ж',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.64,'ю',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.48,'ц',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.36,'щ',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.32,'э',0, 0));
        frequenceInRus.add(new SymbolResult((float)0.26,'ф',0, 0));









    }
    int getNuberOfCharachter(char s , char[] al)
    {   int k=0;
        for(int i=0; i<al.length; i++)
        {
            if(al[i]==s)
                k=i;
        }
        return k;
    }
    char getCharacterByNumber(int n,char[] al )
    {
        return al[n];
    }
    int getBigramNumber(String bigram)
    {   int number;
        int number1=getNuberOfCharachter(bigram.toCharArray()[0],alphabet);
        int number2=getNuberOfCharachter(bigram.toCharArray()[1],alphabet);
        number=number1*alphabet.length+number2;

        return number;
    }
    String getBigramByNumber(int number)
    {

        return bigramsAndNumbers.get(number);
    }

    int[] getArrayOfNumbers(String[] arr)
    {   int num[] =new int[arr.length];
        for(int i=0; i<arr.length;i++)
            num[i]=getBigramNumber(arr[i]);
        return num;

    }
    HashSet<Integer[]> solveSystem(String[] arr){
        String frequentCryptedBigrams []=new String [5];
       HashSet<Integer[]> res=new HashSet<>();
       HashSet<Integer> a=new HashSet<Integer>();
      // System.out.println(arr.length);
       System.arraycopy(arr, arr.length-5,  frequentCryptedBigrams, 0, 5);
       for(int i = 0; i < frequentCryptedBigrams.length / 2; i++)
       {
           String temp = frequentCryptedBigrams[i];
           frequentCryptedBigrams[i] = frequentCryptedBigrams[frequentCryptedBigrams.length - i - 1];//сортировка
           frequentCryptedBigrams[frequentCryptedBigrams.length - i - 1] = temp;
       }
       int []numOfCrypt=getArrayOfNumbers(frequentCryptedBigrams);
       int[] numOfRuss=getArrayOfNumbers(frequentRussianbigrams);
       //System.out.println(numOfCrypt.length+"         "+ numOfRuss.length);
       Operations o =new Operations();
       int rusDiff;
       int cryptDiff;
       int f=0;
       for (int j=0; j< 5; j++)  //циклы для выбора нужных пар биграмм
       {
           for (int i = 0; i <5; i++)
           {
               for (int k = 0; k <5; k++)
               {
                   for (int h = 0; h <5; h++)
                    {


                   if(i!=j&&k!=h&&i!=h)
                        {
                       rusDiff = numOfRuss[i] - numOfRuss[j];
                       cryptDiff = numOfCrypt[k] - numOfCrypt[h];
                       if (rusDiff < 0)
                           rusDiff = (int) (rusDiff + pow(alphabet.length, 2));
                       if (cryptDiff < 0)
                           cryptDiff = (int) (cryptDiff + pow(alphabet.length, 2));

                       //System.out.println("rus  "+rusDiff+" numCrypt  "+cryptDiff);
                       ArrayList<Integer> temp = o.lenearComprasion(rusDiff, cryptDiff, (int) pow(alphabet.length, 2));

                       System.out.println(temp);
                       int c=0;
                       for (Integer item : temp) {
                           a.add(item);
                           c++;
                       }
                       //System.out.println(c);
                   }
              f++; }
               }
           }
       }
       // System.out.println(f);


        for(int j=0;j<5;j++)
        for (Integer item : a) {
                   int i = 0;
                   //System.out.println(item + "  ");

                   if (item != null) {
                       int temp = (numOfCrypt[i] - item * numOfRuss[j]) % (int) pow(alphabet.length, 2);
                       if (temp < 0) {
                           temp = temp + (int) pow(alphabet.length, 2);
                           //System.out.println("a= "+item+"  b= "+temp);
                           //System.out.println(item + "  " + temp);}
                           // b.add(temp);
                       }
                       res.add(new Integer[]{item, temp});
                       //System.out.println("a= "+item+"  b= "+temp);

                       i++;
                   }
               }

    return res;
    }

    String decrypt(int a, int b, ArrayList<String> bigrams )  {
        String allText="";

        Operations o=new Operations();
        for (String item:bigrams)
        {   //System.out.println(item);
            int Y=getBigramNumber(item);
            int inverse=o.inverse(a,(int)pow(alphabet.length,2));
            if (inverse==0) {

                return allText;
            }
            int X=(inverse*(Y-b))%(int)pow(alphabet.length,2);
            if(X<0)
                X=X+(int)pow(alphabet.length,2);
            allText=allText+ getBigramByNumber(X);
        }
      return allText;



    }


    boolean resolver(String str) throws FileNotFoundException, UnsupportedEncodingException {
        Frequency f=new Frequency();
        ArrayList<SymbolResult> freq=f.symbolFreq1(str);
        double H=f.getEntropy(str);
        SymbolResult[] frequency=freq.toArray(new SymbolResult[freq.size()]);
        SymbolResult[] freqRus=frequenceInRus.toArray(new SymbolResult[frequenceInRus.size()]);
        boolean flag=false;
        int counter=0;
        if(frequency.length==0)
            return false;
        int limit;
        if(freqRus.length<frequency.length)
            limit=freqRus.length;
        else
            limit=frequency.length;
            for(int i=0; i< limit;i++) {
                if (abs(frequency[i].getCount()/frequency[i].getSum()*100-freqRus[i].getCount())<1) {
                    counter++;
                }
        }
        if (counter>0.7* frequenceInRus.size() &&abs(H-4.35)<0.2) // фильтр по энтропии и частоте символов
            {
            System.out.println("количество совпавших по частоте букв: "+counter+ "  "+ "отличие энропий: "+abs(H-4.35));
            flag=true;
            }
            else
                {
                    flag=false;
                }
    return flag;
    }
    void findKeys(HashSet<Integer[]> keys,String path) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        String allText="";
        String line;
        String temp="";
        ArrayList<String> bigrams=new ArrayList<String>();
        while((line=br.readLine())!=null)
        {
            allText=allText+line;
        }
        for(int i=0; i<allText.toCharArray().length; i++)
        {  temp=temp+allText.toCharArray()[i];//разбил строку на биграммы
            if((i+1)%2==0 )
            {
                bigrams.add(temp);

                temp="";

            }
        }
        System.out.println(allText);
        int i=0;
        for (Integer[] item : keys) {
            String s= decrypt(item[0],item[1],bigrams); //расшифровал, проверил на осмысленность
            if(resolver(s))
            {
                System.out.println("keys: " +item[0]+" "+item[1] );
                System.out.println(s);

                System.out.println("\n▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀");}
         i++;}


    }
    void encrypt(int a,int b, String path,String pathOut) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        String allText="";
        String line;
        ArrayList<String> bigrams=new ArrayList<String>();
        ArrayList<Integer> bigramsNumbers=new ArrayList<Integer>();


        while((line=br.readLine())!=null)
        {
            allText=allText+line;
        }
        String temp="";
        for(int i=0; i<allText.toCharArray().length; i++)
        {  temp=temp+allText.toCharArray()[i];//разбил строку на биграммы
            if((i+1)%2==0 )
            {
                bigrams.add(temp);
                temp="";
            }
        }
        Operations o=new Operations();
        allText="";
        FileWriter writer = new FileWriter(pathOut, false);
        for (String item:bigrams)
        {   int X=getBigramNumber(item);
            int Y=(a*X+b)%(int)pow(alphabet.length,2);
            if(Y<0)
                Y=Y+(int)pow(alphabet.length,2);
            allText=allText+ getBigramByNumber(Y);

        }
        System.out.println(allText);
        writer.write(allText);
        writer.close();


    }
    }



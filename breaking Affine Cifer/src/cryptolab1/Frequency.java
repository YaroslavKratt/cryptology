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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.round;
import static java.lang.StrictMath.log;

import java.util.*;

/**
 *
 * @author raccoon
 */
public class Frequency {
    private String path,line;
    private BufferedReader br;
    private char arr[];
    private char   alphabet[];
    private Result[] res;
    private int resLength;
    
    public Frequency() throws FileNotFoundException, UnsupportedEncodingException 
    {
       
      int k=0;
      resLength=0;

 
    }

    public ArrayList<SymbolResult> symbolFreq1(String str){
        TreeMap<Character,Integer> mapOfFrequency =new  TreeMap<Character, Integer>();
            arr=str.toCharArray();
            for(char symbol :arr)
            {
                if(mapOfFrequency.get(symbol)==null)
                {
                    mapOfFrequency.put(symbol, 1);
                }
                else
                {
                    mapOfFrequency.put(symbol,mapOfFrequency.get(symbol)+1);
                }
            }

        TreeMap<Integer,Character> sorted =new  TreeMap< Integer, Character>();
        for(Map.Entry<Character,Integer> item : mapOfFrequency.entrySet()){
            sorted.put(item.getValue(), item.getKey());
        }
        resLength=0;
        ArrayList<SymbolResult> res =new ArrayList<SymbolResult>();
        int i=0; int sum=0; double H1=0; double temp;
        for(Map.Entry<Integer,Character> item : sorted.entrySet())
            sum=sum+ item.getKey();
        for(Map.Entry<Integer,Character> item : sorted.entrySet()) //для красивого вывода перегоняем всё в массивчик результирующего класса, с которым, в теории, удобнее работать
        {
            res.add(new SymbolResult( (float)(item.getKey()),item.getValue(),sum, 0));
            // System.out.println(i+" "+res[i].getCount()+" "+ res[i].getBigramma());
            i++;
        }
        for(int j=res.size()-1; j>=0;j--)
        {
            temp=(double)res.get(j).getCount()/sum;
            H1= (H1+temp*log2(temp));
            //System.out.printf("%.4f",((float)res.get(j).getCount()));
            //System.out.println(" "+res.get(j).getCharacter());

        }
        H1=-H1;
        //System.out.println("H1="+H1);
        Collections.reverse(res);
        return res; }
    public double getEntropy(String str){
        TreeMap<Character,Integer> mapOfFrequency =new  TreeMap<Character, Integer>();
        arr=str.toCharArray();
        for(char symbol :arr)
        {
            if(mapOfFrequency.get(symbol)==null)
            {
                mapOfFrequency.put(symbol, 1);
            }
            else
            {
                mapOfFrequency.put(symbol,mapOfFrequency.get(symbol)+1);
            }
        }

        TreeMap<Integer,Character> sorted =new  TreeMap< Integer, Character>();
        for(Map.Entry<Character,Integer> item : mapOfFrequency.entrySet()){
            sorted.put(item.getValue(), item.getKey());
        }
        resLength=0;
        ArrayList<SymbolResult> res =new ArrayList<SymbolResult>();
        int i=0; int sum=0; double H1=0; double temp;
        for(Map.Entry<Integer,Character> item : sorted.entrySet())
            sum=sum+ item.getKey();
        for(Map.Entry<Integer,Character> item : sorted.entrySet()) //для красивого вывода перегоняем всё в массивчик результирующего класса, с которым, в теории, удобнее работать
        {
            res.add(new SymbolResult( (float)(item.getKey()),item.getValue(),sum, 0));
            // System.out.println(i+" "+res[i].getCount()+" "+ res[i].getBigramma());
            i++;
        }
        for(int j=res.size()-1; j>=0;j--)
        {
            temp=(double)res.get(j).getCount()/sum;
            H1= (H1+temp*log2(temp));
            //System.out.printf("%.4f",((float)res.get(j).getCount()));
            //System.out.println(" "+res.get(j).getCharacter());

        }
        H1=-H1;
        //System.out.println("H1="+H1);
        Collections.reverse(res);
        return H1; }
    static double log2(double x )
{
    double res = 0;
    
    if(x!=0)
    {
        res= (log(x)/log(2));
        return res;

    }
    else 
    return 0;
}
    public Result[] bigramFreq1() throws IOException
    {        
      path = "/home/raccoon/IdeaProjects/symCryptoLab3(Affine Cifer)/v5UTF8";
      br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        String allText=""; 
        while((line=br.readLine())!=null)
              { 
                  allText=allText+line;
              }
            arr= allText.toCharArray();
            String tempStr;
            TreeMap<String,Integer> map=new  TreeMap<String,Integer>();
            for(int i=1; i<arr.length; i++)
            {
                tempStr="";
                tempStr= Character.toString(arr[i-1])+ Character.toString(arr[i]);
                if(map.get(tempStr)==null)
                {
                    map.put(tempStr,1);
                }
                else
                {
                     map.put(tempStr,map.get(tempStr)+1);
                }
                
            }
          
       int i=0;
       resLength=0; 
       Result res []=new Result [1156];
        for(Map.Entry<String,Integer> item : map.entrySet()) //для красивого вывода перегоняем всё в массивчик результирующего класса, с которым, в теории, удобнее работать 
        {
            res[i]=new Result( item.getValue(),item.getKey());
           // System.out.println(i+" "+res[i].getCount()+" "+ res[i].getBigramma());
           resLength++; 
           i++;
        }
        System.out.println("Пары букв, которые пересекаются");
       return res;
    }

    public String[] bigramFreq2() throws IOException
    {          
        path = "/home/raccoon/IdeaProjects/symCryptoLab3(Affine Cifer)/v5UTF8";
        br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF8"));
        String allText=""; 
        while((line=br.readLine())!=null)
              { 
                  allText=allText+line;
              }
            arr= allText.toCharArray();
            String tempStr;
            TreeMap<String,Integer> map=new  TreeMap<String,Integer>();
            for(int i=1; i<arr.length; i=i+2)
            {
                tempStr="";
                tempStr= Character.toString(arr[i-1])+ Character.toString(arr[i]); //засовуем биграммы и кол-во их вхождений в TreeMap, где ключ это биграмма
                if(map.get(tempStr)==null)
                {
                    map.put(tempStr,1);
                }
                else
                {
                     map.put(tempStr,map.get(tempStr)+1);
                }
                
            }
        int i=0;
       resLength=0; 
       ArrayList<Result> res =new ArrayList<Result>();
        for(Map.Entry<String,Integer> item : map.entrySet()) //для красивого вывода перегоняем всё в массивчик результирующего класса, с которым, в теории, удобнее работать 
        {
            res.add(new Result(item.getValue(), item.getKey()));
            resLength++;
            i++;
        }
        Collections.sort(res, Result.COMPARE_BY_COUNT);
        int u=res.toArray().length;
        String resultStr[]=new String [u];
        i=0;
        for (Result item:res
             ) {//System.out.println(item.getBigramma()+"    "+item.getCount());
                resultStr[i]=item.getBigramma();
           // System.out.println(resultStr[i]);
        i++;
        }
       /*int k=0;
       for(Map.Entry<Integer,String> item : sorted.entrySet()){
           k++;
           System.out.print(k+" ");
           System.out.printf("Ключ: %d  Значение: %s \n", item.getKey(), item.getValue());
       }*/
        return resultStr;
       
    }

    public void printTable(Result[] res)
    {   int table[][]=new int [34][34];
        char   alphabet[] ={'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я',' '};
        int sum=0;
         for(int i=0; i<resLength; i++)
         {
             sum=sum+res[i].getCount();
             
         }
                 System.out.println("Всего биграмм "+sum);

        for(int i=0; i<alphabet.length; i++)
       {
           for(int j=0; j<alphabet.length; j++)
            {
                for(int z=0; z<resLength; z++)
                {   //System.out.println("i"+i+" j"+j+" z"+z);
                    if(res[z].getBigramma().toCharArray()[0]==alphabet[i]&&res[z].getBigramma().toCharArray()[1]==alphabet[j])
                    {
                        table[i][j]=res[z].getCount();
                    }
                }
            }
       }   
        System.out.print("\t");
         double H2=0,temp=0;
       for(int i=0; i<alphabet.length; i++)
           System.out.print(alphabet[i]+ "\t");
       System.out.println();
       for(int i=0; i<alphabet.length; i++)
       {               
           System.out.print(alphabet[i]+ "\t");
           for(int j=0; j<alphabet.length; j++)
           {    
               temp=(double)table[i][j]/sum;
                H2= H2+temp*log2(temp);
               // System.out.print(H2+" ");
               System.out.printf("%.4f",(((float)temp)));  System.out.print("\t");
           }
           System.out.println();

       }
        H2=-H2;
        System.out.println("H2="+H2);


    }
    
    
    
}

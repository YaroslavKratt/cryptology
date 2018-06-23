
/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
package cryptolab3;

import java.util.ArrayList;

public class ABresult {
    private ArrayList<Integer> a;
    private  ArrayList<Integer> b;
    ABresult(ArrayList<Integer> a,ArrayList<Integer> b){
        this.a=a;
        this.b=b;
    }
    ArrayList<Integer> returnA(){return a;}
    ArrayList<Integer> returnB(){return b;}

}

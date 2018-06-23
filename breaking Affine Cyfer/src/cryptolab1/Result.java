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

import java.util.Comparator;

/**
 *
 * @author raccoon
 */
public class Result {
    private final int count;
    private final String bigramma;
    
    Result(int count, String bigramma)
    {
        this.count=count;
        this.bigramma=bigramma;
    }
    String getBigramma() {return bigramma;}
      int getCount() {return count;}
    public static final Comparator<Result> COMPARE_BY_COUNT = new Comparator<Result>() {
        @Override
        public int compare(Result lhs, Result rhs) {
            return lhs.getCount() - rhs.getCount();
        }
    };
}

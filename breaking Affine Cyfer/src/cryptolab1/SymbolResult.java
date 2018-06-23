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
public class SymbolResult {
  private final float count;
    private final Character symbol;
    private final int sum;
    private final float H;

    public SymbolResult(float count, Character symbol, int sum, float h)
    {
        this.count=count;
        this.symbol=symbol;
        this.sum=sum;
        H = h;
    }
   public Character getCharacter() {return symbol;}
    public float getCount() {return count;}
    public float getSum() {return sum;}
    public static final Comparator<SymbolResult> COMPARE_BY_COUNT = new Comparator<SymbolResult>() {
        @Override
        public int compare(SymbolResult lhs, SymbolResult rhs) {
            return (int) ((float)(lhs.getCount() )- (float) (rhs.getCount()));
        }
    };
}


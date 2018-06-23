/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptolab1;

/**
 *
 * @author raccoon
 */
public class SymbolResult {
  private final int count;
    private final Character symbol;
    
    SymbolResult(int count, Character symbol)
    {
        this.count=count;
        this.symbol=symbol;
    }
    Character getCharacter() {return symbol;}
      int getCount() {return count;}
}


/*****************************
  Компьютерный практикум №1
  ФИ-52, Я. Кратт, М. Бурлака
 *****************************/
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


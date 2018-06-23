/*****************************
  Компьютерный практикум №1
  ФИ-52, Я. Кратт, М. Бурлака
 *****************************/
package cryptolab1;

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
}

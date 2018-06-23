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

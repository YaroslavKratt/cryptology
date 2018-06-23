/*****************************
 Компьютерный практикум №3
 ФИ-52, Кратт Я., Бурлака М.
 *****************************/
package cryptolab3;

import java.util.ArrayList;

public class Operations {
    private int d;
    private int x;
    private int y;

    void extended_euclid(int a, int b) {
        int q, r, x1, x2, y1, y2;
        if (b == 0) {
            d = a;
            x = 1;
            y = 0;
            return;
        }
        x2 = 1;
        x1 = 0;
        y2 = 0;
        y1 = 1;
        while (b > 0) {
            q = a / b;
            r = a - q * b;
            x = x2 - q * x1;
            y = y2 - q * y1;
            a = b;
            b = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;

        }

        d = a;
        x = x2;
        y = y2;
    }

    int inverse(int a, int n) {
        extended_euclid(a, n);

        if (d == 1) {
            if (x < 0)
                x = x + n;
            return x;
        }

        return 0;


    }
    ArrayList lenearComprasion(int a, int b, int n)
    {   ArrayList<Integer> result=new ArrayList<Integer>();

        extended_euclid(a,n);
        if(d==1)
        {   result.add((inverse(a,n)*b)% n);
            return result;
        }
        else
        {
            if(b%d!=0)
            {
                return result;
            }
            else
            {
                int tempD=d;
            int x0=(inverse(a/tempD,n)*b/tempD)%(n/tempD);
                        result=new ArrayList<Integer>();
                for(int i=0; i<tempD;i++)
                result.add(x0+i*n/tempD);


            }
        }

        return result;
    }


}



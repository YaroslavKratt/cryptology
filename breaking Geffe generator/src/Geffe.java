/*****************************
 Компьютерный практикум №4
 ФИ-52, Я. Кратт, М. Бурлака
 *****************************/
public class Geffe {


    int C1 =77;//238;
    int N1= 257;//221
    int C2 =71;//81
    int N2= 264;//228
    long state1;
     long state2;
     long state3;

    int exit;
    Geffe(long start1, long start2,long start3)
    {  this.state1=start1;
        this.state2=start2;
        this.state3=start3;
    }
    long L1(){
        this.state1=(((state1>>29)&1)^((state1>>28)&1)^((state1>>25)&1)^((state1>>23)&1))|(state1<<1);
        return (state1>>30)&1;
    }

    long L2(){
        this.state2 = (((state2>>30)&1)^((state2>>27)&1))|(state2<<1);
        return (state2>>31)&1;
    }

    long L3(){
        this.state3 = (((state3>>31)&1)^((state3>>30)&1)^((state3>>29)&1)^((state3>>28)&1)^((state3>>26)&1)^((state3>>24)&1))|(state3<<1);
        return (state3>>32)&1;
    }
    long geffe(){
        long x=L1();
        long y=L2();
        long s=L3();
       return s&x^(1^s)&y;
    }


}

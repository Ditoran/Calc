package calc.jahnke.im.calc.ModelClasses;

/**
 * Created by Dominik on 27.05.2015.
 */
public class EuklidModule {

    int a;
    int b;
    int ggt;
    int kgv;

    public EuklidModule(int a, int b){
        this.a = a;
        this.b = b;
        calculate(a, b);
    }

    public void calculate(int a, int b){
        if(a==0){
            ggt = b;
        } else {
            while(b!=0){
                if(a>b){
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            ggt = a;
        }

        kgv = (this.a*this.b)/ggt;
    }

    public int getGgt(){
        return ggt;
    }

    public int getKgv(){
        return kgv;
    }

}

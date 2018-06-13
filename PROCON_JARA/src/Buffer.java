import java.util.concurrent.*;
/**
 *
 * @author antho
 */
public class Buffer {
    private final int[] b;

    private int i1=0, i2=0, j1=0, j2=0;
    private Semaphore mutex1 = new Semaphore(1,true);
    private Semaphore hayDatos1 = new Semaphore (0,true);
    private Semaphore hayEspacio1;
    
    private Semaphore mutex2 = new Semaphore(1,true);
    private Semaphore hayDatos2 = new Semaphore (0,true);
    private Semaphore hayEspacio2;
    
    
    public Buffer (int tam){
        b = new int [tam];

        hayEspacio1 = new Semaphore (b.length,true);
        hayEspacio2 = new Semaphore (b.length,true);
    }
    
    public void ponerPROD1(int dato) throws InterruptedException {
        hayEspacio1.acquire();
        mutex1.acquire();
        b[i1] = dato;
       
        i1=(i1+1)%b.length;
        mutex1.release();
        hayDatos1.release();
    }
    
   
    
    public void ponerPROD2(int dato) throws InterruptedException {
        hayEspacio2.acquire();
        mutex2.acquire();
        b[i2] = dato;
       
        i2=(i2+1)%b.length;
        mutex2.release();
        hayDatos2.release();
    }
     public int extraerCONS1() throws InterruptedException{
        hayDatos1.acquire();
        mutex1.acquire();
        int aux1 = j1;
        j1=(j1+1)%b.length;
        mutex1.release();
        hayEspacio1.release();
        return b[aux1];
    }
     
    public int extraerCONS2() throws InterruptedException{
        hayDatos2.acquire();
        mutex2.acquire();
        int aux2 = j2;
        j2=(j2+1)%b.length;
        mutex2.release();
        hayEspacio2.release();
        return b[aux2];
    }
    
}
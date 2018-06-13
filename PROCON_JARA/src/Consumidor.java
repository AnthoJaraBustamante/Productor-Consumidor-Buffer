public class Consumidor extends Thread {
   
    private int iter;
    private Buffer b;


    public Consumidor(Buffer b, int iter) {
        this.iter = iter;
        this.b = b;
    }

    @Override
    public void run() {
         int cont1 = 1, cont2 =1;
        for (int i = 1; i <= iter; i++) {
            int aux1;
            int aux2;
               try {
                if (GUI.Cons1) {
                    aux1 = b.extraerCONS1();

                    GUI.Consumido1.append(cont1 + ": " + "C1" + "<- " + (char) aux1 + "\n");
                    System.out.print("C1" + "<- " + (char) aux1 + "\n");
                    GUI.Consumido1.setCaretPosition(GUI.Consumido1.getDocument().getLength());
                    cont1++;
                }
                if (GUI.Cons2) {
                    aux2 = b.extraerCONS2();
                    GUI.Consumido2.append(cont2 + ": " + "C2" + "<- " + (char) aux2 + "\n");
                    System.out.print("C2" + "<- " + (char) aux2 + "\n");
                    GUI.Consumido2.setCaretPosition(GUI.Consumido2.getDocument().getLength());
                    cont2++;
                }

                Thread.sleep((int) (Math.random() * 10));
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

}
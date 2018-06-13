public class Productor extends Thread {

    private Buffer b;
    private int iter;

    //Rango de numeros ASCII de la a-z//
    public int num1 = 'a';
    public int num2 = 'z';
   
    /////////////////////////////////////

    public Productor(Buffer b, int iter) {
        this.b = b;
        this.iter = iter;

    }

    @Override
    public void run() {
    	int cont1 = 1, cont2 = 1;
        for (int i = 1; i <= iter; i++) {
            try {
               
                if (GUI.Prod1) {
                    int aux1 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
                    GUI.Productor1.append(cont1 + ": " + "P1" + "-> " + (char) aux1 + "\n");
                    GUI.Productor1.setCaretPosition(GUI.Productor1.getDocument().getLength());
                    System.out.print("P1" + "-> " + (char) aux1 + "\n");
                    b.ponerPROD1((char) aux1);
                    cont1++;

                }
                if (GUI.Prod2) {
                    int aux2 = (int) Math.floor(Math.random() * (num2 - num1) + num1);
                    GUI.Productor2.append(cont2 + ": " + "P2 " + "-> " + (char) aux2 + "\n");
                    GUI.Productor2.setCaretPosition(GUI.Productor2.getDocument().getLength());
                    System.out.print("P2" + "-> " + (char) aux2 + "\n");
                    b.ponerPROD2((char) aux2);
                    cont2++;
                }
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
}
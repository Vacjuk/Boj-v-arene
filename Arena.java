/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.tahovyboj;

/**
 *
 * @author Martin
 */
class Arena {
    private Bojovnik bojovnikA;
    private Bojovnik bojovnikB;
    private Kostka kostka;
    
    public Arena(Bojovnik bojovnikA, Bojovnik bojovnikB, Kostka kostka) {
        this.bojovnikA = bojovnikA;
        this.bojovnikB = bojovnikB;
        this.kostka = kostka;
    }
    
    private void vykresli() {
        System.out.println("------------- Aréna ------------- \n");
        System.out.println("Zdraví bojovníků: \n");
        System.out.printf("%s %s", bojovnikA, bojovnikA.grafickyZivot());
        System.out.printf("%s %s", bojovnikB, bojovnikB.grafickyZivot());
    }
    
    private void vypisZpravu(String zprava) {
        System.out.println(zprava);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            System.err.println("Chyba, nepodařilo se uspat vlákno");
        }
    }
            private void vypisBojovnika(Bojovnik bojovnik) {
            System.out.println(bojovnik);
            System.out.println("život: ");
            System.out.println(bojovnik.grafickyZivot());
            if (bojovnik instanceof Mag) {
                System.out.print("Mana :");
                System.out.println(((Mag) bojovnik).grafickaMana());
            }
        }
    
    public void zapas() {
        //původní pořadí
        Bojovnik bojovnikA = this.bojovnikA;
        Bojovnik bojovnik = this.bojovnikB;
        System.out.println("vítejte v aréně");
        System.out.printf("Dnes se utkají %s s %s! %n%n", bojovnikA,bojovnikB);
        //prohození bojovníků
        boolean zacinaBojovnikB = (kostka.hod() <= kostka.vratPocetSten() / 2);
        if (zacinaBojovnikB) {
            bojovnikA = this.bojovnikB;
            bojovnikB = this.bojovnikA;
        }
        System.out.printf("Začínat bude bojovník %s! %nZápas může začít...%n", bojovnikA);
      
        // cyklus s bojem
        while (bojovnikA.jeZivy() && bojovnikB.jeZivy()) {
            bojovnikA.utoc(bojovnikB);
            vykresli();
            vypisZpravu(bojovnikA.vratPosledniZpravu()); //zpráva o útoku
            vypisZpravu(bojovnikB.vratPosledniZpravu()); //zpráva o obrně
            bojovnikB.utoc(bojovnikA);
            vykresli();
            vypisZpravu(bojovnikB.vratPosledniZpravu()); //zpráva o útoku
            vypisZpravu(bojovnikA.vratPosledniZpravu());
            System.out.println();
            }
    }
}
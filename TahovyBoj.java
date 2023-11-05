/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package cz.itnetwork.tahovyboj;
import java.util.Scanner;
/**
 *
 * @author Martin
 */
public class TahovyBoj {

    public static void main(String[] args) {

        //vytvoření kostek
        Kostka kostka = new Kostka(10);
        Bojovnik zalgoren = new Bojovnik("Zalgoren", 100, 20, 10, kostka);
        Bojovnik gandalf = new Mag("Gandalf", 60, 15, 15, kostka, 30, 45);
        Arena arena = new Arena(zalgoren, gandalf, kostka);
        //zápas
        arena.zapas();
        
    }
}

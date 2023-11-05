/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.tahovyboj;
import java.util.Random;
/**
 *
 * @author Martin
 */
/**
* Třída reprezentuje hrací kostku
*/
public class Kostka {
    /**
     * Generátor náhodnách čísel
     */
    private Random random;
    /**
     * počet stěn kostky
     */
    private int pocetSten;
    
    public Kostka() {
        pocetSten = 6;
        random = new Random();
    }
    
    public Kostka(int pocetSten) {
    this.pocetSten = pocetSten;
    random = new Random();
    }
    /**
     * Vrátí počet stěn hrací kostky
     * @return Počet stěn hrací kostky
     */
    public int vratPocetSten() {
        return pocetSten;
    }
    public int hod() {
        return random.nextInt(pocetSten) + 1;
    }
        /**
     * Vrací textovou reprezentaci kostky
     * @return Textová reprezentace kostky
     */
    @Override
    public String toString() {
        return String.format("Kostka s %s stěnami", pocetSten);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.tahovyboj;

/**
 *
 * @author Martin
 */
class Mag extends Bojovnik {

    private int mana;
    private int maximalniMana;
    private int magickyUtok;

    public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int magickyUtok) {
        super(jmeno, zivot, utok, obrana, kostka);
        this.mana = mana;
        this.maximalniMana = mana;
        this.magickyUtok = magickyUtok;
    }

        @Override
        public void utoc(Bojovnik souper) {
            int uder = 0;
            // Mana není naplněna
            if (mana < maximalniMana) {
                mana+=10;
                if (mana > maximalniMana) {
                    mana = maximalniMana;
                }
                uder = utok + kostka.hod();
                nastavZpravu(String.format("%s útočí s úderem za %s hp", jmeno, uder));
            } else { //magický útok
                uder = magickyUtok +kostka.hod();
                nastavZpravu(String.format("%s použil magii za %s hp", jmeno, uder));
                souper.branSe(uder);
                mana = 0;
            }
        }
        
        public String grafickaMana() {
            return grafickyUkazatel(mana, maximalniMana);
        }
}

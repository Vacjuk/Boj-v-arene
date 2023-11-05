/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.tahovyboj;

/**
 *
 * @author Martin
 */
public class Bojovnik {

    /**
     * jméno bojovníka
     */
    protected String jmeno;
    /**
     * život v hp
     */
    protected int zivot;
    /**
     * maximální zdraví
     */
    protected int maximalniZivot;
    /**
     * útok v hp
     */
    protected int utok;
    /**
     * obrana v hp
     */
    protected int obrana;
    /**
     * instance hrací kostky
     */
    protected Kostka kostka;
    /**
     * poslední zpráva
     */
    private String zprava;

    public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka) {
        this.jmeno = jmeno;
        this.zivot = zivot;
        this.maximalniZivot = zivot;
        this.utok = utok;
        this.obrana = obrana;
        this.kostka = kostka;
    }

    public boolean jeZivy() {
        return (zivot > 0);

    }

    public String grafickyUkazatel(int aktualni, int maximalni) {
        String grafickyZivot = "[";
        int celkem = 20;
        double pocetDilku = Math.round(((double) zivot / maximalniZivot) * celkem);
        if ((pocetDilku == 0) && (jeZivy())) {
            pocetDilku = 1;
        }
        for (int i = 0; i < pocetDilku; i++) {
            grafickyZivot += "#";
        }
        for (int i = 0; i < celkem - pocetDilku; i++) {
            grafickyZivot += " ";
        }
        grafickyZivot += "]";
        return grafickyZivot;
    }
    public String grafickyZivot() {
        return grafickyUkazatel(zivot, maximalniZivot);
    }

    public void utoc(Bojovnik souper) {
        int uder = utok + kostka.hod();
        nastavZpravu(String.format("%s útočí s úderem za %s hp", jmeno, uder));
        souper.branSe(uder);
    }

    public void branSe(int uder) {
        int zraneni = uder - (obrana + kostka.hod());
        if (zraneni > 0) {
            zivot -= zraneni;
            zprava = String.format("%s utrpěl poškození %s hp", jmeno, zraneni);
            if (zivot <= 0) {
                zivot = 0;
                zprava += " a zemřel";
            }
        } else {
            zprava = String.format("%s odrazil útok", jmeno);
        }
        nastavZpravu(zprava);
    }

    protected void nastavZpravu(String zprava) {
        this.zprava = zprava;
    }

    public String vratPosledniZpravu() {
        return zprava;
    }
        @Override
    public String toString() {
        return jmeno;
    }
}

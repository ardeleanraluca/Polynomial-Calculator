package assignment1_polinoame;

import java.util.ArrayList;
import java.util.List;

public class Monom {
    private float coeficient;
    private int putere;

    public Monom(float coeficient, int putere) {
        this.coeficient = coeficient;
        this.putere = putere;
    }

    public Monom() {
        this(0, 0);
    }

    public float getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(float coeficient) {
        this.coeficient = coeficient;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public List<String> afisare() {
        List<String> monom = new ArrayList<>();
        String s = "";
        int ok = 0;

        String coef = "";

        if (coeficient == 0) {
            monom.add(Integer.toString(ok));
            monom.add(s);
            return monom;
        }

        if (coeficient == (int) coeficient)
            coef += (int) coeficient;
        else
            coef += coeficient;

        if (putere == 0)
            s += coef;
        else if (putere == 1) {
            if (coeficient == 1)
                s += "X";
            else if (coeficient == -1)
                s += "-X";
            else
                s += coef + "X";
        } else {
            if (coeficient == 1)
                s += "X^" + putere;
            else if (coeficient == -1)
                s += "-X^" + putere;
            else
                s += coef + "X^" + putere;
        }

        ok = 1;
        monom.add(Integer.toString(ok));
        monom.add(s);
        return monom;

    }
}

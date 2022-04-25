package assignment1_polinoame;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    private List<Monom> monoame;
    private int polinomOK;

    public Polinom() {
        monoame = new ArrayList<>();
        Monom m = new Monom();
        monoame.add(m);
    }

    public Polinom(String polinom) {
        monoame = new ArrayList<>();
        extractMonom(polinom);
        sort();
    }

    public List<Monom> getMonoame() {
        return monoame;
    }

    public void setMonoame(List<Monom> monoame) {
        this.monoame = monoame;
    }

    public int getPolinomOK() {
        return polinomOK;
    }

    public String afisare() {
        String pol = "";
        int ok = 0;
        for (Monom m : monoame) {
            String s = "";
            s += m.afisare().get(1);
            if (monoame.indexOf(m) > 0) {
                if (m.getCoeficient() > 0) {
                    pol += "+";
                }
            }

            if (Integer.parseInt(m.afisare().get(0)) == 1)
                ok = 1;

            pol += s;
        }

        if (ok == 0)
            return "0";

        if (pol.charAt(0) == '+')
            pol = pol.substring(1);

        return pol;
    }

    private void extractMonom(String polinom) {
        if (Objects.equals(polinom, "")) {
            polinomOK = 1;
            Monom monom = new Monom(0, 0);
            monoame.add(monom);
            return;
        }

        String formatMonom = "([+-]?[0-9]*)\\*?([a-zA-Z]?)\\^?([0-9]*)";
        String formatNr = "[+-]?\\d*\\.?\\d+";

        Pattern p1 = Pattern.compile(formatMonom);
        Matcher m1 = p1.matcher(polinom);

        while (!m1.hitEnd()) {
            m1.find();

            if (!m1.group(2).equals("X") && !m1.group(2).equals("")) {
                polinomOK = 0;
                return;
            }

            int coeficient;
            try {
                String coef = m1.group(1);
                if (coef.matches(formatNr)) {
                    coeficient = Integer.parseInt(coef);
                } else {
                    coeficient = Integer.parseInt(coef + "1");
                }
            } catch (Exception e) {
                coeficient = 0;
            }

            int exponent;
            try {
                String exp = m1.group(3);
                if (exp.matches(formatNr)) {
                    exponent = Integer.parseInt(exp);
                } else {
                    exponent = 1;
                }
            } catch (Exception e) {
                exponent = 0;
            }

            if (m1.group(2).equals("")) {
                exponent = 0;
            }

            Monom monom = new Monom(coeficient, exponent);
            monoame.add(monom);
        }
        polinomOK = 1;
    }

    public void sort() {
        monoame.sort((m1, m2) -> {
            if (m1.getPutere() == m2.getPutere())
                return 0;
            return m1.getPutere() > m2.getPutere() ? -1 : 1;
        });
    }
}

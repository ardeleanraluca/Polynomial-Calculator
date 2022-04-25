package assignment1_polinoame;

import java.util.ArrayList;
import java.util.List;

public class Operatii {

    public Polinom aduna_scade(Polinom p1, Polinom p2, boolean ok) {
        List<Monom> monoms = new ArrayList<Monom>();
        int i = 0, j = 0;
        Polinom pol = new Polinom();
        pol.getMonoame().remove(pol.getMonoame().get(0));
        while (i < p1.getMonoame().size() || j < p2.getMonoame().size()) {
            Monom m1, m2;
            if (i < p1.getMonoame().size())
                m1 = p1.getMonoame().get(i);
            else
                m1 = new Monom();
            if (j < p2.getMonoame().size())
                m2 = p2.getMonoame().get(j);
            else
                m2 = new Monom();
            Monom monom = new Monom();
            if (m1.getPutere() == m2.getPutere()) {
                if (ok)
                    monom.setCoeficient(m1.getCoeficient() + m2.getCoeficient());
                else
                    monom.setCoeficient(m1.getCoeficient() - m2.getCoeficient());

                monom.setPutere(m1.getPutere());
                monoms.add(monom);
                i++;
                j++;

            } else if (m1.getPutere() > m2.getPutere()) {
                monoms.add(m1);
                i++;
            } else if (m2.getPutere() > m1.getPutere()) {
                if (ok)
                    monoms.add(m2);
                else {
                    Monom m = new Monom(-m2.getCoeficient(), m2.getPutere());
                    monoms.add(m);
                }
                j++;

            }
        }
        pol.setMonoame(monoms);

        return pol;

    }

    public Polinom inmulteste(Polinom p1, Polinom p2) {
        Polinom pol = new Polinom();
        for (Monom m1 : p1.getMonoame()) {
            List<Monom> monomsPart = new ArrayList<Monom>();
            Polinom polPart = new Polinom();
            for (Monom m2 : p2.getMonoame()) {
                Monom m = new Monom(m1.getCoeficient() * m2.getCoeficient(), m1.getPutere() + m2.getPutere());
                monomsPart.add(m);
            }
            polPart.setMonoame(monomsPart);
            pol = aduna_scade(pol, polPart, true);
        }
        return pol;
    }

    public Polinom deriveaza(Polinom p) {
        Polinom pol = new Polinom();
        List<Monom> monoms = new ArrayList<Monom>();
        for (Monom m : p.getMonoame()) {
            float coeficient = m.getCoeficient() * m.getPutere();
            int putere = 0;
            if (m.getPutere() > 1)
                putere = m.getPutere() - 1;
            Monom monom = new Monom(coeficient, putere);
            monoms.add(monom);
        }
        pol.setMonoame(monoms);
        return pol;

    }

    public Polinom integreaza(Polinom p) {
        Polinom pol = new Polinom();
        List<Monom> monoms = new ArrayList<Monom>();
        for (Monom m : p.getMonoame()) {
            int putere = m.getPutere() + 1;
            float coeficient = m.getCoeficient() / putere;
            Monom monom = new Monom(coeficient, putere);
            monoms.add(monom);
        }
        pol.setMonoame(monoms);
        return pol;

    }

    public List<Polinom> imparte(Polinom p1, Polinom p2) {
        if (p2.getMonoame().get(0).getCoeficient() == 0) {
            System.out.println("Divizion error");
            return null;
        }

        List<Polinom> div = new ArrayList<>();

        Polinom q = new Polinom();
        Polinom r = p1;


        while (degree_coef(r).getCoeficient() != 0 && degree_coef(r).getPutere() >= degree_coef(p2).getPutere()) {
            Polinom t = new Polinom();
            Monom m = new Monom(degree_coef(r).getCoeficient() / degree_coef(p2).getCoeficient(),
                    degree_coef(r).getPutere() - degree_coef(p2).getPutere());
            List<Monom> monoms = new ArrayList<>();
            monoms.add(m);
            t.setMonoame(monoms);

            q = aduna_scade(q, t, true);
            Polinom p = inmulteste(t, p2);
            r = aduna_scade(r, p, false);

        }

        div.add(q);
        div.add(r);
        return div;
    }

    private Monom degree_coef(Polinom p) {
        for (Monom m : p.getMonoame())
            if (m.getCoeficient() != 0)
                return m;

        return new Monom();
    }


}
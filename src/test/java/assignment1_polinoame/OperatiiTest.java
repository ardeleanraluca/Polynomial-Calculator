package assignment1_polinoame;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OperatiiTest {
    private final Operatii op = new Operatii();
    private final String p1 = "X^3-2X^2+6X-5";
    private final String p2 = "X+1";
    private final String p3 = "5X+1";
    private final String p4 = "9";
    private final String p5 = "X";

    private final Polinom polinom1 = new Polinom(p1);
    private final Polinom polinom2 = new Polinom(p2);
    private final Polinom polinom3 = new Polinom(p3);
    private final Polinom polinom4 = new Polinom(p4);
    private final Polinom polinom5 = new Polinom(p5);

    @Test
    void aduna_scade() {
        assertAll(() -> assertEquals("X^3-2X^2+7X-4", op.aduna_scade(polinom1, polinom2, true).afisare()),
                () -> assertEquals("X+10", op.aduna_scade(polinom2, polinom4, true).afisare()),
                () -> assertEquals("-4X", op.aduna_scade(polinom2, polinom3, false).afisare()),
                () -> assertEquals("0", op.aduna_scade(polinom3, polinom3, false).afisare())
        );
    }

    @Test
    void inmulteste() {
        assertAll(() -> assertEquals("45X+9", op.inmulteste(polinom3, polinom4).afisare()),
                () -> assertEquals("25X^2+10X+1", op.inmulteste(polinom3, polinom3).afisare()),
                () -> assertEquals("X^4-X^3+4X^2+X-5", op.inmulteste(polinom1, polinom2).afisare())
        );

    }

    @Test
    void deriveaza() {
        assertAll(() -> assertEquals("0", op.deriveaza(polinom4).afisare()),
                () -> assertEquals("1", op.deriveaza(polinom2).afisare()),
                () -> assertEquals("5", op.deriveaza(polinom3).afisare()),
                () -> assertEquals("3X^2-4X+6", op.deriveaza(polinom1).afisare())
        );
    }

    @Test
    void integreaza() {
        assertAll(() -> assertEquals("9X+C", op.integreaza(polinom4).afisare() + "+C"),
                () -> assertEquals("2.5X^2+X+C", op.integreaza(polinom3).afisare() + "+C"),
                () -> assertEquals("0.25X^4-0.6666667X^3+3X^2-5X+C", op.integreaza(polinom1).afisare() + "+C")
        );
    }

    @Test
    void imparte() {
        assertAll(() -> assertEquals("X^2+7" + "\n" + "0", op.imparte(new Polinom("X^3+7X"), polinom5).get(0).afisare() + "\n"
                        + op.imparte(new Polinom("X^3+7X"), polinom5).get(1).afisare()),
                () -> assertEquals("0" + "\n" + "9", op.imparte(polinom4, polinom3).get(0).afisare() + "\n"
                        + op.imparte(polinom4, polinom3).get(1).afisare()),
                () -> assertEquals("X^2-3X+9" + "\n" + "-14", op.imparte(polinom1, polinom2).get(0).afisare() + "\n"
                        + op.imparte(polinom1, polinom2).get(1).afisare())
        );
    }
}
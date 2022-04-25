package assignment1_polinoame;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Objects;

public class Controller {
    private int ok;
    private Operatii op = new Operatii();
    private Polinom polinom1;
    private Polinom polinom2;


    @FXML
    private TextField pol1;

    @FXML
    private TextField pol2;

    @FXML
    private TextArea result;


    @FXML
    private int extractPol() {
        int ok = 1;
        if (Objects.equals(pol1.getText(), ""))
            polinom1 = new Polinom();
        else {
            polinom1 = new Polinom(pol1.getText());
            if (polinom1.getPolinomOK() == 0) {
                result.setText("Eroare introducere polinom1" + "\n");
                //pol1.setText("");
                ok = 0;
            }
        }

        if (Objects.equals(pol2.getText(), ""))
            polinom2 = new Polinom();
        else {
            polinom2 = new Polinom(pol2.getText());
            if (polinom2.getPolinomOK() == 0) {
                result.setText(result.getText() + "Eroare introducere polinom2" + "\n");
                //pol2.setText("");
                ok = 0;
            }
        }

        return ok;
    }

    @FXML
    protected void setOk1() {
        ok = 0;
    }

    @FXML
    protected void setOk2() {
        ok = 1;
    }

    @FXML
    protected void Button0() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "0");
        else
            pol2.setText(pol2.getText() + "0");
    }

    @FXML
    protected void Button1() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "1");
        else
            pol2.setText(pol2.getText() + "1");
    }

    @FXML
    protected void Button2() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "2");
        else
            pol2.setText(pol2.getText() + "2");
    }

    @FXML
    protected void Button3() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "3");
        else
            pol2.setText(pol2.getText() + "3");
    }

    @FXML
    protected void Button4() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "4");
        else
            pol2.setText(pol2.getText() + "4");
    }

    @FXML
    protected void Button5() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "5");
        else
            pol2.setText(pol2.getText() + "5");
    }

    @FXML
    protected void Button6() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "6");
        else
            pol2.setText(pol2.getText() + "6");
    }

    @FXML
    protected void Button7() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "7");
        else
            pol2.setText(pol2.getText() + "7");
    }

    @FXML
    protected void Button8() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "8");
        else
            pol2.setText(pol2.getText() + "8");
    }

    @FXML
    protected void Button9() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "9");
        else
            pol2.setText(pol2.getText() + "9");
    }

    @FXML
    protected void ButtonPct() {
        if (ok == 0)
            pol1.setText(pol1.getText() + ".");
        else
            pol2.setText(pol2.getText() + ".");
    }

    @FXML
    protected void ButtonPow() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "^");
        else
            pol2.setText(pol2.getText() + "^");
    }

    @FXML
    protected void ButtonMul() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "*");
        else
            pol2.setText(pol2.getText() + "*");
    }

    @FXML
    protected void ButtonSub() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "-");
        else
            pol2.setText(pol2.getText() + "-");
    }

    @FXML
    protected void ButtonPlus() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "+");
        else
            pol2.setText(pol2.getText() + "+");
    }

    @FXML
    protected void ButtonX() {
        if (ok == 0)
            pol1.setText(pol1.getText() + "X");
        else
            pol2.setText(pol2.getText() + "X");
    }

    @FXML
    protected void ButtonDel() {
        if (ok == 0) {
            if (!Objects.equals(pol1.getText(), "") && pol1.getText().length() > 1) {
                StringBuffer sb = new StringBuffer(pol1.getText());
                sb.deleteCharAt(sb.length() - 1);
                pol1.setText(sb.toString());
            } else
                pol1.setText("");
        } else {
            if (!Objects.equals(pol1.getText(), "") && pol2.getText().length() > 1) {
                StringBuffer sb = new StringBuffer(pol2.getText());
                sb.deleteCharAt(sb.length() - 1);
                pol2.setText(sb.toString());
            } else pol2.setText("");
        }

    }

    @FXML
    protected void ButtonAdd() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;

        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            result.setText((op.aduna_scade(polinom1, polinom2, true).afisare()));
        } else
            result.setText("Niciun polinom introdus");

    }

    @FXML
    protected void ButtonSubstract() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;
        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            result.setText((op.aduna_scade(polinom1, polinom2, false).afisare()));
        } else
            result.setText("Niciun polinom introdus");
    }

    @FXML
    protected void ButtonMultiply() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;
        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            result.setText((op.inmulteste(polinom1, polinom2).afisare()));
        } else
            result.setText("Niciun polinom introdus");
    }

    @FXML
    protected void ButtonDivide() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;
        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            if (Objects.equals(pol2.getText(), "") || pol2.getText().equals("0")) {
                result.setText("ERROR: DIVISON BY 0");
                return;
            }
            result.setText("Quotient: " + (op.imparte(polinom1, polinom2).get(0).afisare()) + "\nRemainder: " + (op.imparte(polinom1, polinom2).get(1).afisare()));
        } else
            result.setText("Niciun polinom introdus");
    }

    @FXML
    protected void ButtonDerivative() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;
        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            if (!Objects.equals(pol1.getText(), ""))
                result.setText("First polynomial' : " + (op.deriveaza(polinom1).afisare()) + "\n");
            if (!Objects.equals(pol2.getText(), ""))
                result.setText(result.getText() + "Second polynomial' : " + (op.deriveaza(polinom2).afisare()));
        } else
            result.setText("Niciun polinom introdus");
    }

    @FXML
    protected void ButtonIntegral() {
        int verifPol = extractPol();
        if (verifPol == 0)
            return;
        if (!Objects.equals(pol1.getText(), "") || !Objects.equals(pol2.getText(), "")) {
            result.setText("");
            if (!Objects.equals(pol1.getText(), ""))
                result.setText("First integrated polynomial : " + (op.integreaza(polinom1).afisare()) + "+C\n");
            if (!Objects.equals(pol2.getText(), ""))
                result.setText(result.getText() + "Second integrated polynomial : " + (op.integreaza(polinom2).afisare()) + "+C");
        } else
            result.setText("Niciun polinom introdus");
    }

}
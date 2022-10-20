package gymmet;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Huvudprogram {

    Listhantering l = new Listhantering();

    public Huvudprogram() {
        Path pathLäsFrån = Paths.get("src/gymmet/kunder.txt");
        List<Kund> kunderLista = l.skapaKundLista(pathLäsFrån);
        File filAttSkrivaTill = new File("src/gymmet/tränandeKunder.txt");
        Kund kund = l.hittaKunden(kunderLista, false, "fakeInput");
        if (kund == null) {
            JOptionPane.showMessageDialog(null, "Personen finns inte i registret");
        } else {
            try (PrintWriter writer = new PrintWriter(new FileWriter(filAttSkrivaTill, true))) {
                if (kund.isAktivMedlem()) {
                    JOptionPane.showMessageDialog(null,
                            kund.getNamn() + " är en betalande medlem");
                    kund.utskriftTillFil(writer);
                } else {
                    JOptionPane.showMessageDialog(null,
                            kund.getNamn() + " är en före detta medlem");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Något blev fel, försök igen");
            }
        }
    }

    public static void main(String[] args) {
        Huvudprogram program = new Huvudprogram();
    }

}


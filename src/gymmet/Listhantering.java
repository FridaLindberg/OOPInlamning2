package gymmet;

import javax.swing.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Listhantering {

    public List<Kund> skapaKundLista(Path path) {
        List<Kund> kunderLista = new ArrayList<>();
        String förstaRad;
        String andraRad;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((förstaRad = reader.readLine()) != null) {
                String[] array = förstaRad.split(",");
                Kund kund = new Kund();
                kund.setPersonNummer(array[0].trim());
                kund.setNamn(array[1].trim());
                andraRad = reader.readLine();
                kund.setBetaladeAvgiftSenast(LocalDate.parse(andraRad.trim()));
                kund.setAktivMedlem();
                kunderLista.add(kund);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Det blev fel");
        }
        return kunderLista;
    }

    public Kund hittaKunden(List<Kund> kunderLista, boolean ärTest, String testInput) {
        String input = "";
        if (ärTest) {
            input = testInput;
        } else {
            try {
                input = JOptionPane.showInputDialog("Skriv namn eller personnummer").trim();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Avbröt programmet");
                System.exit(0);
            }
        }
        for (Kund kund : kunderLista) {
            if (kund.getNamn().equalsIgnoreCase(input) || kund.getPersonNummer().equalsIgnoreCase(input)) {
                return kund;
            }
        }
        return null;
    }



}


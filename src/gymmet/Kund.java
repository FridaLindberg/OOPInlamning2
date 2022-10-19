package gymmet;

import java.io.PrintWriter;
import java.time.LocalDate;

public class Kund {
    private String personNummer;
    private String namn;
    private LocalDate betaladeAvgiftSenast;
    private boolean aktivMedlem;

    public Kund() {
    }

    public Kund(String personNummer, String namn, LocalDate datum) {
        this.personNummer = personNummer;
        this.namn = namn;
        this.betaladeAvgiftSenast = datum;
    }
    public void utskriftTillFil(PrintWriter writer) {
        writer.println("Namn: " + getNamn() +
                "\tPersonnummer: " + getPersonNummer() + "\tTränade denna dag: " + LocalDate.now());
    }
    public void setAktivMedlem() {
        LocalDate idag = LocalDate.now();
        if (getBetaladeAvgiftSenast().isAfter(idag.minusYears(1))) {
            this.aktivMedlem = true;
        } else {
            this.aktivMedlem = false;
        }
    }

    public boolean isAktivMedlem() {
        return aktivMedlem;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public void setPersonNummer(String personNummer) {
        this.personNummer = personNummer;
    }

    public void setBetaladeAvgiftSenast(LocalDate betaladeAvgiftSenast) {
        this.betaladeAvgiftSenast = betaladeAvgiftSenast;
    }

    public String getNamn() {
        return namn;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public LocalDate getBetaladeAvgiftSenast() {
        return betaladeAvgiftSenast;
    }
}

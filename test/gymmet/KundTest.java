package gymmet;

import org.testng.annotations.Test;

import java.time.LocalDate;

public class KundTest {

    @Test
    public void aktivMedlemTest() {
        LocalDate datum1 = LocalDate.parse("2020-03-12");
        LocalDate datum2 = LocalDate.now();
        Kund kund1 = new Kund("031020", "Frida", datum1);
        Kund kund2 = new Kund("993087", "Kalle", datum2);
        kund1.setAktivMedlem();
        kund2.setAktivMedlem();
        assert (!kund1.isAktivMedlem());
        assert (kund2.isAktivMedlem());
    }

    @Test
    public void utskriftTillFilTest(){
        Kund testKund = new Kund("0979879888", "Test Person", LocalDate.parse("2022-04-16"));
        assert(testKund.getNamn().equals("Test Person"));
        assert(testKund.getPersonNummer().equals("0979879888"));
    }
}

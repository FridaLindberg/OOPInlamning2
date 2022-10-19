package gymmet;

import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ListhanteringTest {

    Listhantering test = new Listhantering();

    @Test
    public void skapaPersonListaTest() {
        Path testPath = Paths.get("test/gymmet/kunderTest.txt");
        List<Kund> kunderTest = test.skapaKundLista(testPath);
        assert (kunderTest.size() == 14);
        assert (kunderTest.get(0).getNamn().equals("Alhambra Aromes"));
        assert (kunderTest.get(0).getBetaladeAvgiftSenast().toString().equals("2022-07-01"));
        assert (kunderTest.get(7).getNamn().equals("Hilmer Heur"));
    }

    @Test
    public void hittaKundenTest() {
        boolean ärTest = true;
        Path testPath = Paths.get("test/gymmet/kunderTest.txt");
        List<Kund> testLista = test.skapaKundLista(testPath);
        String rättNamn = "Jicky Juul";
        String felNamn = "Frida Lindberg";
        String rättPersNr = "7512166544";
        String felPersNr = "7804165767";
        assert (test.hittaKunden(testLista, ärTest, rättNamn).getNamn().equals("Jicky Juul"));
        assert (test.hittaKunden(testLista, ärTest, felNamn) == null);
        assert (test.hittaKunden(testLista, ärTest, rättPersNr).getNamn().equals("Greger Ganache"));
        assert (test.hittaKunden(testLista, ärTest, felPersNr) == null);
    }


}


import static org.junit.jupiter.api.Assertions.*;

import ba.unsa.etf.rpr.Korisnik;
import ba.unsa.etf.rpr.KorisnikModel;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestModel {

    private KorisnikModel korisnikModel;

    @BeforeEach
    void setUp() {
        korisnikModel = new KorisnikModel();
        korisnikModel.napuni();
    }

    @Test
    void getKorisnici_ReturnsCorrectList() {
        ObservableList<Korisnik> korisnici = korisnikModel.getKorisnici();
        assertNotNull(korisnici);
        assertEquals(3, korisnici.size());
    }

    @Test
    void getTrenutniKorisnik_ReturnsNotNull() {
        assertNotNull(korisnikModel.getTrenutniKorisnik());
    }

    @Test
    void setTrenutniKorisnik_SetsCorrectUser() {
        Korisnik korisnik = new Korisnik("Test", "Testić", "test@test.com", "test123", "password");
        korisnikModel.setTrenutniKorisnik(korisnik);
        assertEquals(korisnik, korisnikModel.getTrenutniKorisnik().get());
    }

    @Test
    void dodajPraznogKorisnika_AddsEmptyUser() {
        int oldSize = korisnikModel.getKorisnici().size();
        korisnikModel.dodajPraznogKorisnika();
        int newSize = korisnikModel.getKorisnici().size();

        assertEquals(oldSize + 1, newSize);
        assertEquals("", korisnikModel.getTrenutniKorisnik().get().getIme());
    }
}

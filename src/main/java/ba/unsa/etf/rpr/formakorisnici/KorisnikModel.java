package ba.unsa.etf.rpr.formakorisnici;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisnikModel {
    private ObservableList<Korisnik> korisnici=FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutni= new SimpleObjectProperty();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }

    public SimpleObjectProperty<Korisnik> getTrenutniKorisnik() {
        return trenutni;
    }

    public void setTrenutniKorisnik(Korisnik korisnik) {
        trenutni.set(korisnik);
    }

    public void napuni() {
        korisnici.add(new Korisnik("Mina", "Duranovic", "minad@email.com", "mduranovic2", "rpr123"));
        korisnici.add(new Korisnik("Sara", "Dautbegovic", "sarad@gmail.com", "sdautbegovic1", "r111"));
        korisnici.add(new Korisnik("Ajna", "Duranovic", "ajnad@email.com", "aduranovic2", "aaaaaaaaaaa"));

        trenutni.set(korisnici.get(0));
    }

    public void dodajPraznogKorisnika() {
        Korisnik noviKorisnik = new Korisnik("", "", "", "", "");
        korisnici.add(noviKorisnik);
        setTrenutniKorisnik(noviKorisnik);
    }
}

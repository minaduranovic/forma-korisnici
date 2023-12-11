package ba.unsa.etf.rpr.formakorisnici;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;

public class Controller {
    public ListView listKorisnici;
    public TextField fldIme;

    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public TextField fldLozinka;
    public Button dodajBtn;
    public Button krajBtn;

    private KorisnikModel model;

    @FXML
    public void initialize() {
        model = new KorisnikModel();
        model.napuni();

        listKorisnici.setItems(model.getKorisnici());

        if (model.getTrenutniKorisnik().get() != null) {
            Korisnik trenutniKorisnik = model.getTrenutniKorisnik().get();
            fldIme.textProperty().bindBidirectional(trenutniKorisnik.imeProperty());
            fldPrezime.textProperty().bindBidirectional(trenutniKorisnik.prezimeProperty());
            fldEmail.textProperty().bindBidirectional(trenutniKorisnik.emailProperty());
            fldKorisnickoIme.textProperty().bindBidirectional(trenutniKorisnik.korisnickoImeProperty());
            fldLozinka.textProperty().bindBidirectional(trenutniKorisnik.lozinkaProperty());
        }
    }

    private void dodajKorisnika() {
        model.dodajPraznogKorisnika();
    }

    private void zavrsiProgram() {
        System.exit(0);
    }

    }




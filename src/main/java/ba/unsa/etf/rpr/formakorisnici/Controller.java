package ba.unsa.etf.rpr.formakorisnici;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class Controller {
    public ListView listKorisnici= new ListView();
    public TextField fldIme;

    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public PasswordField fldLozinka;
    public Button dodajBtn;
    public Button krajBtn;

    private KorisnikModel model= new KorisnikModel();


    @FXML
    public void initialize() {
        model.napuni();
        listKorisnici.setItems(model.getKorisnici());

        listKorisnici.getSelectionModel().selectedItemProperty().addListener((obs, oldKorisnik, newKorisnik) -> {
            if (newKorisnik != null) {
                fldIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().get().imeProperty());
                fldPrezime.textProperty().unbindBidirectional(model.getTrenutniKorisnik().get().prezimeProperty());
                fldEmail.textProperty().unbindBidirectional(model.getTrenutniKorisnik().get().emailProperty());
                fldKorisnickoIme.textProperty().unbindBidirectional(model.getTrenutniKorisnik().get().korisnickoImeProperty());
                fldLozinka.textProperty().unbindBidirectional(model.getTrenutniKorisnik().get().lozinkaProperty());

                model.setTrenutniKorisnik((Korisnik) newKorisnik);

                fldIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().get().imeProperty());
                fldPrezime.textProperty().bindBidirectional(model.getTrenutniKorisnik().get().prezimeProperty());
                fldEmail.textProperty().bindBidirectional(model.getTrenutniKorisnik().get().emailProperty());
                fldKorisnickoIme.textProperty().bindBidirectional(model.getTrenutniKorisnik().get().korisnickoImeProperty());
                fldLozinka.textProperty().bindBidirectional(model.getTrenutniKorisnik().get().lozinkaProperty());
                listKorisnici.refresh();
            }
        });
    }
    private void dodajKorisnika() {
        model.dodajPraznogKorisnika();
    }

    private void zavrsiProgram() {
        System.exit(0);
    }

    }




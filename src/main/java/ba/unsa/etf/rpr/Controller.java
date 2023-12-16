package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    @FXML
    private void dodajBtn(ActionEvent event){
        model.dodajPraznogKorisnika();
        listKorisnici.getSelectionModel().selectLast();

    }

    @FXML
    private void krajBtn(ActionEvent event) {
        System.exit(0);
    }

    }




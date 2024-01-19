package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Controller {
    public ListView<Korisnik> listKorisnici = new ListView();
    public TextField fldIme;

    public TextField fldPrezime;
    public TextField fldEmail;
    public TextField fldKorisnickoIme;
    public PasswordField fldLozinka;
    public Button dodajBtn;
    public Button krajBtn;

    private KorisnikModel model = new KorisnikModel();


    @FXML
    public void initialize() {
        model.napuni();
        listKorisnici.setItems(model.getKorisnici());
        fldKorisnickoIme.textProperty().addListener((observableValue) -> listKorisnici.refresh());


        listKorisnici.getSelectionModel().selectedItemProperty().addListener(((observableValue, oldUser, newUser) -> {
            if (oldUser != null) {
                fldIme.textProperty().unbindBidirectional(oldUser.imeProperty());
                fldPrezime.textProperty().unbindBidirectional(oldUser.prezimeProperty());
                fldEmail.textProperty().unbindBidirectional(oldUser.emailProperty());
                fldKorisnickoIme.textProperty().unbindBidirectional(oldUser.korisnickoImeProperty());
                fldLozinka.textProperty().unbindBidirectional(oldUser.lozinkaProperty());
            }

            model.setTrenutniKorisnik(newUser);

            if (newUser == null) {
                fldIme.setText("");
                fldPrezime.setText("");
                fldEmail.setText("");
                fldKorisnickoIme.setText("");
                fldLozinka.setText("");
            } else {
                fldIme.textProperty().bindBidirectional(newUser.imeProperty());
                fldPrezime.textProperty().bindBidirectional(newUser.prezimeProperty());
                fldEmail.textProperty().bindBidirectional(newUser.emailProperty());
                fldKorisnickoIme.textProperty().bindBidirectional(newUser.korisnickoImeProperty());
                fldLozinka.textProperty().bindBidirectional(newUser.lozinkaProperty());
            }

            listKorisnici.refresh();

        }));
        listKorisnici.getSelectionModel().selectFirst();
    }

    @FXML
    private void dodajBtn(ActionEvent event) {
        model.dodajPraznogKorisnika();
        listKorisnici.getSelectionModel().selectLast();

    }

    @FXML
    private void krajBtn(ActionEvent event) {
        System.exit(0);
    }

    public void handleMouseClick(MouseEvent mouseEvent) {
        model.setTrenutniKorisnik((Korisnik) listKorisnici.getSelectionModel().getSelectedItems());
    }
}





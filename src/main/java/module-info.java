module ba.unsa.etf.rpr.formakorisnici {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens ba.unsa.etf.rpr.formakorisnici to javafx.fxml;
    exports ba.unsa.etf.rpr.formakorisnici;
}
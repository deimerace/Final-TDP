package Final;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private ImageView arrowPersona;
    @FXML private ImageView arrowLocalizacion;
    @FXML private ImageView arrowSintomas;

    @FXML private AnchorPane panePersona;
    @FXML private AnchorPane paneLocalizacion;
    @FXML private AnchorPane paneSintomas;

    @FXML private JFXComboBox<String> comboBoxTipoID;
    @FXML private JFXComboBox<String> comboBoxEstadoCivil;

    @FXML private JFXRadioButton masculinoRadioButton;
    @FXML private JFXRadioButton femeninoRadioButton;

    @FXML private JFXTextField nombreText;
    @FXML private JFXTextField apellidosText;
    @FXML private JFXTextField IDText;
    @FXML private JFXTextField ciudadText;
    @FXML private JFXTextField direccionText;
    @FXML private JFXTextField telefonoText;
    @FXML private JFXTextField celularText;
    @FXML private JFXTextField tempMedidaText;



    ObservableList<String> comboIDContent =
            FXCollections.observableArrayList(
                    "C.C.",
                    "C.E.",
                    "T.I.",
                    "R.C."
            );

    ObservableList<String> comboEstCivContent =
            FXCollections.observableArrayList(
                    "Casado",
                    "Soltero",
                    "Unión Libre"
            );


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxTipoID.setItems(comboIDContent);
        comboBoxEstadoCivil.setItems(comboEstCivContent);

        ToggleGroup group= new ToggleGroup();
        masculinoRadioButton.setToggleGroup(group);
        femeninoRadioButton.setToggleGroup(group);
    }

    public void onExitButtonClicked(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }

    public void onPersona(MouseEvent event){
        panePersona.setVisible(true);
        arrowPersona.setVisible(true);

        paneLocalizacion.setVisible(false);
        arrowLocalizacion.setVisible(false);

        paneSintomas.setVisible(false);
        arrowSintomas.setVisible(false);
    }

    public void onLocalizacion(MouseEvent event){
        panePersona.setVisible(false);
        arrowPersona.setVisible(false);

        paneLocalizacion.setVisible(true);
        arrowLocalizacion.setVisible(true);

        paneSintomas.setVisible(false);
        arrowSintomas.setVisible(false);

    }

    public void onSintomas(MouseEvent event){
        panePersona.setVisible(false);
        arrowPersona.setVisible(false);

        paneLocalizacion.setVisible(false);
        arrowLocalizacion.setVisible(false);

        paneSintomas.setVisible(true);
        arrowSintomas.setVisible(true);

    }

    public void onGuardar(MouseEvent event){
        if (nombreText.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar registro");
            alert.setContentText("Existen campos vacíos.");
            alert.showAndWait();
        }
    }

    public void onMostrarRegistro(MouseEvent event){

    }




}

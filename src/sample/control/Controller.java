package sample.control;

import com.jfoenix.controls.*;
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
import sample.model.Visitante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ArrayList<Visitante> registroVisitantes = new ArrayList<Visitante>();

    @FXML private ImageView arrowPersona;
    @FXML private ImageView arrowLocalizacion;
    @FXML private ImageView arrowSintomas;

    @FXML private AnchorPane panePersona;
    @FXML private AnchorPane paneLocalizacion;
    @FXML private AnchorPane paneSintomas;
    @FXML private AnchorPane paneRegistro;

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

    @FXML private JFXCheckBox checBoxGusto;
    @FXML private JFXCheckBox checBoxGarganta;
    @FXML private JFXCheckBox checBoxMalestar;
    @FXML private JFXCheckBox checBoxDiarrea;
    @FXML private JFXCheckBox checBoxFiebre;
    @FXML private JFXCheckBox checBoxTos;
    @FXML private JFXCheckBox checBoxErupcion;
    @FXML private JFXCheckBox checBoxConjuntivitis;

    @FXML private JFXTextArea TextAreaRegistro;




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

        paneRegistro.setVisible(false);
    }

    public void onLocalizacion(MouseEvent event){
        panePersona.setVisible(false);
        arrowPersona.setVisible(false);

        paneLocalizacion.setVisible(true);
        arrowLocalizacion.setVisible(true);

        paneSintomas.setVisible(false);
        arrowSintomas.setVisible(false);

        paneRegistro.setVisible(false);
    }

    public void onSintomas(MouseEvent event){
        panePersona.setVisible(false);
        arrowPersona.setVisible(false);

        paneLocalizacion.setVisible(false);
        arrowLocalizacion.setVisible(false);

        paneSintomas.setVisible(true);
        arrowSintomas.setVisible(true);

        paneRegistro.setVisible(false);
    }

    public void onGuardar(MouseEvent event){
        if ((nombreText.getText().isEmpty()) || (apellidosText.getText().isEmpty()) ||
                (IDText.getText().isEmpty()) || (ciudadText.getText().isEmpty()) ||
                (direccionText.getText().isEmpty()) || (telefonoText.getText().isEmpty()) ||
                (celularText.getText().isEmpty()) || (tempMedidaText.getText().isEmpty())){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar registro");
            alert.setContentText("Existen campos vacíos.");
            alert.showAndWait();
        }
        else{
            char valorGenero;
            if (masculinoRadioButton.isDisable()){
                valorGenero = 'M';
            }
            else{
                valorGenero = 'F';
            }
            LocalDateTime fechaYHora = LocalDateTime.now();
            Visitante temporal = new Visitante(nombreText.getText(),
                    apellidosText.getText(), IDText.getText(), comboBoxTipoID.getValue(),
                    comboBoxEstadoCivil.getValue(), valorGenero, ciudadText.getText(),
                    direccionText.getText(), telefonoText.getText(), celularText.getText(),
                    (checBoxGusto.isSelected()), (checBoxGarganta.isSelected()), (checBoxMalestar.isSelected()),
                    (checBoxDiarrea.isSelected()), (checBoxFiebre.isSelected()), (checBoxTos.isSelected()),
                    (checBoxErupcion.isSelected()), (checBoxConjuntivitis.isSelected()), tempMedidaText.getText(), fechaYHora);
            System.out.println(temporal.toString());
            registroVisitantes.add(temporal);

            try{
                ObjectOutputStream escribiendoEnArchivo = new ObjectOutputStream(new FileOutputStream("src/sample/archivo/datos.txt"));
                escribiendoEnArchivo.writeObject(registroVisitantes);
                escribiendoEnArchivo.close();

            }catch (Exception e){

            }

            reiniciarRegistro();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Guardar registro");
            alert.setContentText("Registro generado con éxito.");
            alert.showAndWait();

        }

    }

    public void onMostrarRegistro(MouseEvent event){
        panePersona.setVisible(false);
        arrowPersona.setVisible(false);

        paneLocalizacion.setVisible(false);
        arrowLocalizacion.setVisible(false);

        paneSintomas.setVisible(false);
        arrowSintomas.setVisible(false);

        paneRegistro.setVisible(true);

        String mensaje = "";
        System.out.println("click en mostrar");
        try{
            ObjectInputStream leyendoEnArchivo = new ObjectInputStream(new FileInputStream("src/sample/archivo/datos.txt"));
            ArrayList<Visitante> registroVisitantesLeido = (ArrayList<Visitante>) leyendoEnArchivo.readObject();
            leyendoEnArchivo.close();
            for (Visitante e : registroVisitantesLeido){
                mensaje = mensaje + e.toString();
            }
            TextAreaRegistro.setText(mensaje);

        }catch (Exception e){

        }

    }

    public void reiniciarRegistro(){
        nombreText.clear();
        apellidosText.clear();
        IDText.clear();
        comboBoxTipoID.setValue(null);
        comboBoxEstadoCivil.setValue(null);
        ciudadText.clear();
        direccionText.clear();
        telefonoText.clear();
        celularText.clear();
        checBoxGusto.setSelected(false);
        checBoxGarganta.setSelected(false);
        checBoxMalestar.setSelected(false);
        checBoxDiarrea.setSelected(false);
        checBoxFiebre.setSelected(false);
        checBoxTos.setSelected(false);
        checBoxErupcion.setSelected(false);
        checBoxConjuntivitis.setSelected(false);
        tempMedidaText.clear();
    }




}

package com.example.bolsadevalores;

import com.example.bolsadevalores.model.Acao;
import com.example.bolsadevalores.model.Ativo;
import com.example.bolsadevalores.model.Corretora;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import tornadofx.control.DateTimePicker;

import java.net.URL;
import java.util.ResourceBundle;

public class SimulationController implements Initializable {
    @FXML
    private ComboBox<Corretora> corretoras;
    @FXML
    private ComboBox<Acao> acoes;
    @FXML
    private TextField quantidade;
    @FXML
    private DateTimePicker data;
    @FXML
    private Label taxaLbl;
    @FXML
    private Label valorLbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadDataIntoComboBoxes();
    }

    private void loadDataIntoComboBoxes() {
        Corretora corretora1 = new Corretora("Rico", 3);
        Corretora corretora2 = new Corretora("XP", 2);
        Corretora corretora3 = new Corretora("Ágora Investimentos", 1);

        ObservableList corretorasList = FXCollections.observableArrayList();
        corretorasList.addAll(corretora1, corretora2, corretora3);

        Acao acao1 = new Acao("Vale", "VALE3", 70.0, 100);
        Acao acao2 = new Acao("Petrobras", "PETR3", 37.0, 100);
        Acao acao3 = new Acao("Casas Bahia", "BHIA3", 0.52, 100);
        Acao acao4 = new Acao("RaiaDrogasil", "RADL3", 26.75, 100);

        ObservableList acoesList = FXCollections.observableArrayList();
        acoesList.addAll(acao1, acao2, acao3, acao4);

        corretoras.getItems().addAll(corretorasList);
        acoes.getItems().addAll(acoesList);
    }

    //press button to start simulation
    @FXML
    private void startSimulation(){
        int quantidadeNum = Integer.parseInt(quantidade.getText());
        double result;

        Corretora corretora =  corretoras.getValue();
        Ativo ativo = acoes.getValue();

        double taxaDaCorretora = corretora.getTaxa(ativo, quantidadeNum);

        result = ativo.getCotacao() * quantidadeNum - taxaDaCorretora;

        taxaLbl.setText(String.format("R$ %.2f", taxaDaCorretora));
        valorLbl.setText(String.format("R$ %.2f", result));
    }
}

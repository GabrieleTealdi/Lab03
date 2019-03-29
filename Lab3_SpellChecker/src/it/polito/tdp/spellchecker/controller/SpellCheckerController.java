package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SpellCheckerController {
	
	private Dictionary model;
	ObservableList<String> chioceBoxList = FXCollections.observableArrayList("English","Italiano");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Button btnSpellCheck;

    @FXML
    private TextArea txtSoluzione;

    @FXML
    private TextField txtNumErr;

    @FXML
    private Button btnClearText;

    @FXML
    private TextField txtTime;

    @FXML
    void doClearText(ActionEvent event) {
    	txtTesto.clear();
    	txtSoluzione.clear();
    	txtNumErr.clear();
    	txtTime.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	double start = System.nanoTime();
    	String s = txtTesto.getText();
    	String l = choiceBox.getValue();
    	List<String> array = new ArrayList();
    	s.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
    	String[] p = s.split(" ");
    	for(int i=0; i<p.length; i++)
    		array.add(p[i]);
    	model.loadDictionary(l);
    	txtSoluzione.appendText(model.stampa(model.spellCheckText(array)));
    	txtNumErr.setText("The text contains "+model.cntErrors(model.spellCheckText(array))+ " errors");
    	model.clearDictionary();
    	double finish = System.nanoTime();
    	txtTime.setText("tempo impiegato: "+(finish-start)/1e9+ " secondi");
    	
    }

    @FXML
    void initialize() {
        assert choiceBox != null : "fx:id=\"choiceBox\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnSpellCheck != null : "fx:id=\"btnSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtSoluzione != null : "fx:id=\"txtSoluzione\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtNumErr != null : "fx:id=\"txtNumErr\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        choiceBox.setItems(chioceBoxList);
    }

	public void setModel(Dictionary model) {
		this.model = model;	
	}
}

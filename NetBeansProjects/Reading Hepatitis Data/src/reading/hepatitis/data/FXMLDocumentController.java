/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reading.hepatitis.data;

import com.google.gson.Gson;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.Scanner;
import java.lang.Object;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import com.google.gson.Gson;
import com.sun.scenario.Settings;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeMap;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.scene.control.TextField;


/**
 *
 * @author dimitriosnikas
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private BarChart barchart;
    
    @FXML
    private ChoiceBox filterChoice;
    
    @FXML
    private TextField maxField, minField;
    
    private DataSet data;
    
    public void IntegerError(){
        Alert integerAlert = new Alert(AlertType.ERROR);
        integerAlert.setTitle("Your integer does not work.");
        integerAlert.setContentText("Enter integers from 0-90");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_117.json?profile=simple&filter=COUNTRY:*";
        URL myurl = null;
        try{
            myurl= new URL(s);
        } catch (Exception e){
            System.out.println("Something's wrong with your URL - " + s);
            System.exit(-1);
        }
        
        Scanner scan = null;
        try{
            scan = new Scanner(myurl.openStream());
        }
        catch (Exception e){
            System.out.println("Couldn't connect to - " + s);
            System.exit(-1);
        }
        String str = new String();
        while(scan.hasNext()){
            str += scan.nextLine() + "\n";
        }
        scan.close();
        minField.setText("0");
        maxField.setText("90");
        Gson gson = new Gson();
        DataSet data = gson.fromJson(str, DataSet.class);
        createGraph();
    }
    
      public void createGraph(){
        barchart.getData().clear();
        int min = 0;
        try{
            min = Integer.parseInt(minField.getText());
        } catch(Exception e){
            minField.setText("0");
            IntegerError();
        }
        int max = 100;
        try{
            max = Integer.parseInt(maxField.getText());
        } catch(Exception e){
            maxField.setText("90");
            IntegerError();
        }
        
        if(min > max || max > 90 || min < 0){
            min = 0;
            max = 90;
            minField.setText("0");
            maxField.setText("90");
            IntegerError();
        }
        XYChart.Series<String, Number> areas = new XYChart.Series();
        areas.setName("Hepatitis Immunizations");
        OneValue[] regionArray = data.getEntries();
        Arrays.sort(regionArray);
        for(OneValue o : regionArray){
            String reg = o.getDim().getRegion();
            if(reg != null){
                int val = o.getValue();
                if(val <= min && val >= max){
                    areas.getData().add(new XYChart.Data(reg, val));
                }
            }

        }
        barchart.getData().add(areas);
    }
}
    
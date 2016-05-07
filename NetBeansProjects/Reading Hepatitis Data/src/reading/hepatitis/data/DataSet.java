/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reading.hepatitis.data;

/**
 *
 * @author dimitriosnikas
 */
import java.util.*;
public class DataSet {
    private OneValue[] fact;
    public DataSet() {
    }
    public OneValue[] getEntries(){
        return fact;
    }
    public String toString() {
        String r = "";
        for(OneValue e : fact){
            r += e.toString() + "\n";
        }
        return r;
    }
}
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
public class OneValue {
    private int Value;
    private Dim dim;
    public OneValue(){
    }
    public int getValue(){
        return Value;
    }
    public Dim getDim(){
        return dim;
    }
    public String toString(){
        return "" + dim.toString() + ": " + Value + "% immunized";
    }
}



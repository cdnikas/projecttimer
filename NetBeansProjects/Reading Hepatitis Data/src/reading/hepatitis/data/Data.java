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
public class Data {
    private String current, last;
    private int zip;
    public Data() {
        super();
    }
    @Override
    public String toString() {
        return "" + zip + " " + this.Date() + " " + current;
    }
    public int getZip() {
        return zip;
    }
    public int Date() {
        if(last.contains("2011")){
            return 2011;
        }
        if(last.contains("2012")){
            return 2012;
        } 
        if(last.contains("2013")){
            return 2015;
        }
        if(!last.contains("2011") && !last.contains("2012") && !last.contains("2013")){
            return -1;
        }
        return 0;
    }
}

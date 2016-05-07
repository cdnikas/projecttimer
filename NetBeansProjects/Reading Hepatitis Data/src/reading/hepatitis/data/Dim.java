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
public class Dim {
    private String PUBLISHSTATE;
    private String REGION;
    private String GHO;
    private String WORLDBANKINCOMEGROUP;
    private int YEAR;
    private String COUNTRY;
    
    public Dim(){
    }
    public String getPublishState(){
        return PUBLISHSTATE;
    }
    public String getRegion(){
        return REGION;
    }
    public String getGHO(){
        return GHO;
    }
    public String getCountry(){
        return COUNTRY;
    }
    public String getIncomeGroup(){
        return WORLDBANKINCOMEGROUP;
    }
    public int getYear(){
        return YEAR;
    }
    @Override
    public String toString(){
        if (REGION != null) {
            return "" + REGION;
        }
        else {
            return "" + WORLDBANKINCOMEGROUP;
        }
    }
}


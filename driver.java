/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package measureconv;

/**
 *
 * @author jeremiahakinbohun
 */
public class driver {

    public static void main(String[] args) {
        Measure newMeas = new Measure("gallon", 3, 3, 2);
        Measure newMeas2 = new Measure("cup", 1);
        newMeas.initializeFraction();
        newMeas2.initializeFraction();
        System.out.println(newMeas);
        MeasureConversion m1 = new MeasureConversion(newMeas, "cup");

        m1.measurementToConvert();
        MeasureArithmetic add1 = new MeasureArithmetic();
        measureMenu start = new measureMenu();
        start.menu();
    }
}

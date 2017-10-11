package measureconv;

import java.math.BigInteger;

/**
 *
 * @author jeremiahakinbohun
 */
public class MeasureConversion {
    /**
     * I want to change this to have the measurement conversions not be done individually, but rather taken from an
     * ArrayList that holds conversions for each measurement type that can be called and plugged in.
     * If you are wondering how to get rid of the cases, uses sets/keys!!!
     */

    final private Measure incMeasure;
    final private String measureToConvertTo;
    private Measure outMeasure;
    private int outNumerator;
    private int outDenominator;
    private double newAmount = 0;
    private double decimal = 0;


    public MeasureConversion(String measureToConverTo) {
        this(null, measureToConverTo);
    }

    public MeasureConversion(Measure incMeasure, String measureToConverTo) {
        this.incMeasure = incMeasure;
        this.measureToConvertTo = measureToConverTo;
    }

    void measurementToConvert() {
        //Check if the measurement was made plural and remove the s for purposes
        //of the switch case. The plural is added back later
        if (this.incMeasure.getMeasureType() != null 
                && this.incMeasure.getMeasureType().length() > 0 
                && this.incMeasure.getMeasureType()
                        .charAt(this.incMeasure.getMeasureType()
                                .length() - 1) == 's') {
            this.incMeasure.setMeasureType(this.incMeasure.getMeasureType()
                    .substring(0, this.incMeasure.getMeasureType()
                            .length() - 1));
        }
        String measConvFrom = this.incMeasure.getMeasureType();


        switch (measConvFrom) {
            case "gallon":
                this.gallonConv(this.measureToConvertTo);
                break;
            case "cup":
                this.cupConv(this.measureToConvertTo);
                break;
            case "ounce":
                this.ounceConv(this.measureToConvertTo);
                break;
            case "tablespoon":
                this.tablespoonConv(this.measureToConvertTo);
                break;
            case "teaspoon":
                this.teaspoonConv(this.measureToConvertTo);
                break;
            case "pint":
                this.pintConv(this.measureToConvertTo);
                break;
            case "quart":
                this.quartConv(this.measureToConvertTo);
                break;
            case "liter":
                this.literConv(this.measureToConvertTo);
                break;
            case "milliliter":
                this.milliliterConv(this.measureToConvertTo);
                break;
            default:
                System.out.println("Invalid measurement type entered.");
                System.exit(1);
                break;
        }
    }

    private void FracConverter(double decConversion) {
        int digitsAfterPoint;
        decConversion = decConversion % 1;//
        decConversion = Math.floor(decConversion * 10) / 10;
        digitsAfterPoint = String.valueOf(decConversion).length()
                - String.valueOf(decConversion).indexOf('.') + 1;
        BigInteger numerator = BigInteger.valueOf((long) (decConversion
                * Math.pow(10, digitsAfterPoint)));
        BigInteger denominator = BigInteger.valueOf((long) (Math.pow(10, digitsAfterPoint)));
        int numInt = (numerator.intValue() * 10) / 1000;
        int denomInt = (denominator.intValue() * 10) / 1000;
        Rational fraction = new Rational(numInt, denomInt);
        fraction.reduceRational(this);
        this.outNumerator = fraction.getNum();
        this.outDenominator = fraction.getDenom();
    }

    private void gallonConv(String measurementToConvertTo) {

        switch (measurementToConvertTo) {
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 16);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 128);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 256);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 768);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 8);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 4);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 3.78541);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 3785.41);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();

    }

    private void cupConv(String measurementToConvertTo) {

        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 8);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 16);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 48);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.5);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * .25);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.236588);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 236.588);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();

    }

    private void ounceConv(String measurementToConvertTo) {

        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0078125);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.125);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 2);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 6);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.03125);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.295735);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 29.5735);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();

    }

    private void tablespoonConv(String measurementToConvertTo) {
        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00390625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.5);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 3);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.03125);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.015625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0147868);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 14.7868);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();
    }

    private void teaspoonConv(String measurementToConvertTo) {
        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00130208);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0208333);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00390625);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.333333);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.0104167);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00520833);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00492892);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 4.92892);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();
    }

    private void pintConv(String measurementToConvertTo) {
        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.125);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 2);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 16);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 32);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 96);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.5);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.473176);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 473.176);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();
    }

    private void quartConv(String measurementToConvertTo) {
        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.25);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 4);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 32);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 64);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 192);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 2);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.946353);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 946.353);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();
    }

    private void literConv(String measurementToConvertTo) {
        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.264172);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 4.22675);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 33.814);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 67.628);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 202.884);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 2.11338);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 1.05669);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "milliliter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 1000);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();
    }

    private void milliliterConv(String measurementToConvertTo) {

        switch (measurementToConvertTo) {
            case "gallon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.000264172);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "cup":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00422675);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "ounce":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.033814);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "tablespoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.067628);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "teaspoon":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.202884);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "pint":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00211338);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "quart":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.00105669);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            case "liter":
                newAmount = ((incMeasure.getAmount() + (double) incMeasure.fraction.getNum()
                        / (double) incMeasure.fraction.getDenom()) * 0.001);
                decimal = newAmount % 1;
                this.FracConverter(decimal);
                break;
            default:
                System.out.println("This is not a valid measuremnet to convert"
                        + " to.");
                System.exit(1);

        }
        newAmount = Math.floor(newAmount);
        this.outMeasure = new Measure(this.measureToConvertTo,
                (int) newAmount, outNumerator, outDenominator);
        this.outMeasure.initializeFraction();

    }
    
    public Measure getOutMeasure(){
        return this.outMeasure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(incMeasure.toString()).append(" converted to ")
                .append(outMeasure.toString());

        return sb.toString();
    }
}

package measureconv;

/**
 *
 * @author jeremiahakinbohun
 */
public class Measure {

    private String measureType;
    private int amount;
    public Rational fraction;
    private int numerator;
    private int denominator;

    public Measure(String measureType, int amount, int numerator, int denominator) {
        this.measureType = measureType;
        this.amount = amount;
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void initializeFraction() {
        if (this.numerator <= 0) this.fraction = new Rational(0, 1);
        else if (this.numerator >= this.denominator) {
            this.amount = this.amount + (this.numerator
                    / this.denominator);
            this.numerator = this.numerator % this.denominator;
            this.fraction = new Rational(this.numerator, this.denominator);
        }
    }

    public Measure(String measureType, int amount) {
        this(measureType, amount, 0, 1);
    }

    public String getMeasureType() {
        return measureType;
    }

    public double getAmount() {
        return amount;
    }

    public Rational getFraction() {
        return fraction;
    }

    public void setMeasureType(String measureType) {
        this.measureType = measureType;
    }


    public void pluralCheck() {
        if (this.fraction.getNum() > 0 || this.amount > 1) {
            this.setMeasureType(measureType + "s");
        }
    }

    @Override
    public String toString() {
        this.pluralCheck();
        StringBuilder sb = new StringBuilder("");
        if (fraction.getNum() == 0) {
            sb.append(this.amount).append(" ").append(this.measureType);
        } else if (fraction.getNum() >= 1) {
            sb.append(this.amount).append(" ").append(this.fraction.toString())
                    .append(" ").append(this.measureType);
        }
        return sb.toString();
    }

}

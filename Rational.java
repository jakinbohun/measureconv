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
    public class Rational {
        //The inner class Rational performs the function of establishing 
        //fractions. Also located within the class are the ability to perform
        //simple arithmetic operations

        private int numer = 0;
        private int denom = 1;

        /**
         *
         * @param numer
         * @param denom
         */
        public Rational(int numer, int denom) {
            this.numer = numer;
            this.denom = denom;
        }
        
        public Rational(int wholeNumber){
            this(wholeNumber,1);
        }


        public int gcd(int bigger, int smaller) {
            int temp;
            int remainder;
            if (!(bigger > smaller)) {
                temp = bigger;
                bigger = smaller;
                smaller = temp;
            }

            while (smaller != 0) {
                remainder = bigger % smaller;
                bigger = smaller;
                smaller = remainder;
            }
            return bigger;
        }

        public int lcm(int a, int b) {
            return (a * b) / this.gcd(a, b);
        }

        public Rational add(Object param_Rational) {
            int the_lcm = 0;
            int numerator_sum = 0;
            Rational conv_param_Rational;
            if (param_Rational instanceof Integer) {
                conv_param_Rational = new Rational((Integer) param_Rational, 1);
                param_Rational = conv_param_Rational;
            }
            if (param_Rational instanceof Rational) {
                the_lcm = lcm(this.denom, ((Rational) param_Rational).denom);
                numerator_sum = the_lcm * this.numer / this.denom + the_lcm
                        * ((Rational) param_Rational).numer / ((Rational) param_Rational).denom;

            }
            return new Rational((int) numerator_sum, the_lcm);
        }

        public Rational radd(Object param) {
            return this.add(param);
        }

        public Rational sub(Object param_Rational) {
            int the_lcm;
            int numerator_sum;
            Rational conv_param_Rational;
            if (param_Rational instanceof Integer) {
                conv_param_Rational = new Rational((Integer) param_Rational, 1);
                param_Rational = conv_param_Rational;
            }
            the_lcm = lcm(this.denom, ((Rational) param_Rational).denom);
            numerator_sum = the_lcm * this.numer / this.denom - the_lcm
                    * ((Rational) param_Rational).numer / ((Rational) param_Rational).denom;
            return new Rational((int) numerator_sum, the_lcm);
        }

        public Rational rsub(Object param) {
            return this.sub(param);
        }

        public Rational multi(Object param_Rational) {
            Rational conv_param_Rational;
            if (param_Rational instanceof Integer) {
                conv_param_Rational = new Rational((Integer) param_Rational, 1);
                param_Rational = conv_param_Rational;
            }
            return new Rational(this.numer * ((Rational) param_Rational).numer,
                    this.denom * ((Rational) param_Rational).denom);
        }

        public Rational rmulti(Object param) {
            return this.multi(param);
        }

        public Rational truediv(Object param_Rational) {
            Rational conv_param_Rational;
            if (param_Rational instanceof Integer) {
                conv_param_Rational = new Rational((Integer) param_Rational, 1);
                param_Rational = conv_param_Rational;
            }
            return new Rational(this.numer * ((Rational) param_Rational).denom,
                    this.denom * ((Rational) param_Rational).numer);
        }

        public Rational rtruediv(Object param) {
            Rational conv_param_Rational;
            if (param instanceof Integer) {
                conv_param_Rational = new Rational((Integer) param, 1);
                param = conv_param_Rational;
            }
            return new Rational(this.numer * ((Rational) param).denom,
                    this.denom * ((Rational) param).numer);
        }

        public Rational reduceRational(Object param) {
            int theGCD = gcd(this.numer, this.denom);
            return new Rational(this.numer / theGCD, this.denom / theGCD);
        }

        public boolean equals(Rational this,Rational paramRational) {
            Rational reducedSelf = this.reduceRational(this);
            Rational reducedParam = this.reduceRational(paramRational);
            return reducedSelf.numer == reducedParam.numer & reducedSelf.denom
                    == reducedParam.denom;
        }

        public int getNum() {
            return this.numer;
        }

        public void setNum(int numer) {
            this.numer = numer;
        }

        public int getDenom() {
            return this.denom;
        }

        public void setDenom(int denom) {
            this.denom = denom;
        }

        @Override
        public String toString() {
            return numer + "/" + denom;
        }
    }

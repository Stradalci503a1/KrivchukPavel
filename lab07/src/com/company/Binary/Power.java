package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Power extends BinaryExpression implements IExpression {

    public Power(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
//        return cache(() -> firstValue().calculate() >= 0 || secondValue().calculate() < 0 || secondValue().calculate() > 1 ?
//                    Math.pow(firstValue().calculate(), secondValue().calculate()) :
//                    Math.pow (secondValue().calculate(), -1) % 2 == 0 ?
//                        Double.NaN :
//                        -Math.pow(Math.abs(firstValue().calculate()), secondValue().calculate()));

        return  cache(() -> {
            double basis = this.firstValue().calculate();
            double extent = this.secondValue().calculate();
            if (basis > 0) {
                return Math.pow(basis, extent);
            }

            //Without root
            String[] split = ((Double) extent).toString().split(".");
            if (1 == split.length) {
                return Math.pow(basis, extent);
            }

            //With root
            double decimalExtent = Math.floor(Math.abs(extent)) * Math.signum(extent);
            double result = Math.pow(basis, decimalExtent);

            double floatExtent = (int) (1 / (Math.abs(extent) - Math.abs(decimalExtent)));
            if (floatExtent % 2 == 1) {
                return -1 * Math.pow(Math.abs(basis), extent);
            }

            return Double.NaN;
        });
    }
}

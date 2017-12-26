package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Multiplication extends BinaryExpression implements IExpression {

    public Multiplication(Object value){
        super(new Value(value), new Value(1));
    }

    public Multiplication(Object firstValue, Object secondValue, Object... additionalValues) {
        super(new Value(firstValue), new Value(secondValue));

        IExpression product = secondValue();
        for (Object element : additionalValues) {
            product = new Multiplication(element, product);
        }
        secondValue(product);
    }

    @Override
    public double calculate() {
        return cache(() -> firstValue().calculate() * secondValue().calculate());
    }
}

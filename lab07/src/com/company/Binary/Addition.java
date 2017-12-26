package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Addition extends BinaryExpression implements IExpression {

    public Addition(Object value) {
        super(new Value(value), new Value(0));
    }

    public Addition(Object firstValue, Object secondValue, Object... additionalValues) {
        super(new Value(firstValue), new Value(secondValue));

        IExpression sum = secondValue();
        for (Object element : additionalValues) {
            sum = new Addition(element, sum);
        }
        secondValue(sum);
    }

    @Override
    public double calculate() {
        return cache(() -> firstValue().calculate() + secondValue().calculate());
    }
}

package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Division extends BinaryExpression implements IExpression {

    public Division(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return cache(() -> 0 == secondValue().calculate() ? Double.NaN : firstValue().calculate() / secondValue().calculate());
    }
}

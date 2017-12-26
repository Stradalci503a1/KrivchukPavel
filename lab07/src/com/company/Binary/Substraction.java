package com.company.Binary;

import com.company.Base.BinaryExpression;
import com.company.Base.IExpression;
import com.company.Base.Value;

public class Substraction extends BinaryExpression implements IExpression {

    public Substraction(Object firstValue, Object secondValue){
        super(new Value(firstValue), new Value(secondValue));
    }

    @Override
    public double calculate() {
        return cache(() -> firstValue().calculate() - secondValue().calculate());
    }
}

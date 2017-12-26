package com.company.Unary;

import com.company.Base.IExpression;
import com.company.Base.UnaryExpression;
import com.company.Base.Value;

public class Absolute extends UnaryExpression implements IExpression {

    public Absolute(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        return cache(() -> Math.abs(value().calculate()));
    }
}

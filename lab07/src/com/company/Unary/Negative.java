package com.company.Unary;

import com.company.Base.IExpression;
import com.company.Base.UnaryExpression;
import com.company.Base.Value;

public class Negative extends UnaryExpression implements IExpression {

    public Negative(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        return cache(() -> -value().calculate());
    }
}

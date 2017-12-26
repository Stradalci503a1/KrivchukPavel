package com.company.Unary;

import com.company.Base.IExpression;
import com.company.Base.UnaryExpression;
import com.company.Base.Value;

public class Square extends UnaryExpression implements IExpression {

    public Square(Object value){
        super(new Value(value));
    }

    @Override
    public double calculate() {
        return cache(() -> value().calculate() * value().calculate());
    }
}

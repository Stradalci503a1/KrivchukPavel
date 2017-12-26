package com.company.Base;

public abstract class Utils {

    public static boolean equals(IExpression firstExpression, IExpression secondExpression){

        if (firstExpression == secondExpression) {
            return true;
        }

        if (firstExpression.getClass() != secondExpression.getClass()) {
            return false;
        }

        if (firstExpression instanceof BinaryExpression) {
            return equals(((BinaryExpression) firstExpression).firstValue(), ((BinaryExpression)secondExpression).firstValue()) &&
                    equals(((BinaryExpression) firstExpression).secondValue(), ((BinaryExpression)secondExpression).secondValue());

        } else if (firstExpression instanceof UnaryExpression) {
            return equals(((UnaryExpression) firstExpression).value(), ((UnaryExpression)secondExpression).value());

        } else if (firstExpression instanceof Value){
            return (firstExpression).calculate() == (secondExpression).calculate();

        } else {
            return false;
        }
    }

}

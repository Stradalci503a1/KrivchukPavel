package com.company.Base;

public class Value implements IExpression {

    private double value;

    public Value(Object value) {

        if (value instanceof Byte || value instanceof Short || value instanceof Integer
                || value instanceof Long || value instanceof Float) {

            this.value = Double.valueOf(value.toString());
        } else if (value instanceof Double) {
            this.value = (double)value;
        } else if (value instanceof String) {
            try {
                    this.value = Double.valueOf((String) value);
            } catch (NumberFormatException exception) {
                this.value = Double.NaN;
            }
        } else if (value instanceof IExpression) {
            this.value = ((IExpression)value).calculate();
        } else {
            this.value = Double.NaN;
        }
    }

    @Override
    public double calculate() {
        return value;
    }
}

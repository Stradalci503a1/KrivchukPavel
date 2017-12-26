package com.company.Base;

import java.util.function.Supplier;

public abstract class BinaryExpression {

    private IExpression firstValue;
    private IExpression secondValue;
    protected CacheResult cache;

    public BinaryExpression(IExpression firstValue, IExpression secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        cache = new CacheResult((IExpression) this);
    }

    public IExpression firstValue() {
        return firstValue;
    }

    public void firstValue(IExpression value) {
        firstValue = value;
    }

    public IExpression secondValue() {
        return secondValue;
    }

    public void secondValue(IExpression value) {
        secondValue = value;
    }

    protected double cache(Supplier expression) {
        return cache.getCache(expression);
    }
}

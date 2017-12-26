package com.company.Base;

import java.util.function.Supplier;

public abstract class UnaryExpression {

    private IExpression value;
    protected CacheResult cache;

    public UnaryExpression(IExpression value){
        this.value = value;
        cache = new CacheResult((IExpression) this);
    }

    public IExpression value() {
        return value;
    }

    public void value(IExpression value) {
        this.value = value;
    }

    protected double cache(Supplier expression) {
        return cache.getCache(expression);
    }
}

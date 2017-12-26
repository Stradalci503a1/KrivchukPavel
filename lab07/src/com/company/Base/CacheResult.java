package com.company.Base;

import java.util.ArrayList;
import java.util.function.Supplier;

class CacheResult{

    private static ArrayList<Container> cache = new ArrayList<>();

    private Container container;

    public CacheResult(IExpression expression){

        for (Container element : cache) {
            if (Utils.equals(element.expression, expression)) {
                container = element;
            }
        }

        if (container == null) {
            container = new Container(expression);
            cache.add(container);
        }
    }

    protected double getCache(Supplier<Double> expression) {
        return container.calculate(expression);
    }

    private class Container{

        private Double result;
        private IExpression expression;

        public Container(IExpression expression) {
            this.expression = expression;
        }

        private double calculate(Supplier<Double> expression) {
            if (null == result) {
                result = expression.get();
            }

            return result;
        }
    }
}

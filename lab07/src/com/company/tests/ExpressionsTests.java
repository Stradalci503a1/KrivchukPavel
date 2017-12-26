package com.company.tests;

import com.company.Base.IExpression;
import com.company.Binary.*;
import com.company.Unary.Absolute;
import com.company.Unary.Negative;
import com.company.Unary.Square;
import com.company.Base.Value;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionsTests {

    @Test
    public void value(){

        IExpression value = new Value(5);
        assertEquals(5, value.calculate(), 0.001);

        value = new Value(5235L);
        assertEquals(5235, value.calculate(), 0.001);

        value = new Value(53.4);
        assertEquals(53.4, value.calculate(), 0.0001);

        value = new Value(56.2F);
        assertEquals(56.2, value.calculate(), 0.0001);

        value = new Value((byte)21);
        assertEquals(21, value.calculate(), 0.001);

        value = new Value((short)21657);
        assertEquals(21657,  value.calculate(), 0.001);

        value = new Value("654");
        assertEquals(654, value.calculate(), 0.001);

        value = new Value("436dgs4");
        assertEquals(Double.NaN, value.calculate());
    }

    @Test
    public void absolute(){
        IExpression absolute = new Absolute(-7);
        assertEquals(7, absolute.calculate(), 0.001);
    }

    @Test
    public void negative(){
        IExpression negative = new Negative(-4);
        assertEquals(4, negative.calculate(), 0.001);
    }

    @Test
    public void square(){
        IExpression square = new Square(3);
        assertEquals(9, square.calculate(), 0.001);
    }

    @Test
    public void addition(){
        IExpression addition = new Addition(3, 8);
        assertEquals(11, addition.calculate(), 0.001);

        addition = new Addition(5, "2", 0.1F, 3.4);
        assertEquals(10.5, addition.calculate(), 0.0001);

        addition = new Addition(2.5);
        assertEquals(2.5, addition.calculate(), 0.0001);
    }

    @Test
    public void multiplication(){
        IExpression multiplication = new Multiplication(-5, 2);
        assertEquals(-10, multiplication.calculate(), 0.001);

        multiplication = new Multiplication(5, "2", 0.1F, 3.4);
        assertEquals(3.4, multiplication.calculate(), 0.0001);

        multiplication = new Multiplication(7);
        assertEquals(7, multiplication.calculate(), 0.001);
    }

    @Test
    public void substraction() {
        IExpression substraction = new Substraction(-2 , 7);
        assertEquals(-9, substraction.calculate(), 0.001);
    }

    @Test
    public void division() {
        IExpression division = new Division(6, 3);
        assertEquals(2, division.calculate(), 0.001);

        division = new Division(3, 0);
        assertEquals(Double.NaN, division.calculate());
    }

    @Test
    public void power() {
        IExpression power = new Power(3, 4);
        assertEquals(81, power.calculate(), 0.001);

        power = new Power(-5, 1.0/2.0);
        assertEquals(Double.NaN, power.calculate());

        power = new Power(-8, 1.0/3.0);
        assertEquals(-2, power.calculate(), 0.001);

        power = new Power(-8, 5.0 / 3);
        assertEquals(-32.0 , power.calculate(), 0.001);
    }

    @Test
    public void rest() {
        IExpression rest = new Rest(5, 2);
        assertEquals(1, rest.calculate(), 0.001);

        rest = new Rest(6, 0);
        assertEquals(Double.NaN, rest.calculate());
    }

    @Test
    public void mathExpression(){
        //Mathematical IExpression: 5^3 + 2 * (-4) - 3 / (2^2 % |-3|)
        IExpression IExpression = new Addition(
                                    new Power(5, 3),
                                    new Substraction(
                                            new Multiplication(2,
                                                    new Negative(4)),
                                            new Division(3,
                                                    new Rest(
                                                            new Square(2),
                                                            new Absolute(-3)))));
        assertEquals(114, IExpression.calculate(), 0.001);
    }

    //Average time with cache 1.2, without 2,2 in my PC
    @Test
    public void useCache() {
        IExpression expression = new Addition(
                new Substraction(
                        new Multiplication(2,
                                new Negative(4)),
                        new Division(3,
                                new Rest(
                                        new Square(2),
                                        new Power(5, 3)))),
                new Substraction(
                        new Multiplication(2,
                                new Negative(4)),
                        new Division(3,
                                new Rest(
                                        new Square(2),
                                        new Absolute(-3)))));

        for (int i = 0; i < 1000000000; i++) {
            expression.calculate();
        }
    }
}

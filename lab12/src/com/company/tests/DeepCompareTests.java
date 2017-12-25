package com.company.tests;

import com.company.DeepCompare;
import com.company.IDeepCompare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeepCompareTests {

    private IDeepCompare comparator = new DeepCompare();

    @Test
    public void nullPointer() {

        PublicFields<Integer> firstObject = null;
        PublicFields<Integer> secondObject = null;
        PublicFields<Integer> thirdObject = new PublicFields<>(6);

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void privateFields() {

        PrivateFields firstObject = new PrivateFields(34, 'a');
        PrivateFields secondObject = new PrivateFields(34, 'a');
        PrivateFields thirdObject = new PrivateFields(15, 'a');

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void cyclicLinks() {

        ToCyclic firstObject = new ToCyclic();
        ToCyclic secondObject = new ToCyclic(firstObject);
        ToCyclic thirdObject = new ToCyclic(secondObject);
        firstObject = secondObject;

        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void publicFields() {

        int i = 1;
        PublicFields<String> firstObject = new PublicFields<>("Test" + i);
        PublicFields<String> secondObject = new PublicFields<>("Test" + i);
        PublicFields<String> thirdObject = new PublicFields<>("1gdfs");

        Assertions.assertTrue(comparator.isEqual(firstObject, secondObject));
        Assertions.assertFalse(comparator.isEqual(firstObject, thirdObject));
    }

    @Test
    public void compareStrings() {

        String left = new String();
        left += "Te";
        left += "st";
        StringBuilder right = new StringBuilder();
        right.append("T").append("es").append("t");

        Assertions.assertTrue(comparator.isEqual(left, right.toString()));

        right.append("4");
        Assertions.assertFalse(comparator.isEqual(left, right.toString()));
    }
}

package com.company.tests;

import com.company.ILinkedList;
import com.company.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Struct;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LinkedListTests {

    @Test
    public void tests(){

        //Initialize
        LinkedList<testClass> list = new LinkedList<>();
        ILinkedList<testClass> iList = list;
        Predicate<testClass> predicate = (element) -> element.value > 0;
        Function<testClass, String> function = element -> String.valueOf(element.value);
        Consumer<testClass> consumer = element -> element.value--;



        //Fill lists
        list.add(new testClass(5));
        list.add(new testClass(9));
        list.add(new testClass(2));
        list.add(new testClass(-5));
        list.add(new testClass(1));
        list.add(new testClass(-16));



        //Check
        Assertions.assertFalse(iList.all(predicate));
        Assertions.assertTrue(iList.any(predicate));
        Assertions.assertEquals(5, iList.first(predicate).value);
        Assertions.assertEquals( 1,  iList.last(predicate).value);
        Assertions.assertEquals(4, iList.count(predicate));
        Assertions.assertNull(iList.single(predicate));

        LinkedList<testClass> filteredList = (LinkedList<testClass>) iList.filter(predicate);
        for(testClass element : filteredList){
            Assertions.assertTrue(0 < element.value);
        }

        list.removeFirst();
        list.removeFirst();
        list.remove(2);
        //list: [2, -5, -16]
        Assertions.assertEquals(2,  iList.single(predicate).value);

        LinkedList<String> stringList = (LinkedList<String>) iList.select(function);
        Assertions.assertEquals("2", stringList.find(0));
        Assertions.assertEquals("-5", stringList.find(1));
        Assertions.assertEquals("-16", stringList.find(2));

        LinkedList<testClass> consumedList = (LinkedList<testClass>) iList.map(consumer);
        Assertions.assertEquals(1, consumedList.find(0).value);
        Assertions.assertEquals(-6, consumedList.find(1).value);
        Assertions.assertEquals(-17, consumedList.find(2).value);
    }

    private class testClass{
        public int value;

        public testClass(int value){
            this.value = value;
        }
    }
}

package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class DeepCompare implements IDeepCompare{

    ArrayList verifiableObjects = new ArrayList();

    @Override
    public boolean isEqual(Object left, Object right) {

        if (left == right) {
            return true;
        }

        if (null == left || null == right) {
            return false;
        }

        if (left.getClass() != right.getClass()) {
            return false;
        }

        if (-1 != verifiableObjects.indexOf(left) || -1 != verifiableObjects.indexOf(right)) {
            return false;
        }

        if (left instanceof Byte) {
            return (Byte) left == (Byte) right;
        } else if (left instanceof Short) {
            return (Short) left == (Short) right;
        } else if (left instanceof Integer) {
            return (int) left == (int) right;
        } else if (left instanceof Long) {
            return (long) left == (long) right;
        } else if (left instanceof Float) {
            return (float) left == (float) right;
        } else if (left instanceof Double) {
            return (double) left == (double) right;
        } else if (left instanceof Boolean) {
            return (boolean) left == (boolean) right;
        } else if (left instanceof Character) {
            return (char) left == (char) right;
        }

        verifiableObjects.add(left);
        verifiableObjects.add(right);

        if (left.getClass().isArray()) {

            if (Array.getLength(left) != Array.getLength(right)) {
                remove(left, right);
                return false;
            }
            for (int i = 0; i < Array.getLength(left); i++) {
                if (!isEqual(Array.get(left, i), Array.get(right, i))) {
                    remove(left, right);
                    return false;
                }
            }
        } else {
            for (Field field : left.getClass().getDeclaredFields()) {

                try {
                    field.setAccessible(true);
                    if (!isEqual(field.get(left), field.get(right))) {
                        remove(left, right);
                        return false;
                    }

                } catch (IllegalAccessException e) {
                }
            }
        }
        remove(left, right);

        return true;
    }

    private void remove(Object left, Object right) {
        verifiableObjects.remove(left);
        verifiableObjects.remove(right);
    }
}

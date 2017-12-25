package com.company;

public interface IDeepCompare {
    <TObject> boolean isEqual(TObject left, TObject right);
}

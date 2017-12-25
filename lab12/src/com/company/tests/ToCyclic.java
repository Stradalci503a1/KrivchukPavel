package com.company.tests;

public class ToCyclic {

    public ToCyclic field;

    public ToCyclic() {
    }
    
    public ToCyclic(ToCyclic field) {
        this.field = field;
    }
    
}
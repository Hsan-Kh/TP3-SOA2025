package com.soa.calculatrice.model;

public class Operation {
    private double operande1;
    private double operande2;
    private double resultat;
    private String operation;

    public Operation() {
    }

    public Operation(double operande1, double operande2, double resultat, String operation) {
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.resultat = resultat;
        this.operation = operation;
    }

    public double getOperande1() {
        return operande1;
    }

    public void setOperande1(double operande1) {
        this.operande1 = operande1;
    }

    public double getOperande2() {
        return operande2;
    }

    public void setOperande2(double operande2) {
        this.operande2 = operande2;
    }

    public double getResultat() {
        return resultat;
    }

    public void setResultat(double resultat) {
        this.resultat = resultat;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
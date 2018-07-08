package com.poe.genetic;

public class Base {

    private String symbol;
    private String name;
    private String familly;
    
    
    Base(){}

    Base(String symbol) throws GeneticException {
        switch (symbol.toUpperCase()) {
            case "A":
                this.familly = "Purine";
                this.name = "adenine";
                break;
            case "C":
                this.familly = "Pyrimidine";
                this.name = "cytosine";
                break;
            case "G":
                this.familly = "Pyrimidine";
                this.name = "guanine";
                break;
            case "T":
                this.familly = "Purine";
                this.name = "thymine";
                break;
            case "U":
                this.familly = "Purine";
                this.name = "uracile";
                break;
            default:
                throw new GeneticException("Base Error : Unknown symbol " + symbol);
        }
        this.symbol = symbol.toUpperCase();

    }

    @Override
    public String toString() {
        return String.format("[%s,%s,%s]", this.getSymbol(), this.getName(), this.getFamilly());
    }

    // permet d'obtenir la pair d'une base.
    private Base getApparie() {
        return null;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getFamilly() {
        return familly;
    }
}

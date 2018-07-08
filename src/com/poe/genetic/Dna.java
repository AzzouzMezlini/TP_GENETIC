package com.poe.genetic;

import java.util.ArrayList;
import java.util.List;

public class Dna extends NucleicAcid {
		
    public Dna(String SequenceDNA) throws GeneticException {
        super(SequenceDNA,true,false);
    }


    public List<Base> getPrincipalStrand() {
        return super.getStrand();
    }


    protected List<Base> getComplementaryStrand() throws GeneticException {
//        return super.getStrand();
        List<Base> res = new ArrayList<>();
        for (Base aBase : super.getStrand()) {
            res.add(getBase(aBase, true, true));
        }
        return res;
    }

    private Dna getComplementaryDNA() throws GeneticException {
        //@TODO : utiliser les fonction MAP-FILTER
        String res = "";
        for (Base aBase : super.getStrand()) {
            res += getBase(aBase, true, true).getSymbol();
        }

        return new Dna(res);
    }

    @Override
    public String toString() {
        return "DNA :" + super.toString();
    }

    Rna transcription() {
        return null;
    }
}

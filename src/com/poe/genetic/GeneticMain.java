package com.poe.genetic;


import java.util.stream.Collectors;

public class GeneticMain {
    public static void main(String[] args) {

        //Base a;
        try {
            Base a = new Base("a");
            System.out.println(a);
            Dna dna = new Dna("acgtcgttacgt");
            System.out.print("Principal  ");
            System.out.println(dna.getPrincipalStrand().stream().map(base -> base.getSymbol()).collect(Collectors.joining()));
            System.out.print("Complement ");
            System.out.println(dna.getComplementaryStrand().stream().map(base -> base.getSymbol()).collect(Collectors.joining()));
            System.out.print("ARN        ");
            Rna rna = ArnPolymerase.transcription(dna.getPrincipalStrand());
            System.out.println(rna.getStrand().stream().map(base -> base.getSymbol()).collect(Collectors.joining()));
            System.out.print("AminoAcid  ");
            //System.out.println(Ribosome.getAminoAcid("UAC").getName()); //cette fonction est déclarer en private
            System.out.println(Ribosome.translate(rna).stream().map(aminoAcid -> aminoAcid.getSymbol()).collect(Collectors.joining()));

        } catch (GeneticException e) {
            e.printStackTrace();
        }

    }
}

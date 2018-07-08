package com.poe.genetic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArnPolymerase  {
    static Rna transcription(List<com.poe.genetic.Base> dnaSequence) throws GeneticException {
        Stream<Base> baseStream = dnaSequence.stream();
        String sequence = baseStream.map(base -> base.getSymbol()).collect(Collectors.joining());
        com.poe.genetic.Rna res = new Rna(sequence);
        return res;
    }
}

package com.poe.genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NucleicAcid {

    private List<Base> strand;
    //public final boolean isDNA = null != null;
    
    protected  NucleicAcid() {};

    protected NucleicAcid(String sequence, boolean isDNA,boolean isPair) throws GeneticException {
        this.strand = new ArrayList<>();
        for (int i = 0; i < sequence.length(); i++) {
        	Base base = new Base(sequence.substring(i, i + 1));
            this.strand.add( this.getBase(base,isDNA,isPair));
        }
        
    }


    protected List<Base> getStrand() {
		return strand;
	}

	static protected  Base getBase(Base base,boolean isDNA,boolean isPair) throws GeneticException {

    	Base res;
    	
    	switch (base.getSymbol()) {
        case "A":
        	if(isPair) {
        		if (isDNA) {
                    res = new Base("T");
                } else {
                    res = new Base("U");
                }
        		
        	}else {
        		res = new Base("A");
        	}
            break;
            
        case "C":
        	if(isPair) {
        		res = new Base("G");	
        	}else {
        		res = new Base("C");
        	}            
            break;
            
        case "G":
        	if(isPair) {
        		res = new Base("C");	
        	}else {
        		res = new Base("G");
        	}
            break;
            
        case "T":
            if (isPair) {
                res = new Base("A");
            }else {
            	res = new Base("T");
            }
            break;
        case "U":
        	if(isDNA||!isPair) {            
            	throw new GeneticException("Nucleic Acid Error : Unknown DNA symbol " + base.getSymbol());
            } else {
            	res = new Base("A");
            }
        	break;
        default:
            throw new GeneticException("Nucleic Acid Error : Unknown Base symbol " + base.getSymbol());
    }
    	return res;
    }

    private List<Base> setStrand(String sequence,boolean isDNA) throws GeneticException {
    	List<Base>res = new ArrayList();
    	for(int i = 0; i< sequence.length();i++) {
    		res.add(this.getBase(new Base(sequence.substring(i, i+1)), isDNA, false));
    	}
        return strand;
    }

    @Override
    public String toString() {
       return strand.stream().map(base -> base.getSymbol()).collect(Collectors.toList()).toString();
    }
}

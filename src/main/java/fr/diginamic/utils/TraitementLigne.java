package fr.diginamic.utils;

import fr.diginamic.entites.*;

public class TraitementLigne {

    public static String[] traitementLigne(String line ){


        String modifiedLines1 = line.replace("|’Agriculture", "l’Agriculture");
        modifiedLines1 = modifiedLines1.replace("|acty|ate", "lactylate");
        modifiedLines1 = modifiedLines1.replace("|antioxydant: levure, E282]", "[antioxydant: levure, E282]");
        modifiedLines1 = modifiedLines1.replace("|% [maltodextrine de blé,", "[maltodextrine de blé,");
        modifiedLines1 = modifiedLines1.replace("d’A|aska", "d’Alaska");
        modifiedLines1 = modifiedLines1.replace("|’œuf", "l’œuf");
        modifiedLines1 = modifiedLines1.replace("|’ancienne", "l’ancienne");

        String[] tokens = modifiedLines1.split("\\|");

        return tokens;
    }
}

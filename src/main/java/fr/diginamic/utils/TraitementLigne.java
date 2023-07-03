package fr.diginamic.utils;

/**
 * Cette classe fournit une méthode statique pour le traitement d'une ligne de texte.
 */
public class TraitementLigne {

    /**
     * Traite une ligne de texte en appliquant des modifications spécifiques.
     *
     * @param line la ligne de texte à traiter
     * @return un tableau de chaînes de caractères contenant les tokens résultants du traitement de la ligne
     */

    public static String[] traitementLigne(String line) {

        // Appliquer les modifications spécifiques à la ligne
        String modifiedLines1 = line.replace("|’Agriculture", "l’Agriculture");
        modifiedLines1 = modifiedLines1.replace("|acty|ate", "lactylate");
        modifiedLines1 = modifiedLines1.replace("|antioxydant: levure, E282]", "[antioxydant: levure, E282]");
        modifiedLines1 = modifiedLines1.replace("|% [maltodextrine de blé,", "[maltodextrine de blé,");
        modifiedLines1 = modifiedLines1.replace("d’A|aska", "d’Alaska");
        modifiedLines1 = modifiedLines1.replace("|’œuf", "l’œuf");
        modifiedLines1 = modifiedLines1.replace("|’ancienne", "l’ancienne");

        // Séparer la ligne en tokens en utilisant le caractère '|'
        String[] tokens = modifiedLines1.split("\\|");

        return tokens;
    }
}

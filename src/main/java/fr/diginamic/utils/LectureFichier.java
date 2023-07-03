package fr.diginamic.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Cette classe fournit une méthode pour lire un fichier texte.
 */
public class LectureFichier {

    /**
     * Lit un fichier texte et renvoie son contenu sous forme de liste de chaînes de caractères.
     *
     * @param path le chemin d'accès au fichier à lire
     * @return une liste contenant les lignes du fichier
     * @throws Exception si une erreur survient lors de la lecture du fichier
     */

    public static List<String> lectureFichier(Path path) throws Exception {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines;
    }
}

package fr.diginamic.utils;

import fr.diginamic.entites.Produit;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LectureFichier {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/Lan/Desktop/DIginamic/JPA/Projet JPA (énoncés)/Open Food Facts/open-food-facts.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        List<Produit> produits = new ArrayList<>();

        ListIterator<String> iter = lines.listIterator();
        iter.next();
        while (iter.hasNext()) {
            String line = iter.next();
            //System.out.println(line);
            String[] tokens = line.split("\\|");
            String categorie = tokens[0];
            String marque = tokens[1];
            String nom = tokens[2];
            String nutritionGradeFr = tokens[3];
            String ingredients = tokens[4];
            Float energie100g = Float.parseFloat(tokens[5].replaceFirst("","0"));
           /* Float graisse100g = Float.valueOf(tokens[6]);
            Float sucres100g = Float.valueOf(tokens[7]);
            Float fibres100g = Float.parseFloat(tokens[8].replaceFirst("","0"));
            Float proteines100g = Float.valueOf(tokens[9]);
            Float sel100g = Float.valueOf(tokens[10]);
            Float vitA100g = Float.valueOf(tokens[11]);
            Float vitD100g = Float.valueOf(tokens[12]);
            Float vitE100g = Float.valueOf(tokens[13]);
            Float vitK100g = Float.valueOf(tokens[14]);
            Float vitC100g = Float.valueOf(tokens[15]);
            Float vitB1100g = Float.valueOf(tokens[16]);
            Float vitB2100g = Float.valueOf(tokens[17]);
            Float vitPP100g = Float.valueOf(tokens[18]);
            Float vitB6100g = Float.valueOf(tokens[19]);
            Float vitB9100g = Float.valueOf(tokens[20]);
            Float vitB12100g = Float.valueOf(tokens[21]);
            Float calcium100g = Float.valueOf(tokens[22]);
            Float magnesium100g = Float.valueOf(tokens[23]);
            Float iron100g = Float.valueOf(tokens[24]);
            Float fer100g = Float.valueOf(tokens[25]);
            Float betaCarotene100g = Float.valueOf(tokens[26]);
            Boolean presenceHuilePalme = Boolean.valueOf(tokens[27]);
            String allergenes = tokens[28];
            String additifs = tokens[29];

         */
            for (l:lines){
            System.out.println(energie100g);





        }
    }
}

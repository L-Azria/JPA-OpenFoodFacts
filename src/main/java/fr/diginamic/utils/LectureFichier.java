package fr.diginamic.utils;

import fr.diginamic.entites.Additif;
import fr.diginamic.entites.Allergene;
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
        List<Additif> additifs = new ArrayList<>();
        List<Allergene> allergenes = new ArrayList<>();



        ListIterator<String> iter = lines.listIterator();
        iter.next();
        while (iter.hasNext()) {
            String line = iter.next();
            //System.out.println(line);
            String modifiedLines1 = line.replace("|’Agriculture", "l’Agriculture" );
            String modifiedLines2 = modifiedLines1.replace("|acty|ate", "lactylate" );
            String modifiedLines3 = modifiedLines2.replace("|antioxydant: levure, E282]", "[antioxydant: levure, E282]" );
            String modifiedLines4 = modifiedLines3.replace("|% [maltodextrine de blé,", "[maltodextrine de blé," );
            String modifiedLines5 = modifiedLines4.replace("d’A|aska", "d’Alaska" );
            String modifiedLines6 = modifiedLines5.replace("|’œuf", "l’œuf" );
            String modifiedLines7 = modifiedLines6.replace("|’ancienne", "l’ancienne" );
            String[] tokens = modifiedLines7.split("\\|");
            String categorie = tokens[0];
            String marque = tokens[1];
            String nom = tokens[2];
            String nutritionGradeFr = tokens[3];
            String ingredients = tokens[4];
            Float energie100g = Float.parseFloat(tokens[5].replaceFirst("","0"));
            Float graisse100g = Float.parseFloat(tokens[6].replaceFirst("","0"));
            Float sucres100g = Float.parseFloat(tokens[7].replaceFirst("","0"));
            Float fibres100g = Float.parseFloat(tokens[8].replaceFirst("","0"));
            Float proteines100g = Float.parseFloat(tokens[9].replaceFirst("","0"));
            Float sel100g = Float.parseFloat(tokens[10].replaceFirst("","0"));
            Float vitA100g = Float.parseFloat(tokens[11].replaceFirst("","0"));
            Float vitD100g = Float.parseFloat(tokens[12].replaceFirst("","0"));
            Float vitE100g = Float.parseFloat(tokens[13].replaceFirst("","0"));
            Float vitK100g = Float.parseFloat(tokens[14].replaceFirst("","0"));
            Float vitC100g = Float.parseFloat(tokens[15].replaceFirst("","0"));
            Float vitB1100g = Float.parseFloat(tokens[16].replaceFirst("","0"));
            Float vitB2100g = Float.parseFloat(tokens[17].replaceFirst("","0"));
            Float vitPP100g = Float.parseFloat(tokens[18].replaceFirst("","0"));
            Float vitB6100g = Float.parseFloat(tokens[19].replaceFirst("","0"));
            Float vitB9100g = Float.parseFloat(tokens[20].replaceFirst("","0"));
            Float vitB12100g = Float.parseFloat(tokens[21].replaceFirst("","0"));
            Float calcium100g = Float.parseFloat(tokens[22].replaceFirst("","0"));
            Float magnesium100g = Float.parseFloat(tokens[23].replaceFirst("","0"));
            Float iron100g = Float.parseFloat(tokens[24].replaceFirst("","0"));
            Float fer100g = Float.parseFloat(tokens[25].replaceFirst("","0"));
            Float betaCarotene100g = Float.parseFloat(tokens[26].replaceFirst("","0"));
            Integer presenceHuilePalme = Integer.parseInt(tokens[27]);
            String allergenesObj = tokens[28];
            String additifsObj = tokens[29];
            produits.add(new Produit(nom, energie100g,graisse100g,sucres100g,fibres100g,proteines100g,sel100g,vitA100g,vitD100g,vitE100g,vitK100g,vitC100g,vitB1100g,vitB2100g,vitPP100g,vitB6100g,vitB9100g,vitB12100g,calcium100g,magnesium100g,iron100g,fer100g,betaCarotene100g));

            // parser les allergènes:
            String[] tokensAllergenes = allergenesObj.split(",");
            for (int i = 0; i<tokensAllergenes.length; i++){
                String listeAllergene = tokensAllergenes[i];
                allergenes.add(new Allergene(listeAllergene));
               // System.out.println(listeAllergene);
            }

            // parser les additifs
            if(!additifsObj.isEmpty()) {
                String[] tokensAdditifs = additifsObj.split(",");
                for (int i = 0; i < tokensAdditifs.length; i++) {
                    String listeAdditif = tokensAdditifs[i];
                    String[] tokensAdditifsCodeLibelle = listeAdditif.split(" - ");
                    String code = tokensAdditifsCodeLibelle[0];
                    String libelle = tokensAdditifsCodeLibelle[1];
                    //additifs.add(new Additif(code,libelle));
                    System.out.println(libelle);
                }
            } else {
                String code;
                String libelle;
            }




            }


        }
        //System.out.println(produits);
        //System.out.println(allergenes);
        //System.out.println(additifs);
    }


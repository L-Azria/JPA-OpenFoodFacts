package fr.diginamic.utils;

import fr.diginamic.entites.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TraitementFichier {
    private Set<Produit> produits;
    private Set<Additif> additifs;
    private Set<Allergene> allergenes;
    private Set<Ingredient> ingredients;
    private Set<Marque> marques;

    public Set<Produit> getProduits() {
        return produits;
    }

    public Set<Additif> getAdditifs() {
        return additifs;
    }

    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Set<Marque> getMarques() {
        return marques;
    }

    public void traitementFichier(Path path) throws Exception {
   //     Path path = Paths.get("/Users/Lan/Desktop/DIginamic/JPA/Projet JPA (énoncés)/Open Food Facts/open-food-facts.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);




        produits = new HashSet<>();
        additifs = new HashSet<>();
        allergenes = new HashSet<>();
        ingredients = new HashSet<>();
        marques = new HashSet<>();


        ListIterator<String> iter = lines.listIterator();
        iter.next();
        while (iter.hasNext()) {
            String line = iter.next();

            String modifiedLines1 = line.replace("|’Agriculture", "l’Agriculture");
            modifiedLines1 = modifiedLines1.replace("|acty|ate", "lactylate");
            modifiedLines1 = modifiedLines1.replace("|antioxydant: levure, E282]", "[antioxydant: levure, E282]");
            modifiedLines1 = modifiedLines1.replace("|% [maltodextrine de blé,", "[maltodextrine de blé,");
            modifiedLines1 = modifiedLines1.replace("d’A|aska", "d’Alaska");
            modifiedLines1 = modifiedLines1.replace("|’œuf", "l’œuf");
            modifiedLines1 = modifiedLines1.replace("|’ancienne", "l’ancienne");

            String[] tokens = modifiedLines1.split("\\|");
            String categorie = tokens[0];
            String marque = tokens[1];
            String nom = tokens[2];
            String nutritionGradeFr = tokens[3];
            String ingredientsObj = tokens[4];
            Float energie100g = Float.parseFloat(tokens[5].replaceFirst("", "0"));
            Float graisse100g = Float.parseFloat(tokens[6].replaceFirst("", "0"));
            Float sucres100g = Float.parseFloat(tokens[7].replaceFirst("", "0"));
            Float fibres100g = Float.parseFloat(tokens[8].replaceFirst("", "0"));
            Float proteines100g = Float.parseFloat(tokens[9].replaceFirst("", "0"));
            Float sel100g = Float.parseFloat(tokens[10].replaceFirst("", "0"));
            Float vitA100g = Float.parseFloat(tokens[11].replaceFirst("", "0"));
            Float vitD100g = Float.parseFloat(tokens[12].replaceFirst("", "0"));
            Float vitE100g = Float.parseFloat(tokens[13].replaceFirst("", "0"));
            Float vitK100g = Float.parseFloat(tokens[14].replaceFirst("", "0"));
            Float vitC100g = Float.parseFloat(tokens[15].replaceFirst("", "0"));
            Float vitB1100g = Float.parseFloat(tokens[16].replaceFirst("", "0"));
            Float vitB2100g = Float.parseFloat(tokens[17].replaceFirst("", "0"));
            Float vitPP100g = Float.parseFloat(tokens[18].replaceFirst("", "0"));
            Float vitB6100g = Float.parseFloat(tokens[19].replaceFirst("", "0"));
            Float vitB9100g = Float.parseFloat(tokens[20].replaceFirst("", "0"));
            Float vitB12100g = Float.parseFloat(tokens[21].replaceFirst("", "0"));
            Float calcium100g = Float.parseFloat(tokens[22].replaceFirst("", "0"));
            Float magnesium100g = Float.parseFloat(tokens[23].replaceFirst("", "0"));
            Float iron100g = Float.parseFloat(tokens[24].replaceFirst("", "0"));
            Float fer100g = Float.parseFloat(tokens[25].replaceFirst("", "0"));
            Float betaCarotene100g = Float.parseFloat(tokens[26].replaceFirst("", "0"));
            Integer presenceHuilePalme = Integer.parseInt(tokens[27]);
            String allergenesObj = tokens[28];
            String additifsObj = tokens[29];
            produits.add(new Produit(nom, energie100g, graisse100g, sucres100g, fibres100g, proteines100g, sel100g, vitA100g, vitD100g, vitE100g, vitK100g, vitC100g, vitB1100g, vitB2100g, vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g, magnesium100g, iron100g, fer100g, betaCarotene100g));

            // marque
            marque = marque.substring(0, 1).toUpperCase() + marque.substring(1);
            marques.add(new Marque(marque));

            // parser les allergènes:
            String allergenesModifies = allergenesObj.replaceAll("en:", "").replace("fr:", "");
            allergenesModifies = allergenesModifies.replaceAll("\\*", "");
            String[] tokensAllergenes = allergenesModifies.split(",");
            for (int i = 0; i < tokensAllergenes.length; i++) {
                String unAllergene = tokensAllergenes[i];
                unAllergene = unAllergene.replaceFirst(" ","").toLowerCase();
                if(!unAllergene.isEmpty()) {
                    allergenes.add(new Allergene(unAllergene));
                }
                // System.out.println(unAllergene);
            }

            // parser les additifs
            if (!additifsObj.isEmpty()) {
                String[] tokensAdditifs = additifsObj.split(",");
                for (int i = 0; i < tokensAdditifs.length; i++) {
                    String unAdditif = tokensAdditifs[i];
                    String[] tokensAdditifsCodeLibelle = unAdditif.split(" - ");
                    String code = tokensAdditifsCodeLibelle[0].toUpperCase();
                    String libelle = tokensAdditifsCodeLibelle[1].toLowerCase();
                    additifs.add(new Additif(code, libelle));
                    //System.out.println(additifs);
                }
            } else {
                String code;
                String libelle;
            }





            // parse les ingrédients
            String ingredientsModifies = ingredientsObj.replaceAll("\\. ", ",");
            ingredientsModifies = ingredientsModifies.replaceAll(" — ", ",");
            ingredientsModifies = ingredientsModifies.replaceAll(" - ", ",");
            ingredientsModifies = ingredientsModifies.replaceAll(";", ",");
            ingredientsModifies = ingredientsModifies.replaceAll("sucre farine de blé oeuf sirop de glucose fructose graisses végétaleslait entier concentré sucré 8.5%humectantbeurre de cacao lait écrémé en poudre 3.2%pâte de cacao lactoserum en poudre de lait beurre concentré émulsifiantalcool sel poudre à leverarômes amidon de froment  peut contenir fruit à coque", "sucre, farine de blé, oeuf, sirop de glucose fructose, graisses végétales, lait entier concentré sucré 8.5%, humectant, beurre de cacao, lait écrémé en poudre 3.2%, pâte de cacao, lactoserum en poudre de lait, beurre concentré, émulsifiant, alcool, sel poudre à lever, arômes, amidon de froment, peut contenir fruit à coque");
            ingredientsModifies = ingredientsModifies.replaceAll("Marmelade de Citrons Confiture d’Ananas et de Fruits de la passion Confiture de Framboises et de Litchis Confiture de Pamplemousses et de Fruits du dragon Confiture de Mangues et de Pêches Confiture de Poires et de Mirabelles Confiture de Fraises à la Verveine Confiture de Framboises et de Groseilles Confiture extra de Cerises et de Mûres Marmelade d’Oranges à la Cannelle Confiture extra de 4 Fruits Marmelade d’Oranges douces et de Mandarines Confiture de Fraises et de Groseilles Confiture extra de Rhubarbe Confiture extra de Fraises et de Fraises des bois Confiture extra de Reines-Claudes Marmelade de 3 Agrumes Confiture d’Abricots et de Pêches Confiture extra de Mirabelles Marmelade d’Oranges douces Confiture extra de Figues Violettes Confiture de Myrtilles et de Cassis Confiture extra de Cerises \\+une surprise de Noël à découvrir….!", "Marmelade de Citrons, Confiture d’Ananas et de Fruits de la passion, Confiture de Framboises et de Litchis, Confiture de Pamplemousses et de Fruits du dragon, Confiture de Mangues et de Pêches, Confiture de Poires et de Mirabelles, Confiture de Fraises à la Verveine, Confiture de Framboises et de Groseilles, Confiture extra de Cerises et de Mûres, Marmelade d’Oranges à la Cannelle, Confiture extra de 4 Fruits, Marmelade d’Oranges douces et de Mandarines, Confiture de Fraises et de Groseilles, Confiture extra de Rhubarbe, Confiture extra de Fraises et de Fraises des bois, Confiture extra de Reines-Claudes, Marmelade de 3 Agrumes, Confiture d’Abricots et de Pêches, Confiture extra de Mirabelles, Marmelade d’Oranges douces, Confiture extra de Figues Violettes, Confiture de Myrtilles et de Cassis, Confiture extra de Cerises +une surprise de Noël à découvrir….!");
            //System.out.println(ingredientsModifies);
                     // Supprimer les chiffres devant un symbole %
            ingredientsModifies = ingredientsModifies.replaceAll("\\d+\\.\\d+(?=\\s*%)", "");
            ingredientsModifies = ingredientsModifies.replaceAll("\\d+(?=\\s*%)", "");


                      // Supprimer les parties entre parenthèses
            ingredientsModifies = ingredientsModifies.replaceAll("\\(.*?\\)", "");
            ingredientsModifies = ingredientsModifies.replaceAll("\\[.*?\\]", "");

                     // Supprimer les symboles %, _, -
            ingredientsModifies = ingredientsModifies.replaceAll("[_\\-]", " ");
            ingredientsModifies = ingredientsModifies.replaceAll("[%\\*]", "");
            //System.out.println(ingredientsModifies);

            //System.out.println(ingredientsModifies);
            String[] tokensIngredients = ingredientsModifies.split(",");

            for (int i = 0; i<tokensIngredients.length; i++){
                String unIngredient = tokensIngredients[i].toLowerCase().replaceFirst(" ", "").replace("\\)", "").replace("\\(", "");
                if (unIngredient.endsWith(".")) {
                    unIngredient = unIngredient.substring(0, unIngredient.length() - 1);
                }
                ingredients.add(new Ingredient(unIngredient));
            }






        }
        //System.out.println(produits);
        //System.out.println(allergenes);
        //System.out.println(additifs);
        //System.out.println(ingredients);

        }


    }




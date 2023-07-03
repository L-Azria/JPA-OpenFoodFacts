package fr.diginamic;

import fr.diginamic.entites.*;
import fr.diginamic.utils.LectureFichier;
import fr.diginamic.utils.TraitementLigne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Cette classe est utilisée pour tester l'import de données depuis un fichier CSV vers une base de données.
 * Elle lit les données à partir d'un fichier CSV, les traite et les enregistre dans une base de données à l'aide de JPA.
 */
public class TestOpenFoodFacts {
    public static void main(String[] args) throws Exception {

        // Lecture du fichier CSV
        Path path = Paths.get("/Users/Lan/Desktop/DIginamic/JPA/Projet JPA (énoncés)/Open Food Facts/open-food-facts.csv");
        List<String> lines = LectureFichier.lectureFichier(path);
        // Supprimer l'en-tête du fichier
        lines.remove(0);

        // Initialisation des ensembles de données, utilisation des Set pour éviter les doublons
        Set<Produit> tousProduits = new HashSet<>();
        Set<Categorie> toutesCategories = new HashSet<>();
        Set<Additif> tousAdditifs = new HashSet<>();
        Set<Allergene> tousAllergenes = new HashSet<>();
        Set<Ingredient> tousIngredients = new HashSet<>();
        Set<Marque> toutesMarques = new HashSet<>();
        Set<NutritionGradeFr> toutesNutritionGradeFr = new HashSet<>();

        // Mesure du temps d'exécution
        long startTime = System.currentTimeMillis();

        // Parcours des lignes du fichier CSV
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("OpenFoodFacts");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction et = em.getTransaction();
            et.begin();

            /**
             * Parcourt chaque ligne de la liste 'lines' et crée les objets correspondants aux données extraites de chaque ligne.
             * Les objets créés comprennent un Produit, une Categorie, des Additifs, des Allergenes, des Ingredients, une Marque et un NutritionGradeFr.
             * Les données de chaque ligne sont extraites à l'aide de la méthode 'traitementLigne' de la classe TraitementLigne.
             *
             * @param lines la liste des lignes contenant les données à traiter
             */

            for (String line : lines) {
                // Création des objets correspondant aux données de la ligne
                Produit produit;
                Categorie categorieProduit;
                Set<Additif> additifs = new HashSet<>();
                Set<Allergene> allergenes = new HashSet<>();
                Set<Ingredient> ingredients = new HashSet<>();
                Marque marqueProduit;
                NutritionGradeFr nutritionGradeProduit;

                // Traitement de la ligne pour extraire les données, en utilisant la méthode de la classe "TraitementLigne"
                String[] tokens = TraitementLigne.traitementLigne(line);

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

                // Création l'objet 'produit' à partir des données extraites
                produit = new Produit(nom, energie100g, graisse100g, sucres100g, fibres100g, proteines100g, sel100g, vitA100g, vitD100g, vitE100g, vitK100g, vitC100g, vitB1100g, vitB2100g, vitPP100g, vitB6100g, vitB9100g, vitB12100g, calcium100g, magnesium100g, iron100g, fer100g, betaCarotene100g);

                // Création l'objet 'nutritionGradeProduit' à partir des données extraites
                nutritionGradeFr = nutritionGradeFr.toUpperCase();
                nutritionGradeProduit = new NutritionGradeFr(nutritionGradeFr);

                // Création l'objet 'marqueProduit' à partir des données extraites
                marque = marque.substring(0, 1).toUpperCase() + marque.substring(1);
                marqueProduit = new Marque(marque);

                // Création l'objet 'categorieProduit' à partir des données extraites
                categorie = categorie.substring(0, 1).toUpperCase() + categorie.substring(1);
                categorieProduit = new Categorie(categorie);

                /**
                 * Modifie la chaîne de caractères 'allergenesObj' en supprimant les préfixes inutiles et les astérisques,
                 * puis extrait les allergènes individuels en les séparant par des virgules.
                 * Pour chaque allergène extrait, le transforme en minuscules et supprime les espaces en début de chaîne.
                 * Enfin, crée des objets Allergene à partir des allergènes extraits et les ajoute à l'ensemble 'allergenes'.
                 *
                 * @param allergenesObj la chaîne de caractères contenant les informations sur les allergènes
                 */

                // Supprime les préfixes "en:" et "fr:" ainsi que les astérisques de la chaîne 'allergenesObj'
                String allergenesModifies = allergenesObj.replaceAll("en:", "").replace("fr:", "");
                allergenesModifies = allergenesModifies.replaceAll("\\*", "");
                // Sépare les allergènes individuels en utilisant la virgule comme délimiteur
                String[] tokensAllergenes = allergenesModifies.split(",");
                // Parcourt chaque allergène extrait
                for (int i = 0; i < tokensAllergenes.length; i++) {
                    String unAllergene = tokensAllergenes[i];
                    // Supprime les espaces en début de chaîne et met l'allergène en minuscules
                    unAllergene = unAllergene.replaceFirst(" ", "").toLowerCase();
                    // Vérifie si l'allergène n'est pas vide
                    if (!unAllergene.isEmpty()) {
                        // Crée un objet Allergene avec l'allergène extrait et l'ajoute à l'ensemble 'allergenes'
                        allergenes.add(new Allergene(unAllergene));
                    }
                }

                /**
                 * Traite les informations sur les additifs à partir de la chaîne de caractères 'additifsObj'.
                 * Si la chaîne n'est pas vide, extrait les additifs individuels en les séparant par des virgules.
                 * Pour chaque additif extrait, sépare le code et le libellé en utilisant le séparateur " - ".
                 * Convertit le code en majuscules et le libellé en minuscules.
                 * Enfin, crée des objets Additif à partir des informations extraites et les ajoute à l'ensemble 'additifs'.
                 *
                 * @param additifsObj la chaîne de caractères contenant les informations sur les additifs
                 */
                if (!additifsObj.isEmpty()) {
                    String[] tokensAdditifs = additifsObj.split(",");
                    for (int i = 0; i < tokensAdditifs.length; i++) {
                        String unAdditif = tokensAdditifs[i];
                        String[] tokensAdditifsCodeLibelle = unAdditif.split(" - ");
                        String code = tokensAdditifsCodeLibelle[0].toUpperCase();
                        String libelle = tokensAdditifsCodeLibelle[1].toLowerCase();
                        additifs.add(new Additif(code, libelle));

                    }
                } else {
                    String code;
                    String libelle;
                }

                /**
                 * Traite les informations sur les ingrédients à partir de la chaîne de caractères 'ingredientsObj'.
                 * Effectue une série de modifications sur la chaîne pour préparer les données avant l'extraction des ingrédients.
                 * Les modifications comprennent le remplacement de certains symboles et caractères spéciaux, la suppression des chiffres
                 * devant les symboles de pourcentage (%), la suppression des parties entre parenthèses et crochets, et la conversion
                 * des ingrédients en minuscules.
                 * Enfin, crée des objets Ingredient à partir des informations extraites et les ajoute à l'ensemble 'ingredients'.
                 *
                 * @param ingredientsObj la chaîne de caractères contenant les informations sur les ingrédients
                 */

                // Remplace certains symboles et caractères spéciaux par des virgules pour séparer les ingrédients individuels
                String ingredientsModifies = ingredientsObj.replaceAll("\\. ", ",");
                ingredientsModifies = ingredientsModifies.replaceAll(" — ", ",");
                ingredientsModifies = ingredientsModifies.replaceAll(" - ", ",");
                ingredientsModifies = ingredientsModifies.replaceAll(";", ",");
                ingredientsModifies = ingredientsModifies.replaceAll("sucre farine de blé oeuf sirop de glucose fructose graisses végétaleslait entier concentré sucré 8.5%humectantbeurre de cacao lait écrémé en poudre 3.2%pâte de cacao lactoserum en poudre de lait beurre concentré émulsifiantalcool sel poudre à leverarômes amidon de froment  peut contenir fruit à coque", "sucre, farine de blé, oeuf, sirop de glucose fructose, graisses végétales, lait entier concentré sucré 8.5%, humectant, beurre de cacao, lait écrémé en poudre 3.2%, pâte de cacao, lactoserum en poudre de lait, beurre concentré, émulsifiant, alcool, sel poudre à lever, arômes, amidon de froment, peut contenir fruit à coque");
                ingredientsModifies = ingredientsModifies.replaceAll("Marmelade de Citrons Confiture d’Ananas et de Fruits de la passion Confiture de Framboises et de Litchis Confiture de Pamplemousses et de Fruits du dragon Confiture de Mangues et de Pêches Confiture de Poires et de Mirabelles Confiture de Fraises à la Verveine Confiture de Framboises et de Groseilles Confiture extra de Cerises et de Mûres Marmelade d’Oranges à la Cannelle Confiture extra de 4 Fruits Marmelade d’Oranges douces et de Mandarines Confiture de Fraises et de Groseilles Confiture extra de Rhubarbe Confiture extra de Fraises et de Fraises des bois Confiture extra de Reines-Claudes Marmelade de 3 Agrumes Confiture d’Abricots et de Pêches Confiture extra de Mirabelles Marmelade d’Oranges douces Confiture extra de Figues Violettes Confiture de Myrtilles et de Cassis Confiture extra de Cerises \\+une surprise de Noël à découvrir….!", "Marmelade de Citrons, Confiture d’Ananas et de Fruits de la passion, Confiture de Framboises et de Litchis, Confiture de Pamplemousses et de Fruits du dragon, Confiture de Mangues et de Pêches, Confiture de Poires et de Mirabelles, Confiture de Fraises à la Verveine, Confiture de Framboises et de Groseilles, Confiture extra de Cerises et de Mûres, Marmelade d’Oranges à la Cannelle, Confiture extra de 4 Fruits, Marmelade d’Oranges douces et de Mandarines, Confiture de Fraises et de Groseilles, Confiture extra de Rhubarbe, Confiture extra de Fraises et de Fraises des bois, Confiture extra de Reines-Claudes, Marmelade de 3 Agrumes, Confiture d’Abricots et de Pêches, Confiture extra de Mirabelles, Marmelade d’Oranges douces, Confiture extra de Figues Violettes, Confiture de Myrtilles et de Cassis, Confiture extra de Cerises +une surprise de Noël à découvrir….!");

                // Supprimer les chiffres devant un symbole %
                ingredientsModifies = ingredientsModifies.replaceAll("\\d+\\.\\d+(?=\\s*%)", "");
                ingredientsModifies = ingredientsModifies.replaceAll("\\d+(?=\\s*%)", "");


                // Supprimer les parties entre parenthèses et crochets
                ingredientsModifies = ingredientsModifies.replaceAll("\\(.*?\\)", "");
                ingredientsModifies = ingredientsModifies.replaceAll("\\[.*?\\]", "");

                // Supprime certains symboles (% et *) et remplace les symboles _ et - par un espace
                ingredientsModifies = ingredientsModifies.replaceAll("[_\\-]", " ");
                ingredientsModifies = ingredientsModifies.replaceAll("[%\\*]", "");

                // Sépare les ingrédients individuels en utilisant la virgule comme délimiteur
                String[] tokensIngredients = ingredientsModifies.split(",");

                // Parcourt chaque ingrédient extrait
                for (int i = 0; i < tokensIngredients.length; i++) {
                    // Récupère l'ingrédient courant en minuscules et effectue des remplacements
                    String unIngredient = tokensIngredients[i].toLowerCase().replaceFirst(" ", "").replace("\\)", "").replace("\\(", "");
                    // Supprime le point final s'il est présent à la fin de l'ingrédient
                    if (unIngredient.endsWith(".")) {
                        unIngredient = unIngredient.substring(0, unIngredient.length() - 1);
                    }
                    // Crée un objet Ingredient avec l'ingrédient extrait et l'ajoute à l'ensemble 'ingredients'
                    ingredients.add(new Ingredient(unIngredient));
                }


                /**
                 * Parcourt chaque allergène de l'ensemble 'allergenes' et effectue les actions correspondantes en fonction de leur présence
                 * dans l'ensemble 'tousAllergenes'. Si un allergène existe déjà dans 'tousAllergenes', il est ajouté au produit en utilisant
                 * la méthode addAllergene(). Sinon, un nouvel objet Allergene est créé, ajouté à 'tousAllergenes' et au produit.
                 * Cette méthode garantit que chaque allergène du produit est associé à un objet Allergene unique dans 'tousAllergenes'.
                 *
                 * @param allergenes     l'ensemble des allergènes du produit
                 * @param tousAllergenes l'ensemble global de tous les allergènes existants
                 * @param produit        l'objet Produit auquel les allergènes doivent être associés
                 */
                for (Allergene a : allergenes) {
                    if (tousAllergenes.contains(a)) {
                        for (Allergene all : tousAllergenes) {
                            if (all.equals(a)) {
                                produit.addAllergene(all);
                            }
                        }

                    } else {
                        a = new Allergene(a.getLibelle());
                        tousAllergenes.add(a);
                        produit.addAllergene(a);
                    }
                }

                // la même méthode est appliquée pour 'additifs'
                for (Additif a : additifs) {
                    if (tousAdditifs.contains(a)) {
                        for (Additif add : tousAdditifs) {
                            if (add.equals(a)) {
                                produit.addAdditif(add);
                            }
                        }
                    } else {
                        tousAdditifs.add(a);
                        produit.addAdditif(a);
                    }
                }

                // la même méthode est appliquée pour 'ingredients'
                for (Ingredient i : ingredients) {
                    if (tousIngredients.contains(i)) {
                        for (Ingredient ing : tousIngredients) {
                            if (ing.equals(i)) {
                                produit.addIngredient(ing);
                            }
                        }
                    } else {
                        tousIngredients.add(i);
                        produit.addIngredient(i);
                    }
                }

                /**
                 * Vérifie si la catégorie du produit existe déjà dans l'ensemble 'toutesCategories'.
                 * Si oui, associe la catégorie existante au produit en utilisant la méthode setCategorie().
                 * Sinon, ajoute la nouvelle catégorie à 'toutesCategories', associe la catégorie au produit et la persiste en utilisant
                 * la méthode persist() de l'EntityManager.
                 *
                 * @param categorieProduit  la catégorie du produit
                 * @param toutesCategories  l'ensemble global de toutes les catégories existantes
                 * @param produit           l'objet Produit auquel la catégorie doit être associée
                 * @param em                l'EntityManager pour la persistence de la nouvelle catégorie
                 */
                if (toutesCategories.contains(categorieProduit)) {
                    // La catégorie existe déjà dans 'toutesCategories', la récupérer et l'associer au produit
                    for (Categorie c : toutesCategories) {
                        if (categorieProduit.equals(c)) {
                            produit.setCategorie(c);
                        }
                    }
                } else {
                    // La catégorie n'existe pas dans 'toutesCategories', l'ajouter, l'associer au produit et la persister
                    toutesCategories.add(categorieProduit);
                    produit.setCategorie(categorieProduit);
                    em.persist(categorieProduit);
                }

                // la même méthode est appliquée pour 'marqueProduit'
                if (toutesMarques.contains(marqueProduit)) {
                    for (Marque m : toutesMarques) {
                        if (marqueProduit.equals(m)) {
                            produit.setMarque(m);
                        }
                    }
                } else {
                    toutesMarques.add(marqueProduit);
                    produit.setMarque(marqueProduit);
                    em.persist(marqueProduit);
                }

                // la même méthode est appliquée pour 'nutritionGradeProduit'
                if (toutesNutritionGradeFr.contains(nutritionGradeProduit)) {
                    for (NutritionGradeFr n : toutesNutritionGradeFr) {
                        if (nutritionGradeProduit.equals(n)) {
                            produit.setNutritionGradeFr(n);
                        }
                    }
                } else {
                    toutesNutritionGradeFr.add(nutritionGradeProduit);
                    produit.setNutritionGradeFr(nutritionGradeProduit);
                    em.persist(nutritionGradeProduit);
                }

            }
            et.commit();
        }


        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime / 1000 + " seconds");

    }
}




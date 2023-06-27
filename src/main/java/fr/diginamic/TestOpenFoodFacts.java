package fr.diginamic;

import fr.diginamic.entites.*;
import fr.diginamic.utils.TraitementFichier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TestOpenFoodFacts {
    public static void main(String[] args) throws Exception {
        TraitementFichier traitementFichier = new TraitementFichier();
        Path path = Paths.get("/Users/Lan/Desktop/DIginamic/JPA/Projet JPA (énoncés)/Open Food Facts/open-food-facts.csv");
        traitementFichier.traitementFichier(path);
        Set<Allergene> allergeneSet = traitementFichier.getAllergenes();
        Set<Additif> additifSet = traitementFichier.getAdditifs();
        Set<Ingredient> ingredientSet = traitementFichier.getIngredients();
        Set<Produit> produitSet = traitementFichier.getProduits();
        Set<Marque> marqueSet = traitementFichier.getMarques();

        Produit produit = new Produit();
        Allergene allergene = new Allergene();




        //System.out.println(allergeneSet);
        long startTime = System.currentTimeMillis();
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("OpenFoodFacts");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction et = em.getTransaction();
            et.begin();


            for (Allergene a : allergeneSet) {

                em.persist(a);

                if(produit.getAllergenes().contains(a)){
                    produit.addAllergene(a);
                }

/*                if (allergene.equals(a)) {
                    produit.addAllergene(allergene);
                    em.persist(allergene);
                } else {
                    allergene = new Allergene(a.getLibelle());
                    allergeneSet.add(a);
                    produit.addAllergene(allergene);
                    //allergene.addProduit(produit);
                }*/
            }


            for (Produit p : produitSet) {
                em.persist(p);

            }






/*
            for (Allergene allergene:allergeneSet){
                em.persist(allergene);
            }
            for (Additif additif:additifSet){
                em.persist(additif);
            }
            for (Ingredient ingredient:ingredientSet){
                //System.out.println(ingredient);
                em.persist(ingredient);
            }
            for (Produit produit:produitSet){
                em.persist(produit);
            }
            for(Marque marque:marqueSet){

                em.persist(marque);
            }

 */


            et.commit();

        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime / 1000 + " seconds");
    }
}



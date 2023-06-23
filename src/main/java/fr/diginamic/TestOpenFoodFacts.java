package fr.diginamic;

import fr.diginamic.entites.Marque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;

public class TestOpenFoodFacts {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("OpenFoodFacts");
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction et = em.getTransaction();
            et.begin();



            et.commit();
            }

        }
    }


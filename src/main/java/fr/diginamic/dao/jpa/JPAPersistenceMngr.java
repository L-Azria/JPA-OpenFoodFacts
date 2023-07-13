package fr.diginamic.dao.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jdk.jfr.Percentage;

public final class JPAPersistenceMngr {

    private static EntityManagerFactory entityManagerFactory;
    private JPAPersistenceMngr() {}


    public static EntityManagerFactory getEMF() {

        if (null == entityManagerFactory){
            entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        }
        return entityManagerFactory;
    }

}

package fr.diginamic.dao.jpa;

import fr.diginamic.dao.IProduitDAO;
import fr.diginamic.entites.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class ProduitDAOJPA implements IProduitDAO {
    @Override
    public List<Produit> extraire() {
        EntityManagerFactory emf = JPAPersistenceMngr.getEMF();
        //TODO à implémenter
        return null;
    }

    @Override
    public void saveAll(List<Produit> produits) {

        EntityManagerFactory emf = JPAPersistenceMngr.getEMF();
        try(EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            for (Produit item:produits) {
                em.persist(item);
            }
            em.getTransaction().commit();
        }
    }
}

package fr.diginamic.dao.jdbc;

import fr.diginamic.dao.IProduitDAO;
import fr.diginamic.entites.Produit;

import java.util.List;

public class ProduitDAOJDBC implements IProduitDAO {
    @Override
    public List<Produit> extraire() {
        //TODO implémentation accès au données avec JDBC pure ici
        return null;
    }

    @Override
    public void saveAll(List<Produit> produits) {
        //TODO implémentation accès au données avec JDBC pure ici
    }
}

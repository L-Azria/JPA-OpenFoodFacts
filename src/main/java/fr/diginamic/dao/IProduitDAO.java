package fr.diginamic.dao;

import fr.diginamic.entites.Produit;

import java.util.List;

public interface IProduitDAO {
    List<Produit> extraire();

    void saveAll(List<Produit> produits);
}

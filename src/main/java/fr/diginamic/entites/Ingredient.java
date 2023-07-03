package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Représente un ingrédient.
 * Un ingrédient est caractérisé par son libellé.
 * Il peut être associé à plusieurs produits.
 */
@Entity
@Table
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @ManyToMany(mappedBy = "ingredients")
    private Set<Produit> produits = new HashSet<>();

    public Ingredient() {
    }

    public Ingredient(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                ", libelle='" + libelle +
                "}\n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    /**
     * Ajoute un produit à la liste des produits associés à l'ingrédient.
     *
     * @param produit le produit à ajouter
     */
    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
    public void addProduit (Produit produit) {
        if (null != produit) {
            produits.add(produit);
        }
    }
}

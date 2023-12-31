package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Représente un allergène.
 * Un allergène est caractérisé par un libellé.
 * Il peut être associé à plusieurs produits.
 */
@Entity
@Table
public class Allergene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @ManyToMany(mappedBy = "allergenes")
    private Set<Produit> produits = new HashSet<>();

    public Allergene() {
    }

    public Allergene(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Allergene{ id='" + id +
                "', libelle='" + libelle + '\'' +
                "} \n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allergene allergene = (Allergene) o;
        return Objects.equals(libelle, allergene.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
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


    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    /**
     * Ajoute un produit à la liste des produits associés à l'allergène.
     *
     * @param produit le produit à ajouter
     */
    public void addProduit (Produit produit){
        if(null != produit){
            produits.add(produit);
        }
    }

}

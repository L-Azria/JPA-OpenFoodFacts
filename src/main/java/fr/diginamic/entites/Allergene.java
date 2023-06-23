package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Allergene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;

    @ManyToMany(mappedBy = "allergenes")
    private Set<Produit> produits;

    public Allergene() {
    }

    @Override
    public String toString() {
        return "Allergene{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
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
}

package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categorie;

    @OneToMany(mappedBy = "categorie")
    private Set<Produit> produits;

    public Categorie() {
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}

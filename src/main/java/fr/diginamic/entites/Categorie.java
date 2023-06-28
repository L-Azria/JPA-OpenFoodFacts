package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categorie;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.PERSIST)
    private Set<Produit> produits = new HashSet<>();

    public Categorie() {
    }

    public Categorie(String categorie, Set<Produit> produits) {
        this.categorie = categorie;
        this.produits = produits;
    }

    public Categorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie(Integer id, String categorie) {
        this.id = id;
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", categorie='" + categorie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie1 = (Categorie) o;
        return Objects.equals(categorie, categorie1.categorie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorie);
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
    public void addProduit (Produit produit){
        if (null != produit){
            produit.setCategorie(this);
        }
    }
}

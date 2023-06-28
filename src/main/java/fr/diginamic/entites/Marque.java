package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String marque;

    @OneToMany(mappedBy = "marque")
    private Set<Produit> produits = new HashSet<>();

    public Marque() {
    }

    public Marque(String marque, Set<Produit> produits) {
        this.marque = marque;
        this.produits = produits;
    }


    public Marque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", marque='" + marque + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque1 = (Marque) o;
        return Objects.equals(marque, marque1.marque);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public void addProduit (Produit produit) {
        if (null != produit) {
            produit.setMarque(this);
        }
    }
}

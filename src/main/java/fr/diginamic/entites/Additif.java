package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table
public class Additif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String libelle;

    @ManyToMany(mappedBy = "additifs")
    private Set<Produit> produits;

    public Additif() {
    }

    @Override
    public String toString() {
        return "Additif{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

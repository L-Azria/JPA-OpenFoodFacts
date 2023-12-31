package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Représente un additif.
 * Un additif est caractérisé par un code et un libellé.
 * Il peut être associé à plusieurs produits.
 */
@Entity
@Table
public class Additif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String libelle;

    @ManyToMany(mappedBy = "additifs")
    private Set<Produit> produits  = new HashSet<>();

    public Additif() {
    }

    public Additif(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Additif{" +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                "} \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Additif additif = (Additif) o;
        return Objects.equals(code, additif.code) && Objects.equals(libelle, additif.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle);
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
    /**
     * Ajoute un produit à la liste des produits associés à l'additif.
     *
     * @param produit le produit à ajouter
     */
    public void addProduit (Produit produit){
        if(null != produit){
            produits.add(produit);
        }
    }
}

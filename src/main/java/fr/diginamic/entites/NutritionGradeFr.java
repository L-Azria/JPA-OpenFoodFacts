package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Représente un grade de nutrition de produits.
 * Un grade de nutrition est caractérisée par un identifiant et une grade.
 * Elle peut contenir plusieurs produits associés.
 */
@Entity
@Table
public class NutritionGradeFr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grade;

    @OneToMany(mappedBy = "nutritionGradeFr")
    private Set<Produit> produits = new HashSet<>();

    public NutritionGradeFr() {
    }

    public NutritionGradeFr(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "NutritionGradeFr{" +
                "id=" + id +
                ", grade='" + grade + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NutritionGradeFr that = (NutritionGradeFr) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    /**
     * Ajoute un produit à la NutritionGrade.
     *
     * @param produit le produit à ajouter
     */
    public void addProduit (Produit produit) {
        if (null != produit) {
            produit.setNutritionGradeFr(this);
        }
    }
}

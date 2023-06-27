package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class NutritionGradeFr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String grade;

    @OneToMany(mappedBy = "nutritionGradeFr")
    private Set<Produit> produits;

    public NutritionGradeFr() {
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
        return Objects.equals(id, that.id) && Objects.equals(grade, that.grade) && Objects.equals(produits, that.produits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grade, produits);
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
}

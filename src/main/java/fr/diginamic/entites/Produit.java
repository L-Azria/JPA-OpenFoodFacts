package fr.diginamic.entites;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/**
 * Représente un produit.
 * Un produit est caractérisé par ses différentes informations nutritionnelles et ses associations avec une catégorie, une marque, une valeur de nutrition pour 100g, des ingrédients, des allergènes et des additifs.
 */
@Entity
@Table
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomProduit;
    private float energiePour100g;
    private float graissePour100g;
    private float sucresPour100g;
    private float fibresPour100g;
    private float proteinesPour100g;
    private float selPour100g;
    private float vitAPour100g;
    private float vitDPour100g;
    private float vitEPour100g;
    private float vitKPour100g;
    private float vitCPour100g;
    private float vitB1Pour100g;
    private float vitB2Pour100g;
    private float vitPPPour100g;
    private float vitB6Pour100g;
    private float vitB9Pour100g;
    private float vitB12Pour100g;
    private float calciumPour100g;
    private float magnesiumPour100g;
    private float ironPour100g;
    private float ferPour100g;
    private float betaCarotenePour100g;


    @ManyToOne
    @JoinColumn
    private Categorie categorie;

    @ManyToOne
    @JoinColumn
    private Marque marque;
    @ManyToOne
    @JoinColumn
    private NutritionGradeFr nutritionGradeFr;

    @ManyToMany (cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    )
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "allergene_id", referencedColumnName = "id")
    )
    private Set<Allergene> allergenes = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            joinColumns = @JoinColumn(name = "produit_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "additif_id", referencedColumnName = "id")
    )
    private Set<Additif> additifs = new HashSet<>();


    public Produit() {
    }

    public Produit(String nomProduit, float energiePour100g, float graissePour100g, float sucresPour100g, float fibresPour100g, float proteinesPour100g, float selPour100g, float vitAPour100g, float vitDPour100g, float vitEPour100g, float vitKPour100g, float vitCPour100g, float vitB1Pour100g, float vitB2Pour100g, float vitPPPour100g, float vitB6Pour100g, float vitB9Pour100g, float vitB12Pour100g, float calciumPour100g, float magnesiumPour100g, float ironPour100g, float ferPour100g, float betaCarotenePour100g, Categorie categorie, Marque marque, NutritionGradeFr nutritionGradeFr, Set<Ingredient> ingredients, Set<Allergene> allergenes, Set<Additif> additifs) {
        this.nomProduit = nomProduit;
        this.energiePour100g = energiePour100g;
        this.graissePour100g = graissePour100g;
        this.sucresPour100g = sucresPour100g;
        this.fibresPour100g = fibresPour100g;
        this.proteinesPour100g = proteinesPour100g;
        this.selPour100g = selPour100g;
        this.vitAPour100g = vitAPour100g;
        this.vitDPour100g = vitDPour100g;
        this.vitEPour100g = vitEPour100g;
        this.vitKPour100g = vitKPour100g;
        this.vitCPour100g = vitCPour100g;
        this.vitB1Pour100g = vitB1Pour100g;
        this.vitB2Pour100g = vitB2Pour100g;
        this.vitPPPour100g = vitPPPour100g;
        this.vitB6Pour100g = vitB6Pour100g;
        this.vitB9Pour100g = vitB9Pour100g;
        this.vitB12Pour100g = vitB12Pour100g;
        this.calciumPour100g = calciumPour100g;
        this.magnesiumPour100g = magnesiumPour100g;
        this.ironPour100g = ironPour100g;
        this.ferPour100g = ferPour100g;
        this.betaCarotenePour100g = betaCarotenePour100g;
        this.categorie = categorie;
        this.marque = marque;
        this.nutritionGradeFr = nutritionGradeFr;
        this.ingredients = ingredients;
        this.allergenes = allergenes;
        this.additifs = additifs;
    }

    public Produit(String nomProduit, float energiePour100g, float graissePour100g, float sucresPour100g, float fibresPour100g, float proteinesPour100g, float selPour100g, float vitAPour100g, float vitDPour100g, float vitEPour100g, float vitKPour100g, float vitCPour100g, float vitB1Pour100g, float vitB2Pour100g, float vitPPPour100g, float vitB6Pour100g, float vitB9Pour100g, float vitB12Pour100g, float calciumPour100g, float magnesiumPour100g, float ironPour100g, float ferPour100g, float betaCarotenePour100g) {
        this.nomProduit = nomProduit;
        this.energiePour100g = energiePour100g;
        this.graissePour100g = graissePour100g;
        this.sucresPour100g = sucresPour100g;
        this.fibresPour100g = fibresPour100g;
        this.proteinesPour100g = proteinesPour100g;
        this.selPour100g = selPour100g;
        this.vitAPour100g = vitAPour100g;
        this.vitDPour100g = vitDPour100g;
        this.vitEPour100g = vitEPour100g;
        this.vitKPour100g = vitKPour100g;
        this.vitCPour100g = vitCPour100g;
        this.vitB1Pour100g = vitB1Pour100g;
        this.vitB2Pour100g = vitB2Pour100g;
        this.vitPPPour100g = vitPPPour100g;
        this.vitB6Pour100g = vitB6Pour100g;
        this.vitB9Pour100g = vitB9Pour100g;
        this.vitB12Pour100g = vitB12Pour100g;
        this.calciumPour100g = calciumPour100g;
        this.magnesiumPour100g = magnesiumPour100g;
        this.ironPour100g = ironPour100g;
        this.ferPour100g = ferPour100g;
        this.betaCarotenePour100g = betaCarotenePour100g;
    }


    @Override
    public String toString() {
        return "Produit{" +
                "nomProduit='" + nomProduit + '\'' +
                ", energiePour100g=" + energiePour100g +
                ", graissePour100g=" + graissePour100g +
                ", sucresPour100g=" + sucresPour100g +
                ", fibresPour100g=" + fibresPour100g +
                ", proteinesPour100g=" + proteinesPour100g +
                ", selPour100g=" + selPour100g +
                ", vitAPour100g=" + vitAPour100g +
                ", vitDPour100g=" + vitDPour100g +
                ", vitEPour100g=" + vitEPour100g +
                ", vitKPour100g=" + vitKPour100g +
                ", vitCPour100g=" + vitCPour100g +
                ", vitB1Pour100g=" + vitB1Pour100g +
                ", vitB2Pour100g=" + vitB2Pour100g +
                ", vitPPPour100g=" + vitPPPour100g +
                ", vitB6Pour100g=" + vitB6Pour100g +
                ", vitB9Pour100g=" + vitB9Pour100g +
                ", vitB12Pour100g=" + vitB12Pour100g +
                ", calciumPour100g=" + calciumPour100g +
                ", magnesiumPour100g=" + magnesiumPour100g +
                ", ironPour100g=" + ironPour100g +
                ", ferPour100g=" + ferPour100g +
                ", betaCarotenePour100g=" + betaCarotenePour100g +
                "} \n";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public float getEnergiePour100g() {
        return energiePour100g;
    }

    public void setEnergiePour100g(float energiePour100g) {
        this.energiePour100g = energiePour100g;
    }

    public float getGraissePour100g() {
        return graissePour100g;
    }

    public void setGraissePour100g(float graissePour100g) {
        this.graissePour100g = graissePour100g;
    }

    public float getIronPour100g() {
        return ironPour100g;
    }

    public void setIronPour100g(float ironPour100g) {
        this.ironPour100g = ironPour100g;
    }

    public float getFerPour100g() {
        return ferPour100g;
    }

    public void setFerPour100g(float ferPour100g) {
        this.ferPour100g = ferPour100g;
    }

    public float getSucresPour100g() {
        return sucresPour100g;
    }

    public void setSucresPour100g(float sucresPour100g) {
        this.sucresPour100g = sucresPour100g;
    }

    public float getFibresPour100g() {
        return fibresPour100g;
    }

    public void setFibresPour100g(float fibresPour100g) {
        this.fibresPour100g = fibresPour100g;
    }

    public float getProteinesPour100g() {
        return proteinesPour100g;
    }

    public void setProteinesPour100g(float proteinesPour100g) {
        this.proteinesPour100g = proteinesPour100g;
    }

    public float getBetaCarotenePour100g() {
        return betaCarotenePour100g;
    }

    public void setBetaCarotenePour100g(float betaCarotenePour100g) {
        this.betaCarotenePour100g = betaCarotenePour100g;
    }

    public float getSelPour100g() {
        return selPour100g;
    }

    public void setSelPour100g(float selPour100g) {
        this.selPour100g = selPour100g;
    }

    public float getVitAPour100g() {
        return vitAPour100g;
    }

    public void setVitAPour100g(float vitAPour100g) {
        this.vitAPour100g = vitAPour100g;
    }

    public float getVitDPour100g() {
        return vitDPour100g;
    }

    public void setVitDPour100g(float vitDPour100g) {
        this.vitDPour100g = vitDPour100g;
    }

    public float getVitEPour100g() {
        return vitEPour100g;
    }

    public void setVitEPour100g(float vitEPour100g) {
        this.vitEPour100g = vitEPour100g;
    }

    public float getVitKPour100g() {
        return vitKPour100g;
    }

    public void setVitKPour100g(float vitKPour100g) {
        this.vitKPour100g = vitKPour100g;
    }

    public float getVitCPour100g() {
        return vitCPour100g;
    }

    public void setVitCPour100g(float vitCPour100g) {
        this.vitCPour100g = vitCPour100g;
    }

    public float getVitB1Pour100g() {
        return vitB1Pour100g;
    }

    public void setVitB1Pour100g(float vitB1Pour100g) {
        this.vitB1Pour100g = vitB1Pour100g;
    }

    public float getVitPPPour100g() {
        return vitPPPour100g;
    }

    public void setVitPPPour100g(float vitPPPour100g) {
        this.vitPPPour100g = vitPPPour100g;
    }

    public float getVitB6Pour100g() {
        return vitB6Pour100g;
    }

    public void setVitB6Pour100g(float vitB6Pour100g) {
        this.vitB6Pour100g = vitB6Pour100g;
    }

    public float getVitB9Pour100g() {
        return vitB9Pour100g;
    }

    public void setVitB9Pour100g(float vitB9Pour100g) {
        this.vitB9Pour100g = vitB9Pour100g;
    }

    public float getVitB12Pour100g() {
        return vitB12Pour100g;
    }

    public void setVitB12Pour100g(float vitB12Pour100g) {
        this.vitB12Pour100g = vitB12Pour100g;
    }

    public float getCalciumPour100g() {
        return calciumPour100g;
    }

    public void setCalciumPour100g(float calciumPour100g) {
        this.calciumPour100g = calciumPour100g;
    }

    public float getMagnesiumPour100g() {
        return magnesiumPour100g;
    }

    public void setMagnesiumPour100g(float magnesiumPour100g) {
        this.magnesiumPour100g = magnesiumPour100g;
    }

    public float getVitB2Pour100g() {
        return vitB2Pour100g;
    }

    public void setVitB2Pour100g(float vitB2Pour100g) {
        this.vitB2Pour100g = vitB2Pour100g;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Définit la catégorie du produit.
     * Si le produit était précédemment associé à une autre catégorie, il est retiré de cette catégorie.
     * Ensuite, le produit est ajouté à la nouvelle catégorie spécifiée.
     *
     * @param categorie la catégorie à associer au produit
     */
    public void setCategorie(Categorie categorie) {
        if(null != this.categorie){
            this.categorie.getProduits().remove(this);
        }
        this.categorie = categorie;
        if (null != this.categorie){
            this.categorie.getProduits().add(this);
        }
    }

    public Marque getMarque() {
        return marque;
    }

    /**
     * Définit la marque du produit.
     * Si le produit était précédemment associé à une autre marque, il est retiré de cette marque.
     * Ensuite, le produit est ajouté à la nouvelle marque spécifiée.
     *
     * @param marque la marque à associer au produit
     */
    public void setMarque(Marque marque) {
        if(null != this.marque){
            this.marque.getProduits().remove(this);
        }
        this.marque = marque;
        if (null != this.marque){
            this.marque.getProduits().add(this);
        }
    }

    /**
     * Définit le grade nutritionnel du produit.
     * Si le produit était précédemment associé à un autre grade nutritionnel, il est retiré de ce grade nutritionnel.
     * Ensuite, le produit est ajouté au nouveau grade nutritionnel spécifié.
     *
     */
    public NutritionGradeFr getNutritionGradeFr() {
        return nutritionGradeFr;
    }

    public void setNutritionGradeFr(NutritionGradeFr nutritionGradeFr) {
        if(null != this.nutritionGradeFr){
            this.nutritionGradeFr.getProduits().remove(this);
        }
        this.nutritionGradeFr = nutritionGradeFr;
        if (null != this.nutritionGradeFr){
            this.nutritionGradeFr.getProduits().add(this);
        }
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;

    }

    public Set<Additif> getAdditifs() {
        return additifs;
    }

    public void setAdditifs(Set<Additif> additifs) {
        this.additifs = additifs;
    }

    /**
     * Ajoute un allergène au produit.
     * Si l'allergène spécifié n'est pas nul, il est ajouté à l'ensemble des allergènes du produit
     * et le produit est ajouté à l'ensemble des produits associés à l'allergène.
     *
     * @param allergene l'allergène à ajouter
     */
    public void addAllergene(Allergene allergene) {
        if (null != allergene) {
            allergenes.add(allergene);
            allergene.addProduit(this);
        }
    }

    /**
     * Ajoute un additif au produit.
     * Si l'additif spécifié n'est pas nul, il est ajouté à l'ensemble des additifs du produit
     * et le produit est ajouté à l'ensemble des produits associés à l'additif.
     *
     * @param additif l'additif à ajouter
     */
    public void addAdditif(Additif additif) {
        if (null != additif) {
            additifs.add(additif);
            additif.addProduit(this);
        }

    }

    /**
     * Ajoute un ingrédient au produit.
     * Si l'ingrédient spécifié n'est pas nul, il est ajouté à l'ensemble des ingrédients du produit
     * et le produit est ajouté à l'ensemble des produits associés à l'ingrédient.
     *
     * @param ingredient l'ingrédient à ajouter
     */
    public void addIngredient(Ingredient ingredient) {
        if (null != ingredient) {
            ingredients.add(ingredient);
            ingredient.addProduit(this);
        }
    }

}



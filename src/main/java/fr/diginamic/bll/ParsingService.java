package fr.diginamic.bll;

import fr.diginamic.dao.DAOFactory;
import fr.diginamic.dao.IProduitDAO;
import fr.diginamic.entites.Produit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParsingService {


    private static final String FILE_PATH = "src/main/resources/test.csv";

    public void parse() throws IOException {

        Path path = Paths.get(ParsingService.class.getResource(FILE_PATH).getPath());
        List<String> lines = Files.readAllLines(path);

        //TODO parsing ici

        List<Produit> produits = new ArrayList<>();

        Produit p1 = new Produit();
        p1.setId(1);
        produits.add(p1);

        Produit p2 = new Produit();
        p2.setId(2);
        produits.add(p2);


        //Interaction ici avec la couche DAO pour enregistrer
        IProduitDAO dao = DAOFactory.getProduitDAO();
        dao.saveAll(produits);
    }
}

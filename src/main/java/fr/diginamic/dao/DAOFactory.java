package fr.diginamic.dao;

import fr.diginamic.dao.jdbc.ProduitDAOJDBC;
import fr.diginamic.dao.jpa.ProduitDAOJPA;

import java.util.ResourceBundle;

public final class DAOFactory {

    private static final String MODE;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("app");
        MODE = bundle.getString("mode.sql");
    }

    private DAOFactory() {}

    public static IProduitDAO getProduitDAO(){

        switch (MODE) {
            case "JPA" -> {
                return new ProduitDAOJPA();
            }
            case "JDBC" -> {
                return new ProduitDAOJDBC();
            }
            default -> throw new RuntimeException("Mode non disponible");
        }
    }
}

package fr.diginamic.utils;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LectureFichier {

    public static List<String> lectureFichier(Path path) throws Exception {
        //     Path path = Paths.get("/Users/Lan/Desktop/DIginamic/JPA/Projet JPA (énoncés)/Open Food Facts/open-food-facts.csv");
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        return lines;
    }
}

package fr.diginamic;

import fr.diginamic.bll.ParsingService;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        try {
            ParsingService service = new ParsingService();
            service.parse();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

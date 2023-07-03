package fr.diginamic.dao;

import fr.diginamic.entites.Allergene;

import java.util.List;

public interface IAllergene {
    List<Allergene> extraire();
    void insert(Allergene allergene);
}

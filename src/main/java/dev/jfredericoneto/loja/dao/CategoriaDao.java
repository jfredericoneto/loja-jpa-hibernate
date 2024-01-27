package dev.jfredericoneto.loja.dao;

import dev.jfredericoneto.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Categoria categoria) {
        this.em.persist(categoria);
    }

}

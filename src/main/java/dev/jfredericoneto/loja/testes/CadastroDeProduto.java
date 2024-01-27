package dev.jfredericoneto.loja.testes;

import java.math.BigDecimal;

import dev.jfredericoneto.loja.dao.CategoriaDao;
import dev.jfredericoneto.loja.dao.ProdutoDao;
import dev.jfredericoneto.loja.modelo.Categoria;
import dev.jfredericoneto.loja.modelo.Produto;
import dev.jfredericoneto.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("Samsung Galaxy S21 FE", "Celular intermediário", new BigDecimal(1500),
                celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}

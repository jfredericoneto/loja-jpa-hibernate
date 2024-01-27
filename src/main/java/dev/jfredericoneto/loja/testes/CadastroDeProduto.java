package dev.jfredericoneto.loja.testes;

import java.math.BigDecimal;

import dev.jfredericoneto.loja.dao.ProdutoDao;
import dev.jfredericoneto.loja.modelo.Produto;
import dev.jfredericoneto.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CadastroDeProduto {

    public static void main(String[] args) {

        Produto celular = new Produto();
        celular.setNome("Samsung Galaxy S21 FE");
        celular.setDescricao("Celular intermediário");
        celular.setPreco(new BigDecimal(1500));

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}

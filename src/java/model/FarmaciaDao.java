/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author drcj1
 */
public class FarmaciaDao {

    private EntityManager manager;

    private void conectar() {
        manager = Persistence.createEntityManagerFactory("FlyDorPU").createEntityManager();
    }

    public int salvarProdutos(Medicamentos medicamentos) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(medicamentos);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception erro) {
            return 0;
        }
    }

    public int loginSistema(LoginUsers loginusers) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(loginusers);
            manager.getTransaction().commit();
            return 1;
        } catch (Exception erro) {
            return 0;
        }
    }

    public int excluirProduto(Integer id) {
        conectar();
        Medicamentos medicamentos = manager.find(Medicamentos.class, id);

        if (medicamentos == null) {
            return 0;
        } else {
            manager.getTransaction().begin();
            manager.remove(medicamentos);
            manager.getTransaction().commit();
            return 1;
        }
    }

    public List<Medicamentos> listarMedicamentos() {
        conectar();
        return manager.
                createNamedQuery("Medicamentos.findAll",
                        Medicamentos.class).
                getResultList();
    }

    public List<Medicamentos> procurarProduto(String principioAtivo) {
        conectar();
        TypedQuery<Medicamentos> query = manager.createQuery(
                "SELECT m FROM Medicamentos m WHERE m.principioAtivo LIKE UPPER(:principioAtivo)",
                Medicamentos.class);

        query.setParameter("principioAtivo", "%" + principioAtivo + "%");

        // Adicione logs de depuração
        System.out.println("Consulta JPQL: " + query.toString());
        System.out.println("Parâmetros: " + principioAtivo);

        return query.getResultList();
    }

    public void atualizarProduto(Medicamentos medicamento) {
        conectar();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            // Sincronize o contexto de persistência com o banco de dados
            manager.flush();

            // Atualize o medicamento usando merge
            manager.merge(medicamento);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public Medicamentos buscarMedicamentoPorId(Integer id) {
        conectar();
        return manager.find(Medicamentos.class, id);
    }

    private void fecharConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Medicamentos> Resultados() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

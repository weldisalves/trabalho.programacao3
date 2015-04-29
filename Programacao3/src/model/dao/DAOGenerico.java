package model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface que representa todos os metodos de DAO.
 * @param <T> - Tipo genérico.
 * @param <ID> - Um id de tipo genérico.
 */
public interface DAOGenerico<T,ID extends Serializable> {
    void salvar(T objeto);
    void remover(T objeto);
    List<T> listar();
    T buscarPorId(ID id);
}
package trabalho.model.dao;

import java.util.List;



/**
 * Interface que representa todos os metodos de DAO.
 * @param <T> - Tipo gen�rico.
 * @param <ID> - Um id de tipo gen�rico.
 */
public interface DAOGenerico<T> {
	void salvar(T objeto);
    void remover(T objeto);
    List<T> listar();
    T buscar(T objeto);
    
}

package dao;

import java.util.List;

public interface iDao<T> {
    T guardar(T objeto);
    List<T> buscarTodos();
}
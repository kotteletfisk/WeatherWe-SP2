package dat.backend.model.dao;

import java.util.List;

public interface IDAO<T>
{
    T read(int id);
    List<T> readAll();
}

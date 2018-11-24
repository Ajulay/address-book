package ru.bellintegrator.practice.dao.officedao;

import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

public interface OfficeDao {

    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> all();

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * Получить Office по названию
     *
     * @param name
     * @return
     */
    Office loadByName(String name);

    /**
     * Сохранить User
     *
     * @param office
     */
    void save(Office office);

    List<Office> loadByViewParam(OfficeView officeView);
}

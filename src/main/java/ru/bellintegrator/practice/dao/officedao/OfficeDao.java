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
//
    /**
     * Получить Office по названию
     *
     * @param name
     * @return
     */
    Office loadByName(String name);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(Office office);


    /**
     * Получить список Office'ов по переданным параметрам
     *
     * @param officeView
     * @return
     */
    List<Office> loadByViewParam(OfficeView officeView);

    void update(Office office);
}

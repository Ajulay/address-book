package ru.bellintegrator.practice.dao.organizationdao;


import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Organization2;
import ru.bellintegrator.practice.view.OrganizationView;


import java.util.List;

public interface OrganizationDao {
    /**
     * Получить все объекты Organization
     *
     * @return
     */
    List<Organization> all();

    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);

    /**
     * Получить Organization по названию
     *
     * @param name
     * @return
     */
    Organization loadByName(String name);

    /**
     * Сохранить Organization
     *
     * @param organization
     */
    void save(Organization organization);

    List<Organization> loadByViewParam(OrganizationView organizationView);

    List<Organization2> testing();

    void update(Organization organization);
}

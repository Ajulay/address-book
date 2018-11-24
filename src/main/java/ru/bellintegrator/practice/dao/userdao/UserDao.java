package ru.bellintegrator.practice.dao.userdao;

import ru.bellintegrator.practice.model.User;
import java.util.List;
/**
 * DAO для работы с User
 */
public interface UserDao {


        /**
         * Получить все объекты User
         *
         * @return
         */
        List<User> all();

        /**
         * Получить User по идентификатору
         *
         * @param id
         * @return
         */
        User loadById(Long id);

        /**
         * Получить User по имени
         *
         * @param name
         * @return
         */
        User loadByName(String name);

        /**
         * Сохранить User
         *
         * @param user
         */
        void save(User user);


}

package ru.bjcreslin.region70.service;

import ru.bjcreslin.region70.entity.Specialist;

public interface Service {

    /**
     * Чтение Специалиста по ИД
     *
     * @param id лонг
     * @return Специалист
     */
    Specialist read(long id);

    /**
     * Новый специалист сохраняется в базе
     *
     * @param specialist специалист
     * @return он же
     */
    Specialist create(Specialist specialist);

    /**
     * Обновление данных либо null, если не найдено
     * @param specialist специалист данные которого надо апдейтить
     * @return результат да или нет
     */
    boolean update(Specialist specialist);

    /**
     * Удаление по ИД
     * @param id ИД
     * @return результат да или нет
     */
    boolean delete(long id);
}

package ru.bjcreslin.region70.service;

import ru.bjcreslin.region70.entity.Specialist;

public interface Service {

    /**
     * Чтение Специалиста по ИД
     * @param id лонг
     * @return Специалист
     */
    Specialist read(long id);
}

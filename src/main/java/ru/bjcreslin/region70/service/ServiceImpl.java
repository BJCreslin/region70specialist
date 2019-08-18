package ru.bjcreslin.region70.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bjcreslin.region70.entity.Specialist;
import ru.bjcreslin.region70.entity.SpecialistRepo;


@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final SpecialistRepo repo;

    @Autowired
    public ServiceImpl(SpecialistRepo repo) {
        this.repo = repo;
    }

    @Override
    public Specialist read(long id) {
        return repo.getOne(id);
    }
}

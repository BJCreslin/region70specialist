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

    @Override
    public Specialist create(Specialist specialist) {
        return repo.save(specialist);
    }

    @Override
    public boolean update(Specialist specialist) {
        Specialist specialistFromBase = repo.getOne(specialist.getId());
        if (specialistFromBase == null) {
            return false;
        }
        specialistFromBase = specialist;
        repo.save(specialistFromBase);
        return true;
    }

    @Override
    public boolean delete(long id) {
        Specialist specialist = repo.getOne(id);
        if (specialist == null) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }

}

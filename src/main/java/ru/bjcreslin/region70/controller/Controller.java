package ru.bjcreslin.region70.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.bjcreslin.region70.entity.Specialist;
import ru.bjcreslin.region70.exception.NotFoundException;
import ru.bjcreslin.region70.service.Constants;
import ru.bjcreslin.region70.service.ServiceImpl;

@org.springframework.stereotype.Controller
@RequestMapping(Constants.SPECIALIST_CONTROLLER_PREFIX)
public class Controller {
    private ServiceImpl service;

    @Autowired
    public Controller(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping(path = Constants.READ_PREFIX + "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Specialist read(@PathVariable long id) {
        Specialist result = service.read(id);
        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

}

package ru.bjcreslin.region70.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(path = Constants.CREATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    Specialist create(@RequestBody Specialist specialist) {
        return service.create(specialist);
    }

    @PatchMapping(path = Constants.UPDATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String update(@RequestBody Specialist specialist) {
        if (service.update(specialist)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }


    }

    @DeleteMapping(path = Constants.DELETE_PREFIX + "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String delete(@PathVariable long id) {
        if (service.delete(id)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }
    }


}

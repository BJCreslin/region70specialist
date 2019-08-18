package ru.bjcreslin.region70.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Specialist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Фамилия имя отчество
    private String name;
    //электронная почта
    private String email;
    //телеыон1
    private String phone1;
    //телефон2
    private String phone2;
    // ИНН организации
    private Integer organisationINN;
    //Должность
    private String position;
    //комментарий
    private String comment;
}

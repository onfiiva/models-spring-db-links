package com.example.modelsspring.controllers;

import com.example.modelsspring.dao.GenericDAO;
import com.example.modelsspring.models.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final GenericDAO<Person> personDAO = new GenericDAO<>();
    private final GenericDAO<House> houseDAO = new GenericDAO<>();
    private final GenericDAO<Job> jobDAO = new GenericDAO<>();
    private final GenericDAO<Pet> petDAO = new GenericDAO<>();
    private final GenericDAO<Transport> transportDAO = new GenericDAO<>();

    @PostConstruct
    public void initializeData() {
        // Заполнение модели Person
        Person person1 = new Person(1, "Иванов", "Иван", "Иванович", 30);
        Person person2 = new Person(2, "Петров", "Петр", "Петрович", 25);
        Person person3 = new Person(3, "Сидоров", "Сидор", "Сидорович", 35);
        Person person4 = new Person(4, "Козлов", "Козел", "Козлович", 40);
        Person person5 = new Person(5, "Федоров", "Федор", "Федорович", 28);

        personDAO.save(person1);
        personDAO.save(person2);
        personDAO.save(person3);
        personDAO.save(person4);
        personDAO.save(person5);

// Заполнение модели House
        House house1 = new House(1, "Частный дом", "Улица 1", 123, "Владелец 1", "2020-01-01");
        House house2 = new House(2, "Квартира", "Улица 2", 456, "Владелец 2", "2019-03-15");
        House house3 = new House(3, "Дача", "Улица 3", 789, "Владелец 3", "2018-05-20");
        House house4 = new House(4, "Частный дом", "Улица 4", 101, "Владелец 4", "2021-09-10");
        House house5 = new House(5, "Квартира", "Улица 5", 222, "Владелец 5", "2017-11-30");

        houseDAO.save(house1);
        houseDAO.save(house2);
        houseDAO.save(house3);
        houseDAO.save(house4);
        houseDAO.save(house5);

// Заполнение модели Job
        Job job1 = new Job(1, "Компания 1", "Тип 1", "Слоган 1", 100, 1000000);
        Job job2 = new Job(2, "Компания 2", "Тип 2", "Слоган 2", 200, 2000000);
        Job job3 = new Job(3, "Компания 3", "Тип 3", "Слоган 3", 150, 1500000);
        Job job4 = new Job(4, "Компания 4", "Тип 4", "Слоган 4", 300, 3000000);
        Job job5 = new Job(5, "Компания 5", "Тип 5", "Слоган 5", 250, 2500000);

        jobDAO.save(job1);
        jobDAO.save(job2);
        jobDAO.save(job3);
        jobDAO.save(job4);
        jobDAO.save(job5);

// Заполнение модели Pet
        Pet pet1 = new Pet(1, "Кот", "Британская", "Домашний", 2, "Мужской");
        Pet pet2 = new Pet(2, "Собака", "Лабрадор", "Домашний", 3, "Женский");
        Pet pet3 = new Pet(3, "Попугай", "Ара", "Домашний", 1, "Мужской");
        Pet pet4 = new Pet(4, "Кролик", "Нидерландский", "Домашний", 1, "Женский");
        Pet pet5 = new Pet(5, "Хомяк", "Сирийский", "Домашний", 2, "Мужской");

        petDAO.save(pet1);
        petDAO.save(pet2);
        petDAO.save(pet3);
        petDAO.save(pet4);
        petDAO.save(pet5);

// Заполнение модели Transport
        Transport transport1 = new Transport(1, "Автомобиль", "Toyota", "Camry", 2021, "Серый");
        Transport transport2 = new Transport(2, "Автомобиль", "Ford", "Focus", 2020, "Синий");
        Transport transport3 = new Transport(3, "Велосипед", "Trek", "X-Caliber", 2019, "Черный");
        Transport transport4 = new Transport(4, "Автомобиль", "Honda", "Civic", 2022, "Белый");
        Transport transport5 = new Transport(5, "Велосипед", "Giant", "Talon", 2018, "Красный");

        transportDAO.save(transport1);
        transportDAO.save(transport2);
        transportDAO.save(transport3);
        transportDAO.save(transport4);
        transportDAO.save(transport5);


        /*model.addAttribute("message", "Данные успешно инициализированы");
        return "index"; // Вернуться на главную страницу*/
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("houses", houseDAO.index());
        model.addAttribute("jobs", jobDAO.index());
        model.addAttribute("people", personDAO.index());
        model.addAttribute("pets", petDAO.index());
        model.addAttribute("transports", transportDAO.index());
        return "index";
    }

    @GetMapping("/show/{modelName}/{id}")
    public String showModel(@PathVariable("modelName") String modelName, @PathVariable("id") int id, Model model) {
        Object modelObject = null;

        // Определите, какую модель загрузить на основе параметра modelName
        switch (modelName.toLowerCase()) {
            case "house":
                modelObject = houseDAO.show(id);
                break;
            case "person":
                modelObject = personDAO.show(id);
                break;
            case "job":
                modelObject = jobDAO.show(id);
                break;
            case "pet":
                modelObject = petDAO.show(id);
                break;
            case "transport":
                modelObject = transportDAO.show(id);
                break;
            default:
                // Обработка ошибки или перенаправление на другую страницу, если modelName недопустим
        }

        model.addAttribute("modelObject", modelObject);
        model.addAttribute("modelName", modelName);

        return "show";
    }

    @GetMapping("/new/{modelName}")
    public String createNewModel(
            @PathVariable("modelName") String modelName,
            Model model
    ) {
        model.addAttribute("modelName", modelName);

        return "new";
    }


    @PostMapping("/add")
    public String addModelObject(
            @RequestParam(name="modelName", defaultValue = "") String modelName,
            @RequestParam(name="value1", defaultValue = "") String value1,
            @RequestParam(name="value2", defaultValue = "") String value2,
            @RequestParam(name="value3", defaultValue = "") String value3,
            @RequestParam(name="value4", defaultValue = "") String value4,
            @RequestParam(name="value5", defaultValue = "") String value5
    ) {
        switch (modelName.toLowerCase()) {
            case "house":
                houseDAO.save(new House(0, value1, value2, Integer.parseInt(value3), value4, value5));
                break;
            case "person":
                personDAO.save(new Person(0, value1, value2, value3, Integer.parseInt(value4)));
                break;
            case "job":
                jobDAO.save(new Job(0, value1, value2, value3, Integer.parseInt(value4), Integer.parseInt(value5)));
                break;
            case "pet":
                petDAO.save(new Pet(0, value1, value2, value3, Integer.parseInt(value4), value5));
                break;
            case "transport":
                transportDAO.save(new Transport(0, value1, value2, value3, Integer.parseInt(value4), value5));
                break;
            default:

        }

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }

    @GetMapping("/edit/{modelName}/{id}")
    public String editModel(@PathVariable("modelName") String modelName, @PathVariable("id") int id, Model model) {
        Object modelObject = null;

        // Определите, какую модель загрузить на основе параметра modelName
        switch (modelName.toLowerCase()) {
            case "house":
                modelObject = houseDAO.show(id);
                break;
            case "person":
                modelObject = personDAO.show(id);
                break;
            case "job":
                modelObject = jobDAO.show(id);
                break;
            case "pet":
                modelObject = petDAO.show(id);
                break;
            case "transport":
                modelObject = transportDAO.show(id);
                break;
            default:
                // Обработка ошибки или перенаправление на другую страницу, если modelName недопустим
        }

        model.addAttribute("modelObject", modelObject);
        model.addAttribute("modelName", modelName);

        return "edit";
    }

    @PostMapping("/edit")
    public String editModelObject(
            @RequestParam(name="modelName", defaultValue = "") String modelName,
            @RequestParam(name="id", defaultValue = "0") int id,
            @RequestParam(name="value1", defaultValue = "") String value1,
            @RequestParam(name="value2", defaultValue = "") String value2,
            @RequestParam(name="value3", defaultValue = "") String value3,
            @RequestParam(name="value4", defaultValue = "") String value4,
            @RequestParam(name="value5", defaultValue = "") String value5
    ) {
        switch (modelName.toLowerCase()) {
            case "house":
                houseDAO.update(id, new House(0, value1, value2, Integer.parseInt(value3), value4, value5));
                break;
            case "person":
                personDAO.update(id, new Person(0, value1, value2, value3, Integer.parseInt(value4)));
                break;
            case "job":
                jobDAO.update(id, new Job(0, value1, value2, value3, Integer.parseInt(value4), Integer.parseInt(value5)));
                break;
            case "pet":
                petDAO.update(id, new Pet(0, value1, value2, value3, Integer.parseInt(value4), value5));
                break;
            case "transport":
                transportDAO.update(id, new Transport(0, value1, value2, value3, Integer.parseInt(value4), value5));
                break;
            default:

        }

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteModelObject(
            @RequestParam(name="modelName", defaultValue = "") String modelName,
            @RequestParam(name="id", defaultValue = "0") int id
    ) {
        switch (modelName.toLowerCase()) {
            case "house":
                houseDAO.delete(id);
                break;
            case "person":
                personDAO.delete(id);
                break;
            case "job":
                jobDAO.delete(id);
                break;
            case "pet":
                petDAO.delete(id);
                break;
            case "transport":
                transportDAO.delete(id);
                break;
            default:

        }

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/";
    }
}

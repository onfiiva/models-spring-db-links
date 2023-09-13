package com.example.modelsspring.controllers;

import com.example.modelsspring.models.*;
import com.example.modelsspring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    private final HouseRepository houseRepository;
    private final JobRepository jobRepository;
    private final PersonRepository personRepository;
    private final PetRepository petRepository;
    private final TransportRepository transportRepository;

    @Autowired
    public MainController(
            HouseRepository houseRepository,
            JobRepository jobRepository,
            PersonRepository personRepository,
            PetRepository petRepository,
            TransportRepository transportRepository
    ) {
        this.houseRepository = houseRepository;
        this.jobRepository = jobRepository;
        this.personRepository = personRepository;
        this.petRepository = petRepository;
        this.transportRepository = transportRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("houses", houseRepository.findAll());
        model.addAttribute("jobs", jobRepository.findAll());
        model.addAttribute("people", personRepository.findAll());
        model.addAttribute("pets", petRepository.findAll());
        model.addAttribute("transports", transportRepository.findAll());
        return "index";
    }

    @GetMapping("/show/{modelName}/{id}")
    public String showModel(
            @PathVariable("modelName") String modelName,
            @PathVariable("id") Long id,
            Model model
    ) {
        Object modelObject = getModelObject(modelName, id);
        if (modelObject == null) {
            // Обработка ошибки: объект не найден
            return "error";
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

    @PostMapping("/add/house")
    public String addHouseObject(
            @RequestParam(name = "modelName") String modelName,
            @ModelAttribute("modelObject") House modelObject

    ) {
        if (!isValidModel(modelName, modelObject)) {
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }

    @PostMapping("/add/job")
    public String addJobObject(
            @RequestParam(name = "modelName") String modelName,
            @ModelAttribute("modelObject") Job modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }

    @PostMapping("/add/person")
    public String addPersonObject(
            @RequestParam(name = "modelName") String modelName,
            @ModelAttribute("modelObject") Person modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }

    @PostMapping("/add/pet")
    public String addPetObject(
            @RequestParam(name = "modelName") String modelName,
            @ModelAttribute("modelObject") Pet modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            System.out.println("хуй " + modelName + " " + modelObject);
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }

    @PostMapping("/add/transport")
    public String addModelObject(
            @RequestParam(name = "modelName") String modelName,
            @ModelAttribute("modelObject") Transport modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После добавления элемента, перенаправьте пользователя обратно на страницу new.html
        return "redirect:/new/" + modelName;
    }


    @GetMapping("/edit/{modelName}/{id}")
    public String editModel(
            @PathVariable("modelName") String modelName,
            @PathVariable("id") Long id,
            Model model
    ) {
        Object modelObject = getModelObject(modelName, id);
        if (modelObject == null) {
            // Обработка ошибки: объект не найден
            return "error";
        }

        model.addAttribute("modelObject", modelObject);
        model.addAttribute("modelName", modelName);

        return "edit";
    }

    @PostMapping("/edit/{modelName}/{id}")
    public String editModelObject(
            @PathVariable("modelName") String modelName,
            @PathVariable("id") Long id,
            @ModelAttribute("modelObject") Object updatedModelObject
    ) {
        Object existingModelObject = getModelObject(modelName, id);
        if (existingModelObject == null) {
            // Обработка ошибки: объект не найден
            return "error";
        }

        if (!isValidModel(modelName, updatedModelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        // Обновите значения существующего объекта данными из updatedModelObject
        // Например, можно использовать сеттеры объекта

        // Сохраните обновленный объект обратно в БД
        saveModelObject(modelName, existingModelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }


    @PostMapping("/edit/house")
    public String editHouseObject(
            @RequestParam(name="modelName") String modelName,
            @ModelAttribute("modelObject") House modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    @PostMapping("/edit/job")
    public String editJobObject(
            @RequestParam(name="modelName") String modelName,
            @ModelAttribute("modelObject") Job modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    @PostMapping("/edit/person")
    public String editModelObject(
            @RequestParam(name="modelName") String modelName,
            @ModelAttribute("modelObject") Person modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    @PostMapping("/edit/pet")
    public String editModelObject(
            @RequestParam(name="modelName") String modelName,
            @ModelAttribute("modelObject") Pet modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    @PostMapping("/edit/transport")
    public String editModelObject(
            @RequestParam(name="modelName") String modelName,
            @ModelAttribute("modelObject") Transport modelObject
    ) {
        if (!isValidModel(modelName, modelObject)) {
            // Обработка ошибки: неверный тип объекта
            return "error";
        }

        saveModelObject(modelName, modelObject);

        // После редактирования элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteModelObject(
            @RequestParam(name="modelName") String modelName,
            @RequestParam(name="id") Long id
    ) {
        deleteModelObjectById(modelName, id);

        // После удаления элемента, перенаправьте пользователя обратно на главную страницу
        return "redirect:/";
    }

    private Object getModelObject(String modelName, Long id) {
        switch (modelName.toLowerCase()) {
            case "house":
                return houseRepository.findById(id).orElse(null);
            case "person":
                return personRepository.findById(id).orElse(null);
            case "job":
                return jobRepository.findById(id).orElse(null);
            case "pet":
                return petRepository.findById(id).orElse(null);
            case "transport":
                return transportRepository.findById(id).orElse(null);
            default:
                return null;
        }
    }

    private boolean isValidModel(String modelName, Object modelObject) {
        switch (modelName.toLowerCase()) {
            case "house":
                return modelObject instanceof House;
            case "person":
                return modelObject instanceof Person;
            case "job":
                return modelObject instanceof Job;
            case "pet":
                return modelObject instanceof Pet;
            case "transport":
                return modelObject instanceof Transport;
            default:
                return false;
        }
    }

    private void saveModelObject(String modelName, Object modelObject) {
        switch (modelName.toLowerCase()) {
            case "house":
                houseRepository.save((House) modelObject);
                break;
            case "person":
                personRepository.save((Person) modelObject);
                break;
            case "job":
                jobRepository.save((Job) modelObject);
                break;
            case "pet":
                petRepository.save((Pet) modelObject);
                break;
            case "transport":
                transportRepository.save((Transport) modelObject);
                break;
        }
    }

    private void deleteModelObjectById(String modelName, Long id) {
        switch (modelName.toLowerCase()) {
            case "house":
                houseRepository.deleteById(id);
                break;
            case "person":
                personRepository.deleteById(id);
                break;
            case "job":
                jobRepository.deleteById(id);
                break;
            case "pet":
                petRepository.deleteById(id);
                break;
            case "transport":
                transportRepository.deleteById(id);
                break;
        }
    }
}

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    ModelRepository modelRepository;

    @RequestMapping("/")
    public String listModels(Model model){
        model.addAttribute("models", modelRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String modelForm(Model model) {
        model.addAttribute("modelCar", new ModelCar());
        return "modelcarform";
    }

    @PostMapping("/process")
    public String processForm(@Valid ModelCar modelCar, BindingResult result){
        if(result.hasErrors()){
            return "modelcarform";
        }

        modelRepository.save(modelCar);
        return "redirect:/";
    }

    @RequestMapping("/detail/{id}")
    public String showModelCar(@PathVariable("id") long id, Model model){
        model.addAttribute("modelCar", modelRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateModelCar(@PathVariable("id") long id, Model model){
        model.addAttribute("modelCar", modelRepository.findById(id).get());
        return "modelcarform";
    }

    @RequestMapping("/delete/{id}")
    public String delModelCar(@PathVariable("id") long id){
        modelRepository.deleteById(id);
        return "redirect:/";
    }
}


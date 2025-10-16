package com.seoeunjin.api.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seoeunjin.api.calculator.domain.CalculatorDTO;
import com.seoeunjin.api.calculator.service.CalculatorService;

@Controller
public class CalculatorController {

    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
   
    @GetMapping("/calculator/calculator")
    public String calculator(@RequestParam(value = "num1", required = false) String num1,
                         @RequestParam(value = "num2", required = false) String num2) {

    System.out.println("컨트롤러로 들어옴");
    System.out.println("num1: " + num1 + ", num2: " + num2);

    if(num1 != null && num2 != null) {
        CalculatorDTO calculatorDTO = new CalculatorDTO();
        calculatorDTO.setNum1(num1);
        calculatorDTO.setNum2(num2);
        calculatorService.calculator(calculatorDTO);
    }

    return "calculator/calculator"; // templates/calculator/calculator.html
}

}
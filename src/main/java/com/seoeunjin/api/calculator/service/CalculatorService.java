package com.seoeunjin.api.calculator.service;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.calculator.domain.CalculatorDTO;

@Service
public class CalculatorService {

    public boolean calculator(CalculatorDTO calculatorDTO) {
        System.out.println("계산기 서비스로 들어옴");
        System.out.println("서비스로 전달된 숫자1 : " + calculatorDTO.getNum1());
        System.out.println("서비스로 전달된 숫자2 : " + calculatorDTO.getNum2());
        return true;
    }

}

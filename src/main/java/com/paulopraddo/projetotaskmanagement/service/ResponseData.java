package com.paulopraddo.projetotaskmanagement.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private String message;
    private HttpStatus httpStatus;
    private TarefaData data;
}

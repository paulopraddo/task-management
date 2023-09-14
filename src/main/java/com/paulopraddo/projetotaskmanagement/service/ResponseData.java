package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    private String message;
    private String codigoHttp;
    private TarefaData data;
}

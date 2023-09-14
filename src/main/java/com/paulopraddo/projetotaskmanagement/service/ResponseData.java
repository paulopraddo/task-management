package com.paulopraddo.projetotaskmanagement.service;

import com.paulopraddo.projetotaskmanagement.model.TarefaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private String message;
    private String codigoHttp;
    private TarefaData data;
}

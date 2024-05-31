package com.jonatascarvalho.cadastrocliente.extensionFunctions

import com.jonatascarvalho.cadastrocliente.dtos.ClientDTO
import com.jonatascarvalho.cadastrocliente.models.ClientModel

fun ClientDTO.clientDTOToModel() = ClientModel(
        clientId = clientId,
        clientName = clientName,
        clientPhone = clientPhone,
        clientCpf = clientCpf
)

fun ClientModel.clientModeltoDTO() = ClientDTO(
        clientId = clientId,
        clientName = clientName,
        clientPhone = clientPhone,
        clientCpf = clientCpf
)
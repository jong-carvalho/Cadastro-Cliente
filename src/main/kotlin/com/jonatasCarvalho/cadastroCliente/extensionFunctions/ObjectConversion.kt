package com.jonatasCarvalho.cadastroCliente.extensionFunctions

import com.jonatasCarvalho.cadastroCliente.dtos.ClientDTO
import com.jonatasCarvalho.cadastroCliente.models.ClientModel

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
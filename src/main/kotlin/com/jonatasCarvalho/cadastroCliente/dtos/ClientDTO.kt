package com.jonatasCarvalho.cadastroCliente.dtos

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class ClientDTO (
        var clientId: String = "CLI_" + UUID.randomUUID().toString().uppercase(),
        var clientName: String,
        var clientPhone: String,
        var clientCpf: String
)
package com.jonatascarvalho.cadastrocliente.dtos

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class OrderDTO (
    var clientId: String,
    var orderId: String
)
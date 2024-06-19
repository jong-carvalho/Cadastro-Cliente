package com.jonatascarvalho.cadastrocliente.services

import com.jonatascarvalho.cadastrocliente.dtos.OrderDTO
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.ResourceAccessException
import org.springframework.web.client.RestTemplate

@Service
class OrderService(val logger: Logger) {

    private val restTemplate: RestTemplate = RestTemplate()

    @Value("\${order.service.url}")
    lateinit var pedidoServiceUrl: String

    @CircuitBreaker(name = "resiliencia")
    fun getAllOrders(): Array<OrderDTO>? {
        val response = restTemplate.getForObject(pedidoServiceUrl, Array<OrderDTO>::class.java)
        return response
    }






}
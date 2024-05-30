package com.jonatasCarvalho.cadastroCliente.metrics

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Component

@Component
class MetricLogger (registry: MeterRegistry){

    private var getAllClientsCounter: Counter = Counter
        .builder("request_getting_all_clients")
        .tag("app", "Cadastro-Cliente")
        .register(registry)

    private var getClientByIdCounter: Counter = Counter
        .builder("request_getting_client_by_id")
        .tag("app", "Cadastro-Cliente")
        .register(registry)

    private var createClientCounter: Counter = Counter
        .builder("request_create_client")
        .tag("app", "Cadastro-Cliente")
        .register(registry)

    private var updateClientCounter: Counter = Counter
        .builder("request_update_client")
        .tag("app", "Cadastro-Cliente")
        .register(registry)

    private var deletClientCounter: Counter = Counter
        .builder("request_delete_client")
        .tag("app", "Cadastro-Cliente")
        .register(registry)

    fun getAllClientsCounterRequest() = getAllClientsCounter.increment()
    fun getClientByIdRequest() = getClientByIdCounter.increment()
    fun createClientRequest() = createClientCounter.increment()
    fun updateClientRequest() = updateClientCounter.increment()
    fun deleteClientRequest() = deletClientCounter.increment()
}
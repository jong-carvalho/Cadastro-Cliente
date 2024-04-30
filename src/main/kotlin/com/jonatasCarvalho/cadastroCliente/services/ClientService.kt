package com.jonatasCarvalho.cadastroCliente.services

import com.jonatasCarvalho.cadastroCliente.dtos.ClientDTO
import com.jonatasCarvalho.cadastroCliente.extensionFunctions.clientDTOToModel
import com.jonatasCarvalho.cadastroCliente.models.ClientModel
import com.jonatasCarvalho.cadastroCliente.repositories.ClientRepository
import org.slf4j.Logger
import org.springframework.stereotype.Service

@Service
class ClientService(private val repository: ClientRepository, val logger: Logger){

    fun findByClientId(id: String): ClientModel {
        return repository.findByClientId(id).orElseThrow()
    }

    fun findAll(): MutableList<ClientModel> {
        return repository.findAll()
    }

    fun save(clientDTO: ClientDTO): ClientDTO {
        val clientModel = clientDTO.clientDTOToModel()

        repository.save(clientModel)
        logger.info("Client - client with id: ${clientModel.clientId} was created")
        return clientDTO
    }

    fun delete(clientDTO: ClientDTO) {
        val clientModel = clientDTO.clientDTOToModel()
        repository.delete(clientModel)
        logger.info("Client - client with id: ${clientDTO.clientId} was deleted")
    }
}
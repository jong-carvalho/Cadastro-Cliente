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
        val clientByID = repository.findByClientId(id).orElseThrow()
        logger.info("O Cliente com o id: ${id} foi encontrado com sucesso.")
        return clientByID
    }

    fun findAll(): MutableList<ClientModel> {
        val allClients = repository.findAll()
        logger.info("Todos os Clientes foram encontrados com sucesso.")
        return allClients
    }

    fun save(clientDTO: ClientDTO): ClientDTO {
        val clientModel = clientDTO.clientDTOToModel()

        repository.save(clientModel)
        logger.info("O Cliente com o id: ${clientModel.clientId} foi criado.")
        return clientDTO
    }

    fun delete(clientDTO: ClientDTO) {
        val clientModel = clientDTO.clientDTOToModel()
        repository.delete(clientModel)
        logger.info("O Cliente com o id: ${clientDTO.clientId} foi deletado.")
    }
}
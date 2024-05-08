package com.jonatasCarvalho.cadastroCliente.controllers

import com.jonatasCarvalho.cadastroCliente.dtos.ClientDTO
import com.jonatasCarvalho.cadastroCliente.extensionFunctions.clientDTOToModel
import com.jonatasCarvalho.cadastroCliente.extensionFunctions.clientModeltoDTO
import com.jonatasCarvalho.cadastroCliente.models.ClientModel
import com.jonatasCarvalho.cadastroCliente.repositories.ClientRepository
import com.jonatasCarvalho.cadastroCliente.services.ClientService
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/clients")
class ClientController(val logger: Logger) {

    @Autowired
    lateinit var clientService: ClientService

    @CrossOrigin
    @GetMapping
    fun getAllClients(): ResponseEntity<MutableList<ClientModel>> {
        logger.info("Procurando todos os clientes cadastrados...")
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll())
    }

    @CrossOrigin
    @GetMapping("/{clientId}")
    fun getClientById(@PathVariable clientId: String): ResponseEntity<ClientModel> {
        logger.info("Procurando cliente com o id: $clientId...")
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findByClientId(clientId))
    }

    @CrossOrigin
    @PostMapping
    fun createClient(@RequestBody clientDTO: ClientDTO): ResponseEntity<String> {
        logger.info("Criando um cliente...")
        clientService.save(clientDTO)
        return ResponseEntity.status(HttpStatus.OK).body("Cliente criado com sucesso.")
    }

    @CrossOrigin
    @PutMapping("/{clientId}")
    fun updateClient(@PathVariable clientId: String, @RequestBody clientDTO: ClientDTO): ResponseEntity<String> {
        logger.info("Realizando um update no cliente: $clientId...")
        var clientFound = clientService.findByClientId(clientId)

        clientFound.apply {
            this.clientName = clientDTO.clientName
            this.clientPhone = clientDTO.clientPhone
            this.clientCpf = clientDTO.clientCpf
        }

        clientService.save(clientFound.clientModeltoDTO())

        return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso")
    }

    @CrossOrigin
    @DeleteMapping("/{clientId}")
    fun deleteClient(@PathVariable clientId: String): ResponseEntity<String> {
        logger.info("Deletando cliente com o id: $clientId...")
        var clientFound = clientService.findByClientId(clientId)

        clientService.delete(clientFound.clientModeltoDTO())

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso")
    }
}
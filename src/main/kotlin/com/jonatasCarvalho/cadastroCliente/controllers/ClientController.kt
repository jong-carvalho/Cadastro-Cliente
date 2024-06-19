package com.jonatascarvalho.cadastrocliente.controllers



import com.jonatascarvalho.cadastrocliente.dtos.OrderDTO
//import com.jonatascarvalho.cadastrocliente.services.OrderService
import com.jonatascarvalho.cadastrocliente.dtos.ClientDTO
import com.jonatascarvalho.cadastrocliente.extensionFunctions.clientModeltoDTO
import com.jonatascarvalho.cadastrocliente.models.ClientModel
import com.jonatascarvalho.cadastrocliente.services.ClientService
import com.jonatascarvalho.cadastrocliente.services.OrderService
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping



@Controller
@RequestMapping("/clients")
class ClientController(val logger: Logger) {

    @Autowired
    lateinit var clientService: ClientService

    @Autowired
    lateinit var orderService: OrderService

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
        val clientFound = clientService.findByClientId(clientId)

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
        val clientFound = clientService.findByClientId(clientId)

        clientService.delete(clientFound.clientModeltoDTO())

        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso")
    }

    @CrossOrigin
    @GetMapping("/orders")
    fun getAllOrders(): ResponseEntity<Array<OrderDTO>> {
        logger.info("Procurando todos os pedidos cadastrados...")
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllOrders())
    }


}
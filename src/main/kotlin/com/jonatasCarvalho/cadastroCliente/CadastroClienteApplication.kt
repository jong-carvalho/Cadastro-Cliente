package com.jonatascarvalho.cadastrocliente


import io.micrometer.core.instrument.Counter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CadastroClienteApplication

fun main(args: Array<String>) {
	runApplication<CadastroClienteApplication>(*args)

}

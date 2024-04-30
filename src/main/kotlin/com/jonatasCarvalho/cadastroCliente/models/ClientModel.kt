package com.jonatasCarvalho.cadastroCliente.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table


@Entity
@Table(name = "TB_CLIENT")
class ClientModel (

        @Id
        var clientId: String,
        @Column
        var clientName: String,
        @Column
        var clientPhone: String,
        @Column
        var clientCpf: String

)
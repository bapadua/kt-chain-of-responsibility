package io.github.bapadua.demoktrest.model

import java.util.UUID

data class Customer(
    var id: UUID,
    var name: String,
    var email: String
)
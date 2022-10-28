package io.github.bapadua.demoktrest.service

import io.github.bapadua.demoktrest.domain.customer.CustomerPutRequest
import io.github.bapadua.demoktrest.domain.customer.CustomerRequest
import io.github.bapadua.demoktrest.model.Customer
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class CustomerService {

    private val customers = mutableListOf<Customer>();

    fun createCustomer(request: CustomerRequest): Customer {
        val customer = Customer(UUID.randomUUID(), request.name, request.email)
        customers.add(customer)
        return customer
    }


    fun getCustomersList(name: String?, email: String?): MutableList<Customer> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }.toMutableList()
        }
        email?.let {
            return customers.filter { it.email.contains(email, true) }.toMutableList()
        }
        return customers.toMutableList()
    }

    fun getCustomerById(id: UUID): Customer? {
        return customers.firstOrNull { it.id == id }
    }

    fun updateCustomer(id: UUID, customer: CustomerPutRequest): Customer? {
        customers.firstOrNull { it.id == id }.let {
            it?.name = customer.name
            it?.email = customer.email
        }
        return getCustomerById(id)
    }

    fun removeCustomerById(id: UUID) {
        customers.removeIf { it.id == id }
    }
}
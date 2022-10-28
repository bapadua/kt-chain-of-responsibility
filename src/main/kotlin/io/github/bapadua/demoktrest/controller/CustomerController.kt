package io.github.bapadua.demoktrest.controller

import io.github.bapadua.demoktrest.domain.customer.CustomerPutRequest
import io.github.bapadua.demoktrest.domain.customer.CustomerRequest
import io.github.bapadua.demoktrest.model.Customer
import io.github.bapadua.demoktrest.service.CustomerService
import io.github.bapadua.demoktrest.utils.LogService
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.io.File
import java.net.URI
import java.util.*

private const val FILE_PATH = "/home/testfile.txt"

@RestController
class CustomerController(val customerService: CustomerService, val logger: LogService) {

    @GetMapping(path = ["/test"])
    fun test(): ResponseEntity<Void> {
        logger.log("saving file to $FILE_PATH")
        try {
            val test = File(FILE_PATH)
            if (test.createNewFile()) {
                print("file created ${test.name}")
            }
        } catch (ex: Exception) {
            print("error creating file ${ex.message}")
            ex.printStackTrace()
        }
        return ResponseEntity.ok().build()
    }

    @GetMapping(path = ["/customer"])
    fun getCustomers(
        @RequestParam("name") name: String?,
        @RequestParam("email") email: String?,
    ): ResponseEntity<MutableList<Customer>> {
        logger.log("getCustomer", HttpMethod.GET, "params")
        return ResponseEntity.ok(customerService.getCustomersList(name, email))
    }

    @PostMapping(path = ["/customer"])
    fun saveCustomer(@RequestBody customer: CustomerRequest): ResponseEntity<Customer> {
        logger.log("saveCustomer", HttpMethod.POST, customer.toString())
        val created = customerService.createCustomer(customer)
        return ResponseEntity.created(buildUri(created.id)).build()
    }

    @GetMapping(path = ["/customer/{id}"])
    fun getCustomerById(@PathVariable("id") id: UUID): ResponseEntity<Customer> {
        logger.log("getCustomerById", HttpMethod.GET, id.toString())
        return ResponseEntity.ok(customerService.getCustomerById(id))
    }

    @PutMapping(path = ["/customer/{id}"])
    fun updateCustomerById(
        @PathVariable("id") id: UUID,
        @RequestBody customer: CustomerPutRequest
    ): ResponseEntity<Customer> {
        logger.log("updateCustomerById", HttpMethod.PUT, id.toString())
        return ResponseEntity.ok(customerService.updateCustomer(id, customer))
    }

    @DeleteMapping(path = ["/customer/{id}"])
    fun removeCustomerById(
        @PathVariable("id") id: UUID
    ): ResponseEntity<Customer> {
        logger.log("deleteCustomerById", HttpMethod.PUT, id.toString())
        customerService.removeCustomerById(id)
        return ResponseEntity.ok().build()
    }


    private fun buildUri(arg: UUID? = null): URI = buildUri(arg.toString())
    private fun buildUri(arg: String? = null): URI =
        UriComponentsBuilder.fromPath("/customer/{id}")
            .buildAndExpand(arg)
            .toUri()

}
package io.github.bapadua.demoktrest.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component

@Component
class LogService {
    var log: Logger = LoggerFactory.getLogger(this::class.java)

    fun log(str: String) {
        log.info("{}", str)
    }

    fun log(str: String, method: HttpMethod, args: String) {
        log.info("{} method: {} - args: {}", str, method, args)
    }
}
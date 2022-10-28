package io.github.bapadua.demoktrest.service.chain

interface Handler<T> {

    fun setNext(handler: Handler<T>)
    fun handle(context:T)
}
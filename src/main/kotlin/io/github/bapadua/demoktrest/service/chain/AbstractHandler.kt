package io.github.bapadua.demoktrest.service.chain

abstract class AbstractHandler<T> : Handler<T> {

    private lateinit var handleNext: Handler<T>

    override fun setNext(handler: Handler<T>) {
        this.handleNext = handler
    }

    fun handleNext(context: T) {
        handleNext.let {
            handleNext.handle(context)
        }
    }
}
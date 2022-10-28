package io.github.bapadua.demoktrest.service.chain

import io.github.bapadua.demoktrest.utils.LogService

class Step1Handler(private val logService: LogService) : AbstractHandler<ChainContext>() {

    override fun handle(context: ChainContext) {
        logService.log("Step1 Handler")
        context.step = "step 1 added"
        handleNext(context)
    }
}
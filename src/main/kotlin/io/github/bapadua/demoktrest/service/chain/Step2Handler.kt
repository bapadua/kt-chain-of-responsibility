package io.github.bapadua.demoktrest.service.chain

import io.github.bapadua.demoktrest.utils.LogService

class Step2Handler(private val logService: LogService) : AbstractHandler<ChainContext>() {

    override fun handle(context: ChainContext) {
        logService.log("Step2 Handler")
        context.step2 = "step 2 added"
        handleNext(context)
    }
}
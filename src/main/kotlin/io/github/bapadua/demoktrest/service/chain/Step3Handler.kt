package io.github.bapadua.demoktrest.service.chain

import io.github.bapadua.demoktrest.utils.LogService

class Step3Handler(private val logService: LogService) : AbstractHandler<ChainContext>() {

    override fun handle(context: ChainContext) {
        logService.log("Step3 Handler")
        context.step3 = "step 3 added"
        handleNext(context)
    }
}
package io.github.bapadua.demoktrest.service.chain

import io.github.bapadua.demoktrest.utils.LogService

class DemoChain(val logService: LogService): AbstractHandler<ChainContext>() {

    override fun handle(context: ChainContext) {
        logService.log("starting chain")
        val step1 = Step1Handler(logService)
        val step2 = Step2Handler(logService)
        val step3 = Step3Handler(logService)

        step1.setNext(step2)
        step2.setNext(step3)
        step1.handle(context)
    }
}
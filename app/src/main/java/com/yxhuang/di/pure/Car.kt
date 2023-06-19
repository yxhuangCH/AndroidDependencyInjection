package com.yxhuang.di.pure

/**
 * Created by yxhuang
 * Date: 2023/6/5
 * Description:
 */
class Car {
    private var engine: Engine = ElectricEngine()

    fun start() {
        engine.start()
    }
}

/**
 *  构建函数注入依赖
 */
class Car2(private val engine: Engine) {
    fun start() {
        engine.start()
    }
}

/**
 *  构建函数注入依赖
 */
class Car3 {

    private lateinit var engine: Engine

    fun setEngine(engine: Engine){
        this.engine = engine
    }

    fun start() {
        requireNotNull(engine){
            "Need to set Engine"
        }
        engine.start()
    }
}

/**
 * 接口注入
 */
class Car4: InjectEngine {
    lateinit var engine: Engine
    override fun injectEngine(engine: Engine) {
        this.engine = engine
    }
    fun start() {
        requireNotNull(engine){
            "Need to set Engine"
        }
        engine.start()
    }
}

class Car5 {
    private val engine = ServiceLocator.getGasEngines()

    fun start(){
        engine.start()
    }

}


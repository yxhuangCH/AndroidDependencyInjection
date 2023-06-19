package com.yxhuang.di

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yxhuang.di.pure.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diTest()
    }

    private fun diTest() {
        // 无依赖注入
        val car = Car()
        car.start()

        // 构建函数注入依赖
        val electricEngine = ElectricEngine()
        val car2 = Car2(electricEngine)
        car2.start()

        // 函数注入
        val car3 = Car3()
        val gasEngine = GasEngine()
        car3.setEngine(gasEngine)
        car3.start()

        // 接口注入
        val electricEngine2 = ElectricEngine()
        val car4 = Car4()
        car4.injectEngine(electricEngine2)
        car4.start()

        // IoC 容器
        val car5 = Car5()
        car5.start()
    }
}
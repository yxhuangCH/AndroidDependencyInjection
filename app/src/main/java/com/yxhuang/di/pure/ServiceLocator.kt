package com.yxhuang.di.pure


/**
 * Created by yxhuang
 * Date: 2023/6/6
 * Description:
 */
object ServiceLocator {

    fun getElectricEngine(): Engine = ElectricEngine()

    fun getGasEngines(): Engine = GasEngine()
}
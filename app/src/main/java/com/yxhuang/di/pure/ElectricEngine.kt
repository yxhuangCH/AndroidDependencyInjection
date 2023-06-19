package com.yxhuang.di.pure

import android.util.Log
import com.yxhuang.di.pure.Engine.Companion.TAG

/**
 * Created by yxhuang
 * Date: 2023/6/5
 * Description:
 */
class ElectricEngine : Engine {

    override fun start() {
        Log.i(TAG, "ElectricEngine start")
    }
}
package com.koonny.appcompat.event

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow

object FlowEventBus {

    private val bus: HashMap<String, MutableSharedFlow<out Any>> = hashMapOf()

    private fun <T : Any> with(key: String): MutableSharedFlow<T> {
        if (!bus.containsKey(key)) {
            bus[key] = MutableSharedFlow<T>()
        }
        return bus[key] as MutableSharedFlow<T>
    }

    fun <T> getFlow(action: String): SharedFlow<T> = with(action)


    suspend fun <T : Any> post(action: String, data: T) {
        with<T>(action).emit(data)
    }

    fun <T : Any> tryPost(action: String, data: T): Boolean = with<T>(action).tryEmit(data)

    suspend fun <T : Any> subscribe(lifecycle: Lifecycle, action: String, block: (T) -> Unit) {
        lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
            with<T>(action).collect {
                block(it)
            }
        }
    }

    suspend fun <T : Any> subscribe(action: String, block: (T) -> Unit) {
        with<T>(action).collect {
            block(it)
        }
    }

}
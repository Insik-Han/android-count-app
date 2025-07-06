package com.example.count

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue

@Stable
class CounterState(initialValue: Int = 0) {
    var count by mutableIntStateOf(initialValue)
        private set
    
    fun increment() {
        count++
    }
    
    fun decrement() {
        if (count > 0) {
            count--
        }
    }
    
    fun reset() {
        count = 0
    }
    
    fun canDecrement(): Boolean = count > 0
}
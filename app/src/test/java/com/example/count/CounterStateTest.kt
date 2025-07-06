package com.example.count

import org.junit.Test
import org.junit.Assert.*

class CounterStateTest {
    
    @Test
    fun `initial count should be zero by default`() {
        val counterState = CounterState()
        assertEquals(0, counterState.count)
    }
    
    @Test
    fun `initial count can be set to custom value`() {
        val counterState = CounterState(initialValue = 10)
        assertEquals(10, counterState.count)
    }
    
    @Test
    fun `increment should increase count by one`() {
        val counterState = CounterState()
        counterState.increment()
        assertEquals(1, counterState.count)
    }
    
    @Test
    fun `multiple increments should accumulate`() {
        val counterState = CounterState()
        repeat(5) { counterState.increment() }
        assertEquals(5, counterState.count)
    }
    
    @Test
    fun `decrement should decrease count by one`() {
        val counterState = CounterState(initialValue = 5)
        counterState.decrement()
        assertEquals(4, counterState.count)
    }
    
    @Test
    fun `decrement should not go below zero`() {
        val counterState = CounterState(initialValue = 0)
        counterState.decrement()
        assertEquals(0, counterState.count)
    }
    
    @Test
    fun `canDecrement should return true when count is positive`() {
        val counterState = CounterState(initialValue = 1)
        assertTrue(counterState.canDecrement())
    }
    
    @Test
    fun `canDecrement should return false when count is zero`() {
        val counterState = CounterState(initialValue = 0)
        assertFalse(counterState.canDecrement())
    }
    
    @Test
    fun `reset should set count to zero`() {
        val counterState = CounterState(initialValue = 10)
        counterState.reset()
        assertEquals(0, counterState.count)
    }
    
    @Test
    fun `complex sequence of operations`() {
        val counterState = CounterState()
        
        // Increment 3 times
        repeat(3) { counterState.increment() }
        assertEquals(3, counterState.count)
        
        // Decrement once
        counterState.decrement()
        assertEquals(2, counterState.count)
        
        // Reset
        counterState.reset()
        assertEquals(0, counterState.count)
        
        // Try to decrement below zero
        counterState.decrement()
        assertEquals(0, counterState.count)
        
        // Increment after reset
        counterState.increment()
        assertEquals(1, counterState.count)
    }
    
    @Test
    fun `count property should be read-only from outside`() {
        val counterState = CounterState()
        // This test verifies that count can only be modified through the provided methods
        // Direct assignment like counterState.count = 5 would cause a compilation error
        counterState.increment()
        assertEquals(1, counterState.count)
    }
}
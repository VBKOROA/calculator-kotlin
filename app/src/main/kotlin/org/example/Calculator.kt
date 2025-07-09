package org.example

import org.example.enums.Operator

class Calculator {
    // static 선언 영역
    companion object {
        const val MAX_RESULTS = 5 // static final int MAX_RESULTS와 유사
    }

    private val results = mutableListOf<Double>()

    fun getResults(): List<Double> {
        return results
    }

    fun setResults(newResults: List<Double>) {
        results.clear() // 먼저 기존 결과를 지우고
        results.addAll(newResults) // 새로운 결과를 추가
    }

    fun removeOldResult() {
        if (results.isNotEmpty()) {
            results.removeAt(0) // 가장 오래된 결과를 제거
        }
    }

    fun <T: Number> calculate(num1: T, num2: T, op: Operator): Double? {
        val result = op.apply(num1.toDouble(), num2.toDouble()) // 연산자에 따라 계산 수행

        // result가 null이 아닐 때만 동작
        // it - 자기 자신
        result?.let { 
            results.add(it) 
            if(results.size > MAX_RESULTS) {
                removeOldResult() // 결과가 MAX_RESULTS개를 초과하면 가장 오래된 결과를 제거
            }
        }
        return result
    }
}
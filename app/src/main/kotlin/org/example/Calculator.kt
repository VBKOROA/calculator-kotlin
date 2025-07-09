package org.example

class Calculator {
    private val results = mutableListOf<Int>()

    fun getResults(): List<Int> {
        return results
    }

    fun setResults(newResults: List<Int>) {
        results.clear() // 먼저 기존 결과를 지우고
        results.addAll(newResults) // 새로운 결과를 추가
    }

    fun calculate(num1: Int, num2: Int, op: String): Int? {
        val result = when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0) num1 / num2 else null
            else -> null
        }

        // result가 null이 아닐 때만 동작
        // it - 자기 자신
        result?.let { results.add(it) }
        return result
    }
}
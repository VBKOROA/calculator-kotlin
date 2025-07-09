package org.example.enums

enum class Operator(val symbol: String) {
    PLUS("+") {
        override fun apply(num1: Double, num2: Double): Double = num1 + num2
    },
    MINUS("-") {
        override fun apply(num1: Double, num2: Double): Double = num1 - num2
    },
    MULTIPLY("*") {
        override fun apply(num1: Double, num2: Double): Double = num1 * num2
    },
    DIVIDE("/") {
        override fun apply(num1: Double, num2: Double): Double? {
            return if (num2 != 0.0) num1 / num2 else null
        }
    };

    abstract fun apply(num1: Double, num2: Double): Double?

    companion object {
        fun fromSymbol(symbol: String): Operator? {
            // 코틀린 컬렉션 함수
            // 가장 먼저 일치하는 Operator를 찾음
            return values().find { it.symbol == symbol }
        }
    }
}
package com.example.calculater.ui.theme

class CalculatorBrain {

    enum class Operation(val op: String) {
        SUM("+"),
        SUB("-"),
        MULT("*"),
        DIV("/"),
        SQRT("√"),
        SIGNAL("±"),
        PERCENT("%"),
        RAND("\uD83D\uDE02");

        companion object {
            fun getOp(value: String): Operation {
                return when (value) {
                    SUM.toString() -> SUM
                    SUB.toString() -> SUB
                    MULT.toString() -> MULT
                    DIV.toString() -> DIV
                    SQRT.toString() -> SQRT
                    SIGNAL.toString() -> SIGNAL
                    PERCENT.toString() -> PERCENT
                    RAND.toString() -> RAND
                    else -> RAND
                }
            }
        }
    }

    var operation: Operation? = null
    var operand: Double = 0.0

    fun doOperation(value: Double): Double {
        val result = when (operation) {
            Operation.SUM -> operand + value
            Operation.SUB -> operand - value
            Operation.MULT -> operand * value
            Operation.DIV -> operand / value
            Operation.SQRT -> Math.sqrt(operand) // Apenas a raiz quadrada de operand
            Operation.SIGNAL -> -operand
            Operation.PERCENT -> operand / 100
            Operation.RAND -> Math.random()
            null -> value
        }
        return result
    }
}

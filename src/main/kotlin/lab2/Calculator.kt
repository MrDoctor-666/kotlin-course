package lab2

import java.util.*
import kotlin.math.E
import kotlin.math.pow
import kotlin.math.PI

class Calculator(private val expression: String) {

    private val _operators = hashSetOf("+", "-", "*", "/", "^")
    private val _constants = mapOf("pi" to PI, "e" to E)
    private val _rpn: MutableList<String> = mutableListOf()

    fun calc(): Double {
        checkBrackets()
        //converting input string to reverse polish notation (rpn)
        toRPN()
        //count result from reverse polish notation
        return countFromRPN()
    }

    private fun checkBrackets() {
        var count = 0
        expression.forEach {
            if (it == '(') count++
            if (it == ')') count--
        }
        if (count != 0) throw Error("Wrong brackets")
    }

    private fun toRPN() {
        val stringToWork =
            expression.replace(" ", "")
                .replace("-(", "0-(")
        val stack: Stack<String> = Stack()
        var index = 0
        _rpn.clear()

        while (index < stringToWork.length) {
            when (stringToWork[index]) {
                '(' -> stack.push(stringToWork[index].toString())
                ')' -> {
                    //adding from stack to result until we find ( in stack
                    while (stack.peek() != "(") _rpn.add(stack.pop())
                    stack.pop() //delete ( from stack
                }
                '+', '-' -> {
                    //unary minus and plus
                    // if it's first in string, or it's after another operator or (
                    //there should be a number after
                    if (index == 0 || _operators.contains(stringToWork[index - 1].toString())
                        || stringToWork[index - 1] == '('
                    ) {
                        val indexEnd = findNumberEnd(stringToWork, index + 1)
                        _rpn.add(stringToWork.substring(index, indexEnd + 1))
                        index = indexEnd
                    }
                    //binary
                    else {
                        while (stack.isNotEmpty() && _operators.contains(stack.peek())) _rpn.add(stack.pop())
                        stack.push(stringToWork[index].toString())
                    }
                }
                '*', '/' -> {
                    while (stack.isNotEmpty() &&
                        (stack.peek() == "*" || stack.peek() == "/" || stack.peek() == "^")
                    )
                        _rpn.add(stack.pop())
                    stack.push(stringToWork[index].toString())
                }
                '^' -> stack.push(stringToWork[index].toString())
                in 'A'..'z' -> { //can be a constant
                    var indexEnd = index
                    //getting the letter sequence
                    while (indexEnd + 1 < stringToWork.length && stringToWork[indexEnd + 1].isLetter())
                        indexEnd++
                    val str = stringToWork.substring(index, indexEnd + 1).lowercase()
                    //checking letter sequence that equals constant in _constants
                    if (_constants.containsKey(str)) _rpn.add(_constants[str].toString())
                    //if we didn't find a constant in letters, then something is wrong
                    else throw Error("Unrecognizable letters")

                    index = indexEnd
                }
                in '0'..'9' -> {
                    //adding number to result
                    val indexEnd = findNumberEnd(stringToWork, index)
                    _rpn.add(stringToWork.substring(index, indexEnd + 1))
                    index = indexEnd
                }
                else -> throw Error("Wrong symbols in input")
            }
            index++
        }

        while (stack.isNotEmpty()) _rpn.add(stack.pop())
    }

    private fun countFromRPN(): Double {
        var result: Double
        val stack: Stack<Double> = Stack()

        while (_rpn.isNotEmpty()) {
            if (_rpn.first().toDoubleOrNull() == null) {
                //operator
                if (stack.size > 1) {
                    result = doOperation(stack.pop(), stack.pop(), _rpn.first())
                    stack.push(result)
                } else throw Error("Not enough arguments")
            } else {
                stack.push(_rpn.first().toDouble())
            }
            _rpn.removeFirst()
        }

        return stack.pop()
    }

    private fun findNumberEnd(stringToWork: String, index: Int): Int {
        var indexEnd = index
        while (indexEnd + 1 < stringToWork.length &&
            (stringToWork[indexEnd + 1].isDigit() || stringToWork[indexEnd + 1] == '.')
        )
            indexEnd++
        //checking if the number is a valid number
        //otherwise something went wrong
        if (stringToWork.substring(index, indexEnd + 1).toDoubleOrNull() == null) throw Error("Wrong number format")
        return indexEnd
    }

    private fun doOperation(first: Double, second: Double, operator: String): Double {
        return when (operator) {
            "+" -> second + first
            "-" -> second - first
            "*" -> second * first
            "/" -> second / first
            "^" -> second.pow(first)
            else -> throw Error("Wrong operator")
        }
    }
}
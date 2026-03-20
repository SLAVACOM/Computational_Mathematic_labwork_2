package solver

import math.Decision
import math.Vector
import system.NonlinearSystem
import utill.IterationLogger
import kotlin.math.abs

class NewtonSimpleSolver(start: Vector) : Solver, IterationLogger("Simple Iteration Custom", n = 2) {

    override fun solve(system: NonlinearSystem, start: Vector, eps: Double): Decision {
        var x = start.copy()
        var k = 0
        val n = x.size
        val colWidth = 12
        val lineWidth = 6 + n * (colWidth * 4 + 4)

        printHeader()

        do {
            val xk = x[0]
            val yk = x[1]

            // Новая итерационная формула
            val nextX = xk + (yk * yk - 2 * xk * yk - xk + 2 * yk + 7) / (xk + yk)
            val nextY = yk + (xk * xk - 2 * xk * yk - 2*xk + yk + 7) / (xk + yk)

            val xNext = Vector(doubleArrayOf(nextX, nextY))

            val diffs = DoubleArray(n) { i -> abs(xNext[i] - x[i]) }
            val convFlags = diffs.map { it <= eps }

            printIteration(k, x.values, xNext.values, diffs, convFlags)

            x = xNext
            k++
        } while (convFlags.any { !it })

        println("-".repeat(lineWidth))
        return Decision(x, k)
    }

    override fun getName() = "MN - Custom"

}
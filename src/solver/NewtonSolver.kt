package solver

import math.Decision
import math.Vector
import system.NonlinearSystem
import utill.IterationLogger
import kotlin.math.abs

private val methodName: String = "Метод Ньютона"

class NewtonSolver(start: Vector) : Solver, IterationLogger(methodName, n = start.size) {
    override fun getName() = methodName

    override fun solve(
        system: NonlinearSystem, start: Vector, eps: Double
    ): Decision {

        var x = start.copy()
        var k = 0
        val n = x.size

        val colWidth = 12
        val lineWidth = 6 + n * (colWidth * 4 + 4)

        printHeader()

        do {
            val F = system.F(x)
            val J = system.jacobian(x)

            val dx = J.solve(F)
            val xNext = x - dx

            val diffs = DoubleArray(n) { i -> abs(xNext[i] - x[i]) }
            val convFlags = diffs.map { it <= eps }

           printIteration(k, x.values, xNext.values, diffs, convFlags)

            x = xNext
            k++
        } while (convFlags.any() { !it })

        println("-".repeat(lineWidth))
        return Decision(x, k)
    }
}
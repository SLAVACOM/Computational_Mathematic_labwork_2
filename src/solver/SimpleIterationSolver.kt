package solver

import math.Decision
import math.Vector
import system.NonlinearSystem
import utill.IterationLogger
import kotlin.math.abs

private val methodName = "Метод простых итераций"

class SimpleIterationSolver(start: Vector) : Solver, IterationLogger(
    methodName, n = start.size
) {
    override fun getName() = methodName

    override fun solve(
        system: NonlinearSystem,
        start: Vector,
        eps: Double
    ): Decision {

        var x = start.copy()
        var k = 0

        printHeader()

        do {
            val next = system.phi(x)
            val diffs = DoubleArray(x.size) { i -> next[i] - x[i] }
            val convFlags = diffs.map { abs(it) <= eps }

            k++
            printIteration(k, x.values, next.values, diffs, convFlags)
            x = next
        } while (convFlags.any() { !it })

        return Decision(x, k)
    }
}

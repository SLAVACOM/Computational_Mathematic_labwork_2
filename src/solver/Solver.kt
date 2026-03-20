package solver

import math.Decision
import math.Vector
import system.NonlinearSystem

interface Solver {

    fun getName(): String

    fun solve(
        system: NonlinearSystem,
        start: Vector,
        eps: Double
    ): Decision


}
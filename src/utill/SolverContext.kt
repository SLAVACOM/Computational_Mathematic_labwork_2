package utill

import math.Decision
import math.Vector
import solver.Solver
import system.NonlinearSystem

class SolverContext(private var strategy: Solver) {

    fun setStrategy(strategy: Solver) {
        this.strategy = strategy
    }

    fun solve(system: NonlinearSystem, start: Vector, eps: Double): Decision {
        return strategy.solve(system, start, eps)
    }
}
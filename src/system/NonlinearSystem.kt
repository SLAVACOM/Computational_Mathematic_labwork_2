package system

import math.Matrix
import math.Vector

interface NonlinearSystem {

    val dimension: Int

    fun F(f: Vector): Vector

    fun jacobian(f: Vector): Matrix

    fun phi(f: Vector): Vector

}
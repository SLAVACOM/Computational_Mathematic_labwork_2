package system

import math.Matrix
import math.Vector

class ExampleSystem3D : NonlinearSystem {

    override val dimension: Int = 3

    override fun F(f: Vector): Vector {
        val (x, y, z) = f.values

        return Vector(
            doubleArrayOf(
                x*x + y*y + z*z - 6,   // F1
                x + y + z - 3,         // F2
                x*y - z                // F3
            )
        )
    }

    override fun jacobian(f: Vector): Matrix {
        val (x, y, z) = f.values

        return Matrix(
            arrayOf(
                doubleArrayOf(2*x, 2*y, 2*z),  // ∂F1/∂x, ∂F1/∂y, ∂F1/∂z
                doubleArrayOf(1.0, 1.0, 1.0),  // ∂F2/∂x, ∂F2/∂y, ∂F2/∂z
                doubleArrayOf(y, x, -1.0)      // ∂F3/∂x, ∂F3/∂y, ∂F3/∂z
            )
        )
    }

    override fun phi(f: Vector): Vector {
        val alpha = 0.1
        val (x, y, z) = f.values

        val nextX = x - alpha * (x*x + y*y + z*z - 6)
        val nextY = y - alpha * (x + y + z - 3)
        val nextZ = z - alpha * (x*y - z)

        return Vector(doubleArrayOf(nextX, nextY, nextZ))
    }

}
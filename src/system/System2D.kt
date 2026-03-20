package system

import math.Matrix
import math.Vector
import kotlin.math.sqrt

class System2D : NonlinearSystem {

    override val dimension = 2

    override fun F(f: Vector): Vector {

        val x = f[0]
        val y = f[1]

        return Vector(
            doubleArrayOf(
                x * x + y * y - x * y - 7,
                x - y - 1
            )
        )
    }

    override fun jacobian(f: Vector): Matrix {

        val x = f[0]
        val y = f[1]

        return Matrix(
            arrayOf(
                doubleArrayOf(2 * x - y, 2 * y - x),
                doubleArrayOf(1.0, -1.0)
            )
        )
    }

    override fun phi(f: Vector): Vector {
        val x = f[0]
        val y = f[1]

        val nextX = x - 0.25 * (x * x + y * y - x * y - 7) + 0.25 * (x - y - 1)
        val nextY = y - 0.25 * (x * x + y * y - x * y - 7) + 1.25 * (x - y - 1)

        return Vector(
            doubleArrayOf(
                nextX,
                nextY
            )
        )
    }

    override fun toString(): String {
        return "F1(x, y) = x^2 + y^2 - xy - 7\n" +
                "F2(x, y) = x - y - 1\n"
    }

}
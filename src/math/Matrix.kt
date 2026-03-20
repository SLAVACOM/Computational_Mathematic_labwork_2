package math

class Matrix(val size: Int) {

    private val data: Array<DoubleArray> =
        Array(size) { DoubleArray(size) }

    constructor(values: Array<DoubleArray>) : this(values.size) {
        for (i in values.indices)
            for (j in values.indices)
                data[i][j] = values[i][j]
    }

    operator fun get(i: Int, j: Int) = data[i][j]

    operator fun set(i: Int, j: Int, value: Double) {
        data[i][j] = value
    }

    fun copy(): Matrix {
        val m = Matrix(size)
        for (i in 0 until size)
            for (j in 0 until size)
                m[i, j] = data[i][j]
        return m
    }

    override fun toString(): String =
        buildString {
            for (row in data) {
                append(row.joinToString(" ", "[", "]"))
                append("\n")
            }
        }


    fun solve(b: Vector): Vector {
        val n = size
        val a = Array(n) { DoubleArray(n + 1) }

        for (i in 0 until n) {
            for (j in 0 until n)
                a[i][j] = data[i][j]
            a[i][n] = b[i]
        }

        for (k in 0 until n) {
            var max = k
            for (i in k + 1 until n)
                if (kotlin.math.abs(a[i][k]) >
                    kotlin.math.abs(a[max][k]))
                    max = i

            val tmp = a[k]
            a[k] = a[max]
            a[max] = tmp

            for (i in k + 1 until n) {
                val factor = a[i][k] / a[k][k]
                for (j in k until n + 1)
                    a[i][j] -= factor * a[k][j]
            }
        }

        val x = DoubleArray(n)

        for (i in n - 1 downTo 0) {
            var sum = a[i][n]
            for (j in i + 1 until n)
                sum -= a[i][j] * x[j]

            x[i] = sum / a[i][i]
        }

        return Vector(x)
    }
}
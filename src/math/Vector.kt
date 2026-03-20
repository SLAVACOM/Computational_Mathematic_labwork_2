package math

import kotlin.math.abs
import kotlin.math.max

class Vector(val values: DoubleArray) {

    constructor(size: Int) : this(DoubleArray(size))

    val size: Int
        get() = values.size

    operator fun get(i: Int) = values[i]

    operator fun set(i: Int, value: Double) {
        values[i] = value
    }

    operator fun plus(other: Vector): Vector =
        Vector(DoubleArray(size) { values[it] + other[it] })

    operator fun minus(other: Vector): Vector =
        Vector(DoubleArray(size) { values[it] - other[it] })


    fun copy() = Vector(values.copyOf())

    override fun toString(): String =
        values.joinToString(", ", "[", "]") {
            "%.6f".format(it)
        }
}
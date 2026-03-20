import system.System2D
import math.Vector
import solver.NewtonSolver
import solver.SimpleIterationSolver
import solver.Solver
import system.ExampleSystem3D


private const val epsilon = 1e-4

fun main() {
    val system = System2D();
    val start = Vector(doubleArrayOf(1.0, 0.0))

    val strategies: Map<Int, Solver> = mapOf(
        1 to NewtonSolver(start),
        2 to SimpleIterationSolver(start),
        3 to SimpleIterationSolver(start)
    )

//    val system = ExampleSystem3D();
//    val start = Vector(doubleArrayOf(1.0, .5, .5))

    println(
        """
Лабораторная работа: 3-4
Решение нелинейных систем уравнений
Начальное приближение: $start
Точность: ε = $epsilon
Система: 
$system
""".trimIndent()
    )

    var choice: Int
    do {
        printMenu()
        choice = readlnOrNull()?.toIntOrNull() ?: -1

        if(choice in strategies.keys) {
            val solver = strategies[choice]!!

            val result = solver.solve(system, start, epsilon)
            println("Решение ${solver.getName()}\n${result.vector}, итераций: ${result.iterations}")

        } else if (choice != 0) {
            println("Неверный выбор. Пожалуйста, выберите 1, 2 или 0.")
        }

    } while (choice != 0)

    println("Спасибо за использование программы!")
}

fun printMenu() {
    println(
        """Выберите метод решения:
1 - Метод Ньютона
2 - Метод простых итераций
3 - Метод простых итераций явный
0 - Выход
        """.trimIndent()
    )
}
# Computational Mathematic Labwork 2

## Лабораторная работа 3-4

Учебный проект по вычислительной математике: численное решение нелинейных систем уравнений методами Ньютона и простых итераций.

## Технологии

- Язык: `Kotlin`
- Платформа: `JVM`
- Тип приложения: консольное

## Что реализовано

- Решение систем нелинейных уравнений для 2D и 3D примеров
- Метод Ньютона (`NewtonSolver`)
- Метод простых итераций (`SimpleIterationSolver`)
- Базовые математические структуры (`Vector`, `Matrix`)
- Логирование итерационного процесса

## Как работает программа

1. В `src/Main.kt` выбирается система и метод решения.
2. Система уравнений берется из `src/system/`.
3. Решатель из `src/solver/` выполняет итерации до достижения критерия остановки.
4. Вычисления опираются на `src/math/`.
5. Данные о шагах решения собираются в `src/utill/`.
6. В консоль выводится найденное приближение и статус сходимости.

## Структура проекта

```text
src/
  Main.kt
  math/
	Decision.kt
	Matrix.kt
	Vector.kt
  solver/
	NewtonSolver.kt
	SimpleIterationSolver.kt
	Solver.kt
  system/
	ExampleSystem3D.kt
	NonlinearSystem.kt
	System2D.kt
  utill/
	IterationLogger.kt
	SolverContext.kt
```

## Быстрый старт

### В IntelliJ IDEA

1. Откройте проект как папку.
2. Убедитесь, что подключен Kotlin SDK/JDK.
3. Запустите `src/Main.kt`.

### Через CLI (PowerShell)

```powershell
$sources = Get-ChildItem -Path .\src -Recurse -Filter *.kt | ForEach-Object { $_.FullName }
kotlinc $sources -include-runtime -d .\app.jar
java -jar .\app.jar
```

## Git-файлы проекта

- `LICENSE` - текст лицензии MIT
- `CONTRIBUTING.md` - краткие правила для вкладов
- `CODE_OF_CONDUCT.md` - нормы общения в репозитории
- `CHANGELOG.md` - история изменений

## Автор

`slavacom.dev@gmail.com`

## Лицензия

Проект распространяется по лицензии MIT. Подробности: `LICENSE`.

fun main() {
    var continuar = true

    while (continuar) {
        mostrarMenu()
        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> Actividadvotos()
            2 -> compareNum()
            3 -> numPositive()
            4 -> notas()
            5 -> cicloFor()
            6 -> cicloWhile()
            7 -> ejercicioArreglo()
            8 -> ejercicioLista()
            9 -> {
                println("¡Gracias por usar el programa!")
                continuar = false
            }
            else -> println("Opción inválida. Por favor seleccione una opción del 1 al 9.")
        }

        if (continuar) {
            println("\nPresione Enter para continuar...")
            readLine()
        }
    }
}

fun mostrarMenu() {
    println("\n" + "=".repeat(40))
    println("         MENÚ DE OPCIONES")
    println("=".repeat(40))
    println("1. Verificar si puede votar")
    println("2. Comparar dos números")
    println("3. Verificar si número es positivo/negativo")
    println("4. Clasificar nota")
    println("5. Mostrar números del 1 al 100 (For)")
    println("6. Mostrar números del 1 al 50 (While)")
    println("7. Mostrar datos de arreglo")
    println("8. Mostrar datos de lista")
    println("9. Salir")
    println("=".repeat(40))
}

fun Actividadvotos() {
    println("\n--- VERIFICACIÓN DE EDAD PARA VOTAR ---")
    print("Por favor ingrese su edad: ")
    val edad = readLine()?.toIntOrNull()

    if (edad != null && edad >= 18) {
        println(" Usted puede realizar su voto")
    } else if (edad != null) {
        println(" Lo siento, aún no puedes hacer un voto")
    } else {
        println(" Por favor ingrese una edad válida")
    }
}

fun compareNum() {
    println("\n--- COMPARACIÓN DE NÚMEROS ---")
    print("Ingrese el primer número: ")
    val num1 = readLine()?.toIntOrNull()
    print("Ingrese el segundo número: ")
    val num2 = readLine()?.toIntOrNull()

    if (num1 == null || num2 == null) {
        println(" Ingrese valores correctos")
    } else if (num1 == num2) {
        println(" Los números son iguales")
    } else {
        println(" Los números son distintos")
    }
}

fun numPositive() {
    println("\n--- VERIFICAR SIGNO DEL NÚMERO ---")
    print("Por favor ingrese un número: ")
    val positivo = readLine()?.toIntOrNull()

    if (positivo == null) {
        println(" Ingrese un número correcto por favor")
    } else if (positivo > 0) {
        println(" El número que usted ingresó es positivo")
    } else if (positivo == 0) {
        println(" El número que usted ingresó es cero")
    } else {
        println(" El número que usted ingresó es negativo")
    }
}

fun notas() {
    println("\n--- CLASIFICACIÓN DE NOTAS ---")
    print("Ingrese su nota (1-10): ")
    val nota = readLine()?.toIntOrNull()

    if (nota != null) {
        val clasificacion = when (nota) {
            in 1..3 -> "Reprobado "
            in 4..5 -> "Regular ⚠"
            in 6..8 -> "Bueno "
            in 9..10 -> "Aprobado "
            else -> "Nota inválida "
        }
        println("Su clasificación es: $clasificacion")
    } else {
        println("❌ Por favor ingrese un número válido")
    }
}

fun cicloFor() {
    println("\n--- NÚMEROS DEL 1 AL 100 (CICLO FOR) ---")
    for (i in 1..100) {
        print("$i ")
        if (i % 10 == 0) println() // Nueva línea cada 10 números
    }
    println()
}

fun cicloWhile() {
    println("\n--- NÚMEROS DEL 1 AL 50 (CICLO WHILE) ---")
    var i = 1
    while (i <= 50) {
        print("$i ")
        if (i % 10 == 0) println() // Nueva línea cada 10 números
        i++
    }
    println()
}

fun ejercicioArreglo() {
    println("\n--- EJERCICIO ARREGLO ---")
    val arreglo = arrayOf("Ana", "Carlos", "María", "Pedro", "Sofía")

    println("Datos del arreglo:")
    for (i in arreglo.indices) {
        println("Posición $i: ${arreglo[i]}")
    }

    println("\nUsando forEach:")
    arreglo.forEach { elemento ->
        println("- $elemento")
    }
}

fun ejercicioLista() {
    println("\n--- EJERCICIO LISTA ---")
    val lista = listOf("Manzana", "Banana", "Naranja", "Uva", "Fresa")

    println("Datos de la lista:")
    for (i in lista.indices) {
        println("Índice $i: ${lista[i]}")
    }

    println("\nUsando forEach:")
    lista.forEach { elemento ->
        println(" $elemento")
    }
}
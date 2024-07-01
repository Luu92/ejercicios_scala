import scala.io.StdIn.readLine
import scala.math.{Pi, pow}
import scala.annotation.switch

@main def hello(): Unit =
  // saludo()
  // calcularAreaPerimetro()
  // areaTriangulo()
  // sumarDigitos()
  // diaFestivo()
  // calcularCalificacion()
  // celciusToFahrenheit()
  // esPalindromo()
  esPrimo()

//1) Ejercicio 2
def saludo(): Unit = {
  println("Por favor, ingresa tu nombre:");
  val nombre = readLine();
  println("Hola, " + nombre + " desde Scala");
}

//2) Ejercicio 16
def calcularAreaPerimetro(): Unit = {
  print("Por favor, ingresa el radio: ");
  val radio = readLine().toDouble
  val area = Pi * pow(radio, 2);
  val volumen = (4.0 / 3.0) * Pi * pow(radio, 3);
  println("El área de un circulo con " + radio + " es: " + area)
  println("El Volumen de un circulo con " + radio + " es: " + volumen)
}

//3) Ejercicio 21
def areaTriangulo(): Unit = {
  print("Por favor, ingresa la base: ");
  val base = readLine().toDouble
  print("Por favor, ingresa la altura: ");
  val altura = readLine().toDouble
  val area = ((base * altura) / 2).toDouble;
  println(
    "El área de un triangulo con Base: " + base + ", Altura: " + altura + " Es: " + area
  );
}

//4) Ejercicio 31
def sumarDigitos(): Unit = {
  println("Por favor, ingresa el número")
  val numero = readLine().toInt
  val arregloDigitos = numero.toString().map(_.asDigit).toArray
  val suma = arregloDigitos.sum
  println("La suma de los digitos de " + numero + " es: " + suma)
}

//5) Ejercicio 44
def diaFestivo(): Unit = {
  println("Por favor, ingresa el día: ")
  val dia = readLine().toInt
  println("Por favor, ingresa el Mes: ")
  val mes = readLine().toInt
  val message = (dia, mes) match {
    case (1, 1)   => "Happy new year!!"
    case (1, 7)   => "Canada Day´s"
    case (12, 25) => "Christmas day"
    case _        => "AnyWay!!!"
  }
  println(message)
}

//6) Ejercicio 51
def calcularCalificacion(): Unit = {
  println("Por favor, ingresa la letra de tu calificación: ")
  var cal = readLine().toString()
  val menssage = (cal) match {
    case ("A+") => 4.0
    case ("A")  => 4.0
    case ("A-") => 3.7
    case ("B+") => 3.3
    case ("B")  => 3.0
    case ("B-") => 2.7
    case ("C+") => 2.3
    case ("C")  => 2.0
    case ("C-") => 1.7
    case ("D")  => 1.0
    case ("F")  => 0
    case _      => "Revisar calificación"
  }

  println("Tu calificación es: " + menssage);
}

//7) Ejercicio 63 Convertir de Celcius a Fahrenheit
def celciusToFahrenheit(): Unit = {
  println("Grados (°C) -- (°F)")
  for (i <- 0 to 100 if i % 10 == 0) {
    println("\t" + i + "\t" + ((i * 1.8) + 32))
  }
}

//8) Ejercicio 72 Es palindromo una cadena
def esPalindromo(): Unit = {
  println("Por favor, ingresa la palabra: ")
  var cadena = readLine().toString()
  var arrayString = cadena.toArray
  var tam = arrayString.length
  for (i <- 0 until tam / 2) {
    if (arrayString(i) == arrayString(tam - 1 - i))
      println(
        "[" + arrayString(i) + "]" + " - [" + arrayString(tam - 1 - i) + "]"
      )
    else
      println("No es palindromo :(")
  }
}

//9)

//10) ejercicio 92 Es primo
def esPrimo(): Unit = {
  println("Por favor, ingresa tu numero")
  var numero = readLine().toInt

  if (numero <= 1) {
    println(s"El número $numero NO es un número primo")
  } else {
    var esPrimo = true
    for (i <- 2 to math.sqrt(numero).toInt if esPrimo) {
      if (numero % i == 0) {
        esPrimo = false
      }
    }
    if (esPrimo) {
      println(s"El número $numero es primo")
    } else {
      println(s"El número $numero NO es un número primo")
    }
  }

}

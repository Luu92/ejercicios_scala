import scala.io.StdIn.readLine
import scala.math.{Pi, pow}
import scala.annotation.switch
import scala.collection.mutable.ListBuffer
import scala.util.Random
import scala.io.Source
import java.io.PrintWriter
import scala.io.Source



@main def hello(): Unit =
  //Lamado a funciones 1 - 18 Ejercicos realizados
   saludo()
  // calcularAreaPerimetro()
  // areaTriangulo()
  // sumarDigitos()
  // diaFestivo()
  // calcularCalificacion()
  // celciusToFahrenheit()
  // esPalindromo()
  // esPrimo()
  // calcularTarifa()
  // quitarRepetidos()
  // numLoteria()
  // simularLanzamientoDados()
  // cadenaEnMorse()
  //agregarNumerosDeLinea()
  //detectarPalabrasRepetidas()
  //buscarPalabrasConVocalesEnOrden()
  //buscarElementosDeletreables()




//1) Ejercicio 2
def saludo(): Unit = {
  println("Por favor, ingresa tu nombre:");
  val nombre = readLine();
  println(s"Hola, $nombre desde Scala");
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

//9) Ejercicio 83: Calcular tarifa
def calcularTarifa(): Unit = {
  println("Por favor, ingresa la cantidad de articulos")
  var articulos = readLine().toInt
  var totalTarifa = 0.0;

  if (articulos <= 0) {
    println("Debe tener al menos 1 articulo para enviar");
  } else if (articulos == 1)
    totalTarifa = 10.95;
  else
    totalTarifa = ((articulos - 1) * 2.95) + 10.95;

  println(s"Total a pagar: $totalTarifa ")

}

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

//11) Ejericicio 107: Leer cadenas de texto por el usuario, cuando el usuario teclea un caracter vacio termina el programa mostrando la lista original y una nueva lista sin repetidos.
def quitarRepetidos(): Unit = {

  var numero = "";
  val listaPalabras = ListBuffer[String]()
  var continuar = true;

  println(
    "Por favor, ingresa las palabras o números (deja vacío y presiona enter para terminar):"
  );

  while (continuar) {
    numero = readLine().toString()
    if (numero.isEmpty()) {
      continuar = false
    } else
      listaPalabras += numero
  }
  println("Lista de completa: | " + listaPalabras.mkString(" | "))
  var listaSinDuplicados = listaPalabras.distinct
  println("Lista Sin Duplicados: | " + listaSinDuplicados.mkString(" | "))
}

//12) Ejercicio 114) 6 números aleatorios en un concurso de loteria, no repetidos y de forma ascendente.
def numLoteria(): Unit = {
  val numerosAleatorios = Random.shuffle(1 to 49).take(6).sorted;
  println(
    "Los números de tu billete de lotería son: \n" + numerosAleatorios.mkString(
      " | "
    )
  )
}

//13) Ejercicio 129) Simulación lanzamiento de dados
def simularLanzamientoDados(): Unit = {
  val totalTiradas = 1000
  val conteos =
    Array.fill(13)(0) // Array para almacenar los conteos de cada total (2 a 12)

  // Función interna para simular lanzar un par de dados de seis caras
  def lanzarDados(): Int = {
    val dado1 = Random.nextInt(6) + 1 // Genera un número entre 1 y 6
    val dado2 = Random.nextInt(6) + 1
    dado1 + dado2
  }

  // Simular 1,000 tiradas
  for (_ <- 1 to totalTiradas) {
    val resultado = lanzarDados()
    conteos(resultado) += 1
  }

  // Calcular porcentajes simulados
  val porcentajesSimulados =
    conteos.map(conteo => (conteo.toDouble / totalTiradas) * 100)

  // Porcentajes esperados según la teoría de la probabilidad
  val porcentajesEsperados = Array(0.0, 0.0, 2.78, 5.56, 8.33, 11.11, 13.89,
    16.67, 13.89, 11.11, 8.33, 5.56, 2.78)

  // Mostrar los resultados en una tabla
  println(f"Total  Porcentaje Simulado  Porcentaje Esperado")
  for (total <- 2 to 12) {
    println(
      f"$total%5d  ${porcentajesSimulados(total)}%17.2f  ${porcentajesEsperados(total)}%16.2f"
    )
  }
}

//14) Ejercicio 131) Código Morse
def cadenaEnMorse(): Unit = {
//Diccionario
  val morseCode: Map[Char, String] = Map(
    'A' -> ".-",
    'B' -> "-...",
    'C' -> "-.-.",
    'D' -> "-..",
    'E' -> ".",
    'F' -> "..-.",
    'G' -> "--.",
    'H' -> "....",
    'I' -> "..",
    'J' -> ".---",
    'K' -> "-.-",
    'L' -> ".-..",
    'M' -> "--",
    'N' -> "-.",
    'O' -> "---",
    'P' -> ".--.",
    'Q' -> "--.-",
    'R' -> ".-.",
    'S' -> "...",
    'T' -> "-",
    'U' -> "..-",
    'V' -> "...-",
    'W' -> ".--",
    'X' -> "-..-",
    'Y' -> "-.--",
    'Z' -> "--..",
    '0' -> "-----",
    '1' -> ".----",
    '2' -> "..---",
    '3' -> "...--",
    '4' -> "....-",
    '5' -> ".....",
    '6' -> "-....",
    '7' -> "--...",
    '8' -> "---..",
    '9' -> "----."
  )

  println("Por favor, Ingresa la cadena a convertir");
  var cadena = readLine().toString()
  cadena = cadena
    .toUpperCase()
    .replaceAll("\\s", "")
    .flatMap(char =>
      {
        morseCode.get(char).map(_ + " ").getOrElse("")
      }.trim()
    );
  println(s"La cadena morse es: $cadena");
}

//15) Ejercicio 144) Leer un archivo  y agregar el contenido en otro archivo, con nuevas lineas de texto
def agregarNumerosDeLinea(): Unit = {
  // Ruta fija para el archivo de entrada
  val rutaEntrada = "src/documents/input/"
  val rutaSalida = "src/documents/output/"

  // Leer el nombre del archivo de entrada y el archivo de salida del usuario
  println("Por favor, ingresa el nombre del archivo de entrada")
  val nombreArchivoEntrada = readLine()
  println("Por favor, ingresa el nombre del archivo de salida")
  val nombreArchivoSalida = readLine()

  // Construir las rutas completas para los archivos
  val archivoEntrada = rutaEntrada + nombreArchivoEntrada
  val archivoSalida = rutaSalida + nombreArchivoSalida

  // Leer el contenido del archivo de entrada
  val lineas = Source.fromFile(archivoEntrada).getLines().toList

  // Abrir el archivo de salida para escribir
  val escritor = new PrintWriter(archivoSalida)

  try {
    // Agregar números de línea y escribir en el archivo de salida
    for ((linea, index) <- lineas.zipWithIndex) {
      escritor.println(s"${index + 1}: $linea")
    }

    // Solicitar al usuario que ingrese nuevas líneas
    println(
      "Ingresa líneas adicionales para agregar al archivo (deja una línea en blanco para finalizar):"
    )
    var lineaAdicional = readLine()
    var contador = lineas.length + 1

    while (lineaAdicional.nonEmpty) {
      escritor.println(s"$contador: $lineaAdicional")
      contador += 1
      lineaAdicional = readLine()
    }

  } finally {
    // Cerrar el escritor
    escritor.close()
  }

  println(s"Archivo guardado en: $archivoSalida")
}

//Ejercicio 16) Detectar palabras repetidas en un archivo llamado poema.txt
import scala.io.Source
import javax.swing.text.DefaultFormatter

def detectarPalabrasRepetidas(): Unit = {
  val rutaEntrada = "src/documents/input/"
  
  println("Por favor, ingresa el nombre del archivo:")
  val nombre = scala.io.StdIn.readLine()
  val filePath = rutaEntrada + nombre;
  
  if (filePath.isEmpty) {
    println("No se proporcionó la ruta del archivo.")
  } else {
    try {
      val source = Source.fromFile(filePath)
      val lines = source.getLines().toList
      source.close()

      val pattern = """[\p{Punct}\s]+""" // Expresión regular para dividir por signos de puntuación y espacios
      for ((line, lineNumber) <- lines.zipWithIndex) {
        val words = line.split(pattern).filter(_.nonEmpty).map(_.toLowerCase)
        var previousWord = ""
        for (word <- words) {
          if (word == previousWord) {
            println(
              s"Palabra repetida encontrada en línea ${lineNumber + 1}: '$word'"
            )
          }
          previousWord = word
        }
      }
    } catch {
      case e: Exception =>
        println(s"Error al procesar el archivo: ${e.getMessage}")
    }
  }
}


//17) Ejercicio 163) Buscar palabras con vocales en orden 
def buscarPalabrasConVocalesEnOrden(): Unit = {
    val rutaEntrada = "src/documents/input/"

    println("Por favor, ingresa el nombre del archivo:")
    val nombreArchivo = scala.io.StdIn.readLine()
    val filePath = rutaEntrada + nombreArchivo

    try {
      val source = Source.fromFile(filePath)
      val palabras = source.getLines().toList
      source.close()

      val vocales = "aeiouy"

      // Función para verificar si una palabra contiene las vocales en orden
      def contieneVocalesEnOrden(palabra: String): Boolean = {
        var indexVocal = 0
        for (char <- palabra) {
          if (indexVocal < vocales.length && char == vocales(indexVocal)) {
            indexVocal += 1
          }
        }
        indexVocal == vocales.length
      }

      // Filtrar las palabras que cumplen con la condición
      val palabrasCumplen = palabras.filter(contieneVocalesEnOrden)

      // Mostrar las palabras que cumplen con la condición
      println("Palabras que contienen las vocales 'a', 'e', 'i', 'o', 'u', 'y' exactamente una vez y en orden:")
      palabrasCumplen.foreach(println)

    } catch {
      case e: Exception =>
        println(s"Error al procesar el archivo: ${e.getMessage}")
    }
}

//Ejercicio 18) Jugar si una palabra puede o no escribirse utilizando únicamente símbolos de elementos.
/*
val elementos: Map[String, String] = {
    implicit val formats: DefaultFormatters.type = DefaultFormats
    val source = Source.fromURL("https://raw.githubusercontent.com/Bowserinator/Periodic-Table-JSON/master/PeriodicTableJSON.json")
    val jsonStr = try source.mkString finally source.close()
    val elementsJson = parse(jsonStr) \ "elements"
    elementsJson.extract[List[Map[String, String]]].map { elem =>
      val name = elem("name")
      val symbol = elem("symbol")
      name.toLowerCase -> symbol
    }.toMap
  }

// Función recursiva para verificar si se puede deletrear la palabra con símbolos de elementos
  def canSpellWithElements(word: String): (Boolean, String) = {
    val lowerWord = word.toLowerCase

    // Función interna recursiva
    def spellRecursive(remainingWord: String, usedSymbols: String): (Boolean, String) = {
      if (remainingWord.isEmpty) {
        (true, usedSymbols)
      } else {
        elementos.collectFirst {
          case (name, symbol) if remainingWord.startsWith(symbol.toLowerCase) =>
            val (found, symbols) = spellRecursive(remainingWord.substring(symbol.length), usedSymbols + symbol.toUpperCase)
            if (found) (true, symbols)
            else (false, "")
        }.getOrElse(false, "")
      }
    }

    spellRecursive(lowerWord, "")
  }

  // Función principal para buscar y mostrar los nombres de elementos que se pueden deletrear
  def buscarElementosDeletreables(): Unit = {
    println("Elementos químicos que se pueden deletrear con símbolos de elementos:")

    for ((name, symbol) <- elementos) {
      val (canSpell, symbolsUsed) = canSpellWithElements(name)
      if (canSpell) {
        println(s"$name se puede escribir como $symbolsUsed")
      }
    }
  }

  */
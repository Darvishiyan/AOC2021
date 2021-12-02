fun readInput(name: String) = File("src", "$name.text").readLines()

fun readInputAsInts(name: String) = readInput(name).map { it.toInt() }

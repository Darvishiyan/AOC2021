class Day03 {

    companion object {
        fun part1(data: List<String>): Int {
            val result = IntArray(data.first().length) { 0 }
            data.forEach {
                it.forEachIndexed { index, c ->
                    if (c == '1') result[index] = result[index] + 1
                }
            }
            var gamma = ""
            var epsilon = ""
            val base = data.size / 2
            result.forEach {
                gamma += if (it >= base) "1" else "0"
                epsilon += if (it >= base) "0" else "1"
            }
            return gamma.toInt(2) * epsilon.toInt(2)
        }

        fun part2(data: List<String>): Int {
            var oxygen = data
            var co2 = data
            var index = 0
            while (index < data.first().length) {
                val item1 = arrayListOf<String>()
                val item0 = arrayListOf<String>()
                oxygen.forEach {
                    if (it[index] == '1') item1.add(it)
                    else item0.add(it)
                }
                oxygen = if (item1.size >= item0.size) item1 else item0
                if (oxygen.size == 1) break
                index++
            }
            index = 0
            while (index < data.first().length) {
                val item1 = arrayListOf<String>()
                val item0 = arrayListOf<String>()
                co2.forEach {
                    if (it[index] == '1') item1.add(it)
                    else item0.add(it)
                }
                co2 = if (item0.size <= item1.size) item0 else item1
                if (co2.size == 1) break
                index++
            }
            return oxygen.first().toInt(2) * co2.first().toInt(2)
        }
    }
}

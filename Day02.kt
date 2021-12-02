class Day02 {
    enum class Action {
        FORWARD, DOWN, UP,
    }

    companion object {
        fun part1(data: List<String>): Int {
            var horizontal = 0
            var depth = 0
            data.map { it.split(" ") }
                .map { (a, b) -> valueOf(a.uppercase()) to b.toInt() }
                .forEach { (act, count) ->
                    when (act) {
                        FORWARD -> horizontal += count
                        DOWN -> depth += count
                        UP -> depth -= count
                    }
                }
            return horizontal * depth
        }

        fun part2(data: List<String>): Int {
            var horizontal = 0
            var depth = 0
            var aim = 0
            data.map { it.split(" ") }
                .map { (a, b) -> valueOf(a.uppercase()) to b.toInt() }
                .forEach { (act, count) ->
                    when (act) {
                        FORWARD -> {
                            horizontal += count
                            if (aim != 0) depth += aim * count
                        }
                        DOWN -> aim += count
                        UP -> aim -= count
                    }
                }
            return horizontal * depth
        }
    }
}

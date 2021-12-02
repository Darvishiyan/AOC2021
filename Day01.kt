class Day01 {
    companion object {
        fun part1(data: List<Int>): Int {
            return data.windowed(2).count { (a, b) -> a < b }
        }

        fun part2(data: List<Int>): Int {
            return data.windowed(3).windowed(2).count { (a, b) -> a.sum() < b.sum() }
        }
    }
}

package net.codefudge.fun.gameoflife

class GameOfLife {
    static void main(String[] args) {
        def gol = new GameOfLife()

//        String grid = '''.......
//..***..
//..***..
//..***..'''

//        String grid = '''*..*.**
//.*.**..
//*.*.*.*
//.*.*.*.'''

        String grid = '''.......
...*...
..*.*.*
.....*.'''

        1000.times {
            println grid + '\n\n\n'
            grid = gol.next(grid)
            sleep(500)
        }

    }

    String next(String grid) {
        String r = ''

        def lines = grid.readLines()

        for (int row = 0; row < lines.size(); row++) {
            String line = ''
            for (int col = 0; col < lines[row].size(); col++) {
                line += computeState(row, col, grid)
            }
            r += (r != '' ? '\n' : '') + line
        }

        r
    }

    def computeState(int row, int col, String grid) {
        if (overPopulation(row, col, grid)) {
            return '.'
        } else if (survive(row, col, grid)) {
            return '*'
        } else if (becomeLive(row, col, grid)) {
            return '*'
        } else {
            '.'
        }
    }

    boolean overPopulation(int row, int col, String grid) {
        return (alive(row, col, grid)) && countLivingNeighbours(row, col, grid) > 3
    }

    boolean survive(int row, int col, String grid) {
        return (alive(row, col, grid)) && [2, 3].contains(countLivingNeighbours(row, col, grid))
    }

    boolean becomeLive(int row, int col, String grid) {
        return (dead(row, col, grid)) && countLivingNeighbours(row, col, grid) == 3
    }

    int countLivingNeighbours(int row, int col, String grid) {
        alive(row - 1, col - 1, grid) +
                alive(row - 1, col, grid) +
                alive(row - 1, col + 1, grid) +
                alive(row, col - 1, grid) +
                alive(row, col + 1, grid) +
                alive(row + 1, col - 1, grid) +
                alive(row + 1, col, grid) +
                alive(row + 1, col + 1, grid)
    }

    int alive(int row, int col, String grid) {
        hasChar(row, col, grid, '*')
    }

    int dead(int row, int col, String grid) {
        hasChar(row, col, grid, '.')
    }

    int hasChar(int row, int col, String grid, String c) {
        if (row < 0 || col < 0 || row >= grid.readLines().size() || col >= grid.readLines()[0].size()) {
            return 0
        }

        return grid.readLines()[row][col] == c ? 1 : 0
    }
}

package net.codefudge.fun.gameoflife

class GameOfLifeNoColl implements GameOfLife {
    String next(String grid) {
        String r = ''

        int rows = rows(grid)
        int cols = cols(grid)

        for (int row = 0; row < rows; row++) {
            String line = ''
            for (int col = 0; col < cols; col++) {
                line += computeState(row, col, grid)
            }
            r += (r != '' ? '\n' : '') + line
        }

        r
    }

    int cols(String grid) {
        def cols = grid.indexOf('\n')

        cols == -1 ? grid.length() : cols
    }

    int rows(String grid) {
        int rows = 0
        grid.eachLine { rows++ }
        rows
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
        int rows = rows(grid)
        int cols = cols(grid)
        if (row < 0 || col < 0 || row >= rows || col >= cols) {
            return 0
        }

        def currentRow = 0
        def result = 0

        grid.eachLine {
            if (currentRow == row) {
                result = it[col] == c ? 1 : 0
            }

            currentRow++
        }

        return result
    }
}

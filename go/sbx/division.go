package main

import "fmt"

func main() {
	div(4, 2)
	div(4, 1)
	div(5, 1)
	div(5, 2)
	div(5, 3)
	div(9, 3)
	div(12, 3)
	div(14, 3)
}

func div(a, b int) {
	r1, r2 := div_(a, b)
	fmt.Printf("%v div %v = %v remainder %v\n", a, b, r1, r2)
}

func div_(a, b int) (int, int) {
	if (a < b) {
		return 0, a
	}

	r1, r2 := div_(a-b, b)

	return 1 + r1, r2
}

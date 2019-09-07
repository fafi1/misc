package main

import "fmt"

func main() {
	powerPrint(0)
	powerPrint(1)
	powerPrint(2)
	powerPrint(3)
	powerPrint(4)
	powerPrint(5)
	powerPrint(6)
	powerPrint(7)
	powerPrint(8)
	powerPrint(9)
	powerPrint(10)
}

func powerPrint(b int) {
	fmt.Printf("2^%v=%v\n", b, power2(b))
}

func power2(b int) int {
	if (b == 0) {
		return 1
	}

	r := power2(b - 1)

	return r + r
}

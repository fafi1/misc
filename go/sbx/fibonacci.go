package main

import "fmt"

func main() {
	fmt.Println(c(0))
	fmt.Println(c(1))
	fmt.Println(c(2))
	fmt.Println(c(3))
	fmt.Println(c(4))
	fmt.Println(c(5))
	fmt.Println(c(6))
	fmt.Println(c(7))
	fmt.Println(c(8))
	fmt.Println(c(9))
	fmt.Println(c(10))
	fmt.Println(c(11))
	fmt.Println(c(12))
	fmt.Println(c(13))
	fmt.Println(c(35))
}

func c(x int) int {
	if x == 1 {
		return 1
	}

	if x == 0 {
		return 0
	}

	return c(x-1) + c(x-2)
}
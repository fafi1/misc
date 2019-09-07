package main

import "fmt"

func main() {
	fmt.Printf("%v times %v = %v\n", 1, 1, multiply(1, 1))
	fmt.Printf("%v times %v = %v\n", 1, 2, multiply(1, 2))
	fmt.Printf("%v times %v = %v\n", 2, 2, multiply(2, 2))
	fmt.Printf("%v times %v = %v\n", 3, 2, multiply(3, 2))
	fmt.Printf("%v times %v = %v\n", 3, 10, multiply(3, 10))
	fmt.Printf("%v times %v = %v\n", 5, 3, multiply(5,3))
}

func multiply(x, y int) int {
	if y == 1 {
		return x
	} else {
		return x + multiply(x, y - 1)
	}
}

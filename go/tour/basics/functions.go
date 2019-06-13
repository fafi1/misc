package main

import "fmt"

func add(x int, y int) int {
	return x + y
}

func add2(x, y int) int {
	return add(x, y)
}

func main() {
	fmt.Println(add(2, 3))
	fmt.Println(add2(2, 3))
}

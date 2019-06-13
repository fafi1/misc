package main

import "fmt"

func divWithRemainder(x, y int) (result, remainder int) {
	result = x / y
	remainder = x % y

	return result, remainder
}

func divWithRemainder2(x, y int) (result, remainder int) {
	result = x / y
	remainder = x % y

	return
}

func main() {
	result, remainder := divWithRemainder(10, 3)
	fmt.Println(result, remainder)
	fmt.Println(divWithRemainder(10, 3))
	fmt.Println(divWithRemainder(8, 3))
	fmt.Println(divWithRemainder2(8, 3))
}

package main

import (
	"fmt"
	"strconv"
)

func main() {
	for i := 0; i < 10; i++ {
		fmt.Println(SomeTest("hello " + strconv.Itoa(i)))
	}

	i :=0
	for ; i<10; {
		i++
		fmt.Println(SomeTest("hello2 " + strconv.Itoa(i)))
	}

	sum := 2
	for sum < 1000 {
		sum += sum
		fmt.Println(sum)
	}
}

func SomeTest(d string) string {
	return d
}
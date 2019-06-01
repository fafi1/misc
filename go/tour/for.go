package main

import (
	"fmt"
	"strconv"
)

func main() {
	for i := 0; i < 10; i++ {
		fmt.Println(SomeTest("hello " + strconv.Itoa(i)))
	}
}

func SomeTest(d string) string {
	return d
}
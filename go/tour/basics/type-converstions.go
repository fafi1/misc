package main

import (
	"fmt"
	"math"
)

func main() {
	x, y := 3, 5
	f := math.Sqrt(float64(x*x + y*y))
	z := uint(f)

	fmt.Println(x, y, f, z)
}

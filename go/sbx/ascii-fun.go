package main

import (
	"fmt"
)

func main() {
	fmt.Println(triangleLeft(30))
	fmt.Println(triangleRight1(30, 0))
	fmt.Println(triangleIso(30, 0))
	fmt.Println(triangleIso(25, 0))
}

func triangleLeft(x int) string {
	if x == 0 {
		return ""
	}

	return line(x, "*") + "\n" + triangleLeft(x-1)
}

func triangleRight1(x, pad int) string {
	if x == 0 {
		return ""
	}

	return line(pad, " ") + line(x, "*") + "\n" + triangleRight1(x-1, pad+1)
}

func triangleIso(x, pad int) string {
	if x == 0 {
		return ""
	}

	if x == 1 {
		return line(pad, " ") + "*"
	}

	return line(pad, " ") + line(x, "*") + "\n" + triangleIso(x-2, pad + 1)
}

func line(l int, c string) string {
	if l == 0 {
		return ""
	}
	return c + line(l-1, c)
}

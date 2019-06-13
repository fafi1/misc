package main

import "fmt"

type T struct {
	a int
	b string
}

func main() {
	t := T{1, "test"}
	t1 := &t
	var t2 = t1

	fmt.Println(t.b)
	fmt.Println(t1.b)
	fmt.Println(t2.a)
}

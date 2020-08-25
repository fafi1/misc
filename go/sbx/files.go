package main

import "os"
import "fmt"

func main() {
	stat, error := os.Stat("sbx/files.go")

	fmt.Println(stat.Size())
	fmt.Println(error)
}
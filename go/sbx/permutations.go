package main

import "fmt"

func main() {
	num := 6
	fmt.Println(perm1(num))
	fmt.Println(perm2(num))
	fmt.Println(perm3(num))
	fmt.Println(perm4(num))
	fmt.Println(perm5(num))

	fmt.Println(perm(1, num))
	fmt.Println(perm(2, num))
	fmt.Println(perm(3, num))
	fmt.Println(perm(4, num))
	fmt.Println(perm(5, num))
	fmt.Println(perm(6, num))
	fmt.Println(perm(7, num))
	fmt.Println(perm(8, num))
}

func perm1(num int) map[int]int {
	var perms = make(map[int]int)

	for i := 1; i <= num; i++ {
		perms[i] += 1
	}

	return perms
}

func perm2(num int) map[int]int {
	var perms = make(map[int]int)

	for i := 1; i <= num; i++ {
		for j := 1; j <= num; j++ {
			perms[i+j] += 1
		}
	}

	return perms
}

func perm3(num int) map[int]int {
	var perms = make(map[int]int)

	for i := 1; i <= num; i++ {
		for j := 1; j <= num; j++ {
			for k := 1; k <= num; k++ {
				perms[i+j+k] += 1
			}
		}
	}

	return perms
}

func perm4(num int) map[int]int {
	var perms = make(map[int]int)

	for i := 1; i <= num; i++ {
		for j := 1; j <= num; j++ {
			for k := 1; k <= num; k++ {
				for l := 1; l <= num; l++ {
					perms[i+j+k+l] += 1
				}
			}
		}
	}

	return perms
}

func perm5(num int) map[int]int {
	var perms = make(map[int]int)

	for i := 1; i <= num; i++ {
		for j := 1; j <= num; j++ {
			for k := 1; k <= num; k++ {
				for l := 1; l <= num; l++ {
					for m := 1; m <= num; m++ {
						perms[i+j+k+l+m] += 1
					}
				}
			}
		}
	}

	return perms
}

func perm(dices int, num int) map[int]int {
	permMap := make(map[int]int)
	permInternal(dices, num, 0, make([]int, dices), permMap)

	return permMap
}

//change using append and slices
func permInternal(dices int, num int, current int, values []int, perms map[int]int) {
	if dices == current {
		perms[sum(values)] += 1
	} else {
		for i := 1; i <= num; i++ {
			values[current] = i
			permInternal(dices, num, current+1, values, perms)
		}
	}
}

func sum(values []int) int {
	sum := 0
	for i := 0; i < len(values); i++ {
		sum += values[i]
	}

	return sum
}

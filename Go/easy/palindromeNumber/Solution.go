package main

import "fmt"

func main() {
	fmt.Println("Hello world!")
}

// https://leetcode.com/problems/palindrome-number/
// Runtime: 8 ms, faster than 94.47% of Go online submissions for Palindrome Number.
// Memory Usage: 5.2 MB, less than 100.00% of Go online submissions for Palindrome Number.
func isPalindrome(x int) bool {
	res, i := 0, x
	for i > 0 {
		res = res*10 + i%10
		i /= 10
	}
	return res == x
}

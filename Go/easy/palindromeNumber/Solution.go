package main

import "fmt"

func main() {
	fmt.Println(isPalindrome(121))
}

// https://leetcode.com/problems/palindrome-number/
// Runtime: 4 ms, faster than 99.47% of Go online submissions for Palindrome Number.
// Memory Usage: 5.2 MB, less than 100.00% of Go online submissions for Palindrome Number.
func isPalindrome(x int) bool {
	if x == 0 {
		return true
	}
	if x < 0 || x%10 == 0 {
		return false
	}
	reverted := 0
	for x > reverted {
		reverted = reverted*10 + x%10
		x /= 10
	}
	return reverted == x || reverted/10 == x
}

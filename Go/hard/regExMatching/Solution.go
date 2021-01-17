package main

import "fmt"

func main() {
	s, p := "aab", "c*a*b"
	fmt.Println(isMatch(s, p))
}

func isMatch(s string, p string) bool {
	slen, plen := len(s), len(p)
	if (len(s) == 0 && len(p) == 0) || p == ".*" || p == s {
		return true
	}
	return compareChars(s, p, 0, 0, slen, plen)
}

func compareChars(s string, p string, sindex int, pindex int, slen int, plen int) bool {
	fmt.Printf("\n%#U, S index %d - ", s[sindex], sindex)
	if pindex < plen {
		fmt.Printf("%#U, P index %d\n", p[pindex], pindex)
	}
	if pindex < plen-1 && p[pindex+1] == '*' {
		if p[pindex] == '.' {
			fmt.Println(".* - recursively looping s++")
			for sindex < slen {
				if compareChars(s, p, sindex, pindex+2, slen, plen) {
					return true
				}
				sindex++
			}
		} else {
			fmt.Println("char* - recursively looping s++")
			for sindex < slen && s[sindex] == p[pindex] {
				if compareChars(s, p, sindex, pindex+2, slen, plen) {
					return true
				}
				sindex++
			}
		}
	} else if pindex < plen && (p[pindex] == s[sindex] || p[pindex] == '.') {
		fmt.Println("char or '.' match without next char *")
		return compareChars(s, p, sindex+1, pindex+1, slen, plen)
	} else if pindex == plen {
		fmt.Println("p reached end, did s? : ")
		return sindex == slen
	} else {
		fmt.Println("s reached end, checking for * in p")
		for pindex < plen {
			if !(p[pindex] == '*' || (pindex < plen-1 && p[pindex+1] == '*')) {
				return false
			}
			pindex++
		}
	}
	fmt.Println("all other checks passed, return true")
	return true
}

// Backtracking
// func isMatch(s string, p string) bool {
// 	slen, plen, sindex, pindex, ssaved, psaved := len(s), len(p), 0, 0, -1, -1
// 	for sindex < slen {
// 		fmt.Printf("\n%#U, S index %d - ", s[sindex], sindex)
// 		if pindex < plen {
// 			fmt.Printf("%#U, P index %d\n", p[pindex], pindex)
// 		}
// 		if pindex < plen-1 && (p[pindex+1] == '*') {
// 			pindex += 2
// 			if p[pindex-2] == '.' {
// 				fmt.Println(".* sequence, saving values for backtracking")
// 				psaved = pindex
// 				ssaved = sindex
// 			} else {
// 				fmt.Println("char* sequence, incrementing s while same char as p")
// 				for sindex < slen && s[sindex] == p[pindex-2] {
// 					sindex++
// 				}
// 			}
// 		} else if pindex < plen && (s[sindex] == p[pindex] || p[pindex] == '.') {
// 			fmt.Println("chars match, or '.' which matches any single char")
// 			sindex++
// 			pindex++
// 		} else if ssaved != -1 {
// 			fmt.Println("Not match, backtracking possible")
// 			ssaved++
// 			pindex = psaved
// 			sindex = ssaved
// 		} else {
// 			fmt.Println("Not match, backtracking failed")
// 			return false
// 		}
// 	}
// 	fmt.Println("Exhausted all chars in string, need to increment p and if not * (or next *) return false")
// 	for pindex < plen {
// 		if p[pindex] == '*' || (pindex < plen-1 && p[pindex+1] == '*') {
// 			pindex++
// 		} else {
// 			return false
// 		}
// 	}
// 	return true
// }

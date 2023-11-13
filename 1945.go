package leetcode

import "strconv"

func getLucky(s string, k int) int {
	s_number := ""
	for _, c := range s {
		s_number = s_number + strconv.Itoa(int(c-'a'+1))
	}

	for k > 0 {
		temp_int := 0
		for _, c := range s_number {
			temp_int += int(c - '0')
		}
		s_number = strconv.Itoa(temp_int)
		k--
	}
	num, _ := strconv.Atoi(s_number)
	return num

}

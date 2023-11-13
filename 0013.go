package leetcode

func romanToInt(s string) int {

	num := 0

	for index, char := range s {
		switch char {
		case 'I':
			num += 1
		case 'V':
			num += 5
		case 'X':
			num += 10
		case 'L':
			num += 50
		case 'C':
			num += 100
		case 'D':
			num += 500
		case 'M':
			num += 1000
		}

		if index+1 < len(s) {
			nextChar := s[index+1]
			switch char {
			case 'I':
				if nextChar == 'V' || nextChar == 'X' {
					num -= 2
				}
			case 'X':
				if nextChar == 'L' || nextChar == 'C' {
					num -= 20
				}
			case 'C':
				if nextChar == 'D' || nextChar == 'M' {
					num -= 200
				}
			}
		}
	}
	return num
}

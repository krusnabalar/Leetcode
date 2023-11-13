package leetcode

func isValidSudoku(board [][]byte) bool {
	col_checks := [9][9]byte{}
	block_checks := [9][9]byte{}
	for row_idx, row := range board {
		row_check := [9]byte{}
		for col_idx, cell := range row {
			if string(cell) == "." {
				continue
			}
			cell_num := int(cell - '1')
			if row_check[cell_num] > 0 {
				return false
			}
			if col_checks[col_idx][cell_num] > 0 {
				return false
			}
			block_idx := row_idx/3*3 + col_idx/3
			if block_checks[block_idx][cell_num] > 0 {
				return false
			}

			row_check[cell_num] = 1

			col_checks[col_idx][cell_num] = 1

			block_checks[block_idx][cell_num] = 1
		}
	}
	return true
}

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        col_nums = [set() for i in range(9)]
        box_nums = [set() for i in range(9)]
    
        for row_idx, row in enumerate(board):
            row_nums = set()
            for col_idx, cell in enumerate(row):
                box_idx = int(col_idx / 3) + 3 * int(row_idx / 3)
                if cell == ".":
                    continue
                num = int(cell)
                if num in col_nums[col_idx] or num in row_nums or num in box_nums[box_idx]:
                    return False
                col_nums[col_idx].add(num)
                row_nums.add(num)
                box_nums[box_idx].add(num)

                

        return True

        
        
        
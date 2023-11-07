/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {

	if list1 == nil && list2 == nil {
		return nil
	} else if list1 == nil {
		return list2
	} else if list2 == nil {
		return list1
	}

	var newHead *ListNode
	ptr1 := list1
	ptr2 := list2
	if list1.Val > list2.Val {
		newHead = list2
		ptr2 = list2.Next
	} else {
		newHead = list1
		ptr1 = list1.Next
	}
	curr := newHead

	for ptr1 != nil || ptr2 != nil {
		if ptr1 == nil {
			curr.Next = ptr2
			ptr2 = ptr2.Next
		} else if ptr2 == nil {
			curr.Next = ptr1
			ptr1 = ptr1.Next
		} else if ptr1.Val > ptr2.Val {
			curr.Next = ptr2
			ptr2 = ptr2.Next
		} else {
			curr.Next = ptr1
			ptr1 = ptr1.Next
		}
		if curr.Next != nil {
			curr = curr.Next
		}
	}

	return newHead
}
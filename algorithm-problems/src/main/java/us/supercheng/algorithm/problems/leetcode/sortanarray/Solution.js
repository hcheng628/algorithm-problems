/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArray = function(nums) {
    helper(nums, 0, nums.length-1);
    return nums;
};

var helper = function (nums, left, right) {
    if (left >= right)
        return;

    var mid = parseInt(left + (right - left) / 2),
        arr = [],
        l1 = left,
        l2 = mid+1,
        len,
        i;

    helper(nums, left, mid);
    helper(nums, mid+1, right);

    while (l1<=mid && l2 <= right)
        if (nums[l1] < nums[l2]) {
            arr.push(nums[l1]);
            l1 +=1;
        } else {
            arr.push(nums[l2]);
            l2 +=1;
        }

    for (;l1 <= mid; l1+=1)
        arr.push(nums[l1]);

    for (; l2 <= right; l2 +=1)
        arr.push(nums[l2]);


    for (i=0, len=arr.length; i<len; i+=1)
        nums[i+left] = arr[i];
};
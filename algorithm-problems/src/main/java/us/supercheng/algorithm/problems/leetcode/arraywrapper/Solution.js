/**
 * @param {number[]} nums
 */
var ArrayWrapper = function(nums) {
    this.arr = nums;
};

ArrayWrapper.prototype.valueOf = function() {
    var ret = 0,
        a;

    for (a of this.arr)
        ret += a;

    return ret;
}

ArrayWrapper.prototype.toString = function() {
    return  ['[', this.arr.join(','), ']'].join('');
}

/**
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 * obj1 + obj2; // 10
 * String(obj1); // "[1,2]"
 * String(obj2); // "[3,4]"
 */
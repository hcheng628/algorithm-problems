var xorOperation = function(n, start) {
    var arr = [],
        i = 0,
        ret;

    for (; i<n; i+=1)
        arr.push(start + i*2);

    ret = arr[0];
    for (i=1; i<n; i+=1)
        ret ^= arr[i];

    return ret;
};
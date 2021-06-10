/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
var findRotation = function(mat, target) {
    var i,
        size = target.length;

    for (i=0; i<4; i+=1) {
        mat = rotate(mat, size);
        if (isSame(mat, target, size))
            return true;
    }

    return false;
};

var rotate = function(mat, size) {
    var i,
        j,
        ii,
        copy = [];

    for (i=0; i<size; i+=1) {
        copy.push([]);
        for (j=0, idx=copy.length-1; j<size; j+=1)
            copy[idx].push([]);
    }

    for (i=0, ii=size-1; i<size; i+=1, ii-=1)
        for (j=0; j<size; j+=1)
            copy[j][ii] = mat[i][j];

    return copy;
}

var isSame = function(a, b, size) {
    var i,
        j;

    for (i=0; i<size; i+=1)
        for (j=0; j<size; j+=1)
            if (a[i][j] != b[i][j])
                return false;

    return true;
}
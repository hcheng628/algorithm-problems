/**
 * @param {number} n
 */
var OrderedStream = function(n) {
    this.ptr = 1;
    this.map = {};
};

/**
 * @param {number} id
 * @param {string} value
 * @return {string[]}
 */
OrderedStream.prototype.insert = function(id, value) {
    var ret = [];
    this.map[id] = value;

    for (; this.map[this.ptr]; this.ptr += 1)
        ret.push(this.map[this.ptr]);

    return ret;
};
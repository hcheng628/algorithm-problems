function Node(val,children) {
    this.val = val;
    this.children = children;
}

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var ret = [],
        q = [],
        row_count = 0,
        row,
        n;

    if (root)
        q.push(root);

    while (q.length != 0) {
        row = [];

        for (row_count = q.length; row_count>0; row_count-=1) {
            n = q.shift();
            row.push(n.val)

            if (n.children)
                n.children.forEach(function(c){
                    q.push(c);
                });
        }

        ret.push(row);
    }

    return ret;
};
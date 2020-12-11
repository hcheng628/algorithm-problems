/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 */
var CBTInserter = function(root) {
    var i = 0,
        curr;

    this.list = [];
    if (root)
        this.list.push(root);

    for (;i<this.list.length; i+=1) {
        curr = this.list[i];
        if (curr.left)
            this.list.push(curr.left);

        if (curr.right)
            this.list.push(curr.right);
    }
};

/**
 * @param {number} v
 * @return {number}
 */
CBTInserter.prototype.insert = function(v) {
    var parent_idx = parseInt(this.list.length / 2),
        parent = this.list[this.list.length % 2 == 0 ? parent_idx - 1 : parent_idx],
        node = new TreeNode(v);

    this.list.push(node);

    if (!parent.left)
        parent.left = node;
    else
        parent.right = node;

    return parent.val;
};

/**
 * @return {TreeNode}
 */
CBTInserter.prototype.get_root = function() {
    return this.list.length > 0 ? this.list[0] : null;
};
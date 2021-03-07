/**
 * @param {string[][]} items
 * @param {string} ruleKey
 * @param {string} ruleValue
 * @return {number}
 */
var countMatches = function(items, ruleKey, ruleValue) {
    var ret = 0,
        rule_idx = 0;

    if (ruleKey == 'color')
        rule_idx = 1;
    else if (ruleKey == 'name')
        rule_idx = 2;

    items.forEach(function(item) {
        if (item[rule_idx] == ruleValue)
            ret += 1;
    });

    return ret;
};
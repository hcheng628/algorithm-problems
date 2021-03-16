/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var areAlmostEqual = function(s1, s2) {
    var list1,
        list2,
        len,
        i,
        c1,
        c2;

    if (s1.length != s2.length)
        return false;

    list1 = [];
    list2 = [];

    for (i=0, len=s1.length; i<len; i+=1) {
        c1 = s1[i];
        c2 = s2[i];
        if (c1 != c2) {
            list1.push(c1);
            list2.push(c2);
            if (list1.length > 2)
                return false;
        }
    }

    return list1.length == 0 || (list1.length == 2 && list1[0] == list2[1] && list1[1] == list2[0]);
};
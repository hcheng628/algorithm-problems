/**
 * @param {string} number
 * @return {string}
 */
var reformatNumber = function(number) {
    var list = [],
        ans = [],
        i,
        len;

    for (i=0, len=number.length; i<len; i+=1)
        if (number[i] >= "0" && number[i] <= "9")
            list.push(number[i]);

    for (i=0, len=list.length; i<len; i+=3)
        if (i + 4 == len) {
            ans.push([list[i] + list[i+1]], [list[i+2] + list[i+3]]);
            i+=1;
        } else if (i + 2 == len)
            ans.push(list[i] + list[i+1]);
        else
            ans.push(list[i] + list[i+1] + list[i+2]);

    return ans.join("-");
};
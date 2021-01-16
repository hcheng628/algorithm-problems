/**
 * @param {number[][]} boxTypes
 * @param {number} truckSize
 * @return {number}
 */
var maximumUnits = function(boxTypes, truckSize) {
    var ret = 0,
        i,
        len,
        amt,
        unit;

    boxTypes.sort(function(a, b) {
        return b[1] - a[1];
    });

    for (i=0, len=boxTypes.length; i<len && truckSize!=0; i+=1) {
        amt = boxTypes[i][0];
        unit = boxTypes[i][1];

        if (amt <= truckSize) {
            ret += amt * unit;
            truckSize -= amt;
        } else {
            ret += truckSize * unit;
            truckSize = 0;
        }
    }

    return ret;
};
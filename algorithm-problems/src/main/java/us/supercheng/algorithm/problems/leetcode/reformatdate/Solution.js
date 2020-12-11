/**
 * @param {string} date
 * @return {string}
 */
var reformatDate = function(date) {
    var M = {
            "Jan": "01",
            "Feb": "02",
            "Mar": "03",
            "Apr": "04",
            "May": "05",
            "Jun": "06",
            "Jul": "07",
            "Aug": "08",
            "Sep": "09",
            "Oct": "10",
            "Nov": "11",
            "Dec": "12"
        },
        arr = date.split(' ');

    return [arr[2], M[arr[1]], (arr[0].length == 4 ? arr[0].substring(0,2) : '0' + arr[0].charAt(0))].join('-');
};
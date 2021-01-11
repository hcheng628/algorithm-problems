/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    var bucket = [0, 0],
        sand,
        i,
        len;

    students.forEach(function(stu) {
        bucket[stu] += 1;
    });

    for (i=0, len=sandwiches.length; i<len; i+=1) {
        sand = sandwiches[i];
        if (bucket[sand] < 1)
            return bucket[1 - sand];
        bucket[sand] -= 1;
    }

    return 0;
};

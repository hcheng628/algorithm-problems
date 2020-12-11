var average = function(salary) {
    var min = salary[0],
        max = salary[0],
        total = 0.0;

    salary.forEach(function (each) {
        if (each > max)
            max = each;
        if (each < min)
            min = each;
        total += each;
    });

    return (total - min - max) / (salary.length - 2);
};
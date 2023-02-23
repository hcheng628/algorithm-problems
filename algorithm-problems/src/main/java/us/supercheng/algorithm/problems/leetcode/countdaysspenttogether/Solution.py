class Solution(object):
    def countDaysTogether(self, arriveAlice, leaveAlice, arriveBob, leaveBob):
        """
        :type arriveAlice: str
        :type leaveAlice: str
        :type arriveBob: str
        :type leaveBob: str
        :rtype: int
        """
        arrive = max(arriveAlice, arriveBob)
        leave = min(leaveAlice, leaveBob)
        if leave < arrive:
            return 0

        arrive_month = int(arrive[0:2])
        leave_month = int(leave[0:2])
        arrive_date = int(arrive[3:])
        leave_date = int(leave[3:])
        if arrive_month == leave_month:
            return leave_date - arrive_date + 1

        ret = 0
        days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
        for i in range(arrive_month + 1, leave_month):
            ret += days[i - 1]

        return days[arrive_month - 1] - arrive_date + 1 + ret + leave_date

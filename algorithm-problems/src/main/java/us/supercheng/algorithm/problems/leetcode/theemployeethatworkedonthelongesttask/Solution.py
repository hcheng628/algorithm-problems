class Solution(object):
    def hardestWorker(self, n, logs):
        """
        :type n: int
        :type logs: List[List[int]]
        :rtype: int
        """
        info = [logs[0][0], logs[0][1]]

        for i in range(1, len(logs)):
            if logs[i][1] - logs[i - 1][1] > info[1] or (logs[i][1] - logs[i - 1][1] == info[1] and logs[i][0] < info[0]):
                info = [logs[i][0], logs[i][1] - logs[i - 1][1]]

        return info[0]

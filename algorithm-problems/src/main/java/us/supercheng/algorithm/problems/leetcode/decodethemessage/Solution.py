class Solution(object):
    def decodeMessage(self, key, message):
        """
        :type key: str
        :type message: str
        :rtype: str
        """
        m = {}
        idx = 0
        ret = []

        for k in key:
            if k != " " and k not in m:
                m[k] = chr(ord('a') + idx)
                idx += 1

        for msg in message:
            ret.append(msg if msg == " " else m[msg])

        return "".join(ret)

class Solution(object):
    def minNumberOfHours(self, initialEnergy, initialExperience, energy, experience):
        """
        :type initialEnergy: int
        :type initialExperience: int
        :type energy: List[int]
        :type experience: List[int]
        :rtype: int
        """
        ret = max(sum(energy) - initialEnergy + 1, 0)

        for e in experience:
            if initialExperience <= e:
                ret += e - initialExperience + 1
                initialExperience = e + 1
            initialExperience += e

        return ret

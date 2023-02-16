class Solution(object):
    def strongPasswordCheckerII(self, password):
        """
        :type password: str
        :rtype: bool
        """
        if password is None or len(password) < 8:
            return False

        has_lower = False
        has_upper = False
        has_digit = False
        has_special = False

        for i in range(len(password)):
            if i != 0 and password[i - 1] == password[i]:
                return False

            if not (has_lower and has_upper) and password[i].isalpha():
                if not has_lower and password[i].lower() == password[i]:
                    has_lower = True
                if not has_upper and password[i].upper() == password[i]:
                    has_upper = True

            if not has_digit and password[i].isdigit():
                has_digit = True

            if not has_special and "!@#$%^&*()-+".find(password[i]) > -1:
                has_special = True

        return has_upper and has_lower and has_digit and has_special

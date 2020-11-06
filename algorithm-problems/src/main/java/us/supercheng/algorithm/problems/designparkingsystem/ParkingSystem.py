class ParkingSystem:

    def __init__(self, big: int, medium: int, small: int):
        self.m = {
            1: big,
            2: medium,
            3: small
        }

    def addCar(self, carType: int) -> bool:
        if self.m[carType] > 0:
            self.m[carType] -= 1
            return True
        return False

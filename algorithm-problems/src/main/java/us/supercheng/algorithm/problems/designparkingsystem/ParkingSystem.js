/**
 * @param {number} big
 * @param {number} medium
 * @param {number} small
 */
var ParkingSystem = function(big, medium, small) {
    this.map = {
        1: big,
        2: medium,
        3: small
    }
};

/**
 * @param {number} carType
 * @return {boolean}
 */
ParkingSystem.prototype.addCar = function(carType) {
    if (this.map[carType] > 0) {
        this.map[carType] -= 1;
        return true;
    }

    return false;
};

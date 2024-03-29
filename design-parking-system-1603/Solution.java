
/**
 * LeetCode problem # 1603, 'Design Parking System'
 * https://leetcode.com/problems/design-parking-system
 */

class ParkingSystem {

    int[] capacity;

    public ParkingSystem(int big, int medium, int small) {
        this.capacity = new int[] { big, medium, small };
    }

    public boolean addCar(int carType) {
        return --capacity[carType - 1] >= 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */
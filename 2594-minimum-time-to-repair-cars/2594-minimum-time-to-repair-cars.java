class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = -1;

        for (int rank : ranks) {
            right = Math.max(right, (long) rank * cars * cars);
        }

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long totalRepaired = 0;
        
        for (int rank : ranks) {
            long carsRepairedByMechanic = (long) Math.sqrt(time / rank);
            totalRepaired += carsRepairedByMechanic;
            
            if (totalRepaired >= cars) {
                return true;
            }
        }
        
        return false;
    }
}

class Solution {
    class Car {
        public double pos;
        public int spd;
        public Car(double _pos, int _spd) {
            pos = _pos;
            spd = _spd;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cars.add(new Car((double) position[i], speed[i]));
        }
        Collections.sort(cars, (c1, c2)->{return -Double.compare(c1.pos, c2.pos);});
        int ret = 0;
        double preT = 0.0;
        for (Car car : cars) {
            double t = 1.0 * (target - car.pos) / car.spd;
            if (t > preT) {
                ret++;
                preT = t;
            }
        }
        return ret;
    }
}
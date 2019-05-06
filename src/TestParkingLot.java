import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestParkingLot {

    @Test
    void testParkingLot(){
        ParkingLot lot = new ParkingLot(4,10);
        List<Vehicle> list = new ArrayList<>();
        for (int i = 0; i < 50 ; i++) {
            final Vehicle v = i % 2 == 0? new Car():new Truck();
            list.add(v);
            boolean hasSpot = lot.hasSpot(v);
            if (i < 40) {
                assert hasSpot;
                assert lot.park(v);
            } else {
                assert  !hasSpot;
                assert !lot.park(v);
            }
        }
        assert  list.size() == 50;
        int i = 0;
        for (Vehicle v : list) {
            assert i >= 40 || lot.leave(v);
            i++;
        }

    }

    @Test
    void testOptimization() {
        ParkingLot lot = new ParkingLot(4,10);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            Car v = new Car();
            assert lot.hasSpot(v);
            assert lot.park(v);
            if (i >= 30) {
                carList.add(v);
            }
        }
        for (Car v : carList) {
            assert lot.leave(v);
        }
        List<Truck> truckList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
          Truck t = new Truck();
          assert lot.hasSpot(t);
          assert lot.park(t);
          truckList.add(t);
        }
        for (Truck t : truckList) {
            assert lot.leave(t);
        }
    }

}

public class ParkingSpot {
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size){
        this.size = size;
    }

    boolean fit(Vehicle v) {
        return currentVehicle == null && size.getSize() >= v.getSize().getSize();
    }

    boolean strictFit(Vehicle v){
        return currentVehicle == null && size.getSize() == v.getSize().getSize();
    }

    boolean unoptimizedParking() {
        return currentVehicle != null && currentVehicle.getSize().getSize() < size.getSize();
    }
    void park(Vehicle v){
        this.currentVehicle = v;
    }

    void leave() {
        this.currentVehicle = null;
    }

    Vehicle getCurrentVehicle() {
        return this.currentVehicle;
    }
}

import model.Car;
import model.Motorcycle;
import model.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class VehicleTest {

    // проверка того, что экземпляр объекта Car также является экземпляром транспортного средства;
    @Test
    void  carObjectIsAnInstanceOfVehicle() {
        Car car = new Car("Toyota", "Ist", 2010); // это мой автомобиль
        assertThat(car instanceof Vehicle);
    }

    // проверка того, объект Car создается с 4-мя колесами
    @Test
    void carNumWheels() {
        Car car = new Car("Toyota", "Ist", 2010); // это мой автомобиль
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void motorcycleNumWheels() {
        Motorcycle bike = new Motorcycle("Jawa", "Jawa-350", 1970); // это мотоцикл моего деда
        assertThat(bike.getNumWheels()).isEqualTo(2);
    }

    // проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void carSpeedTestDrive() {
        Car car = new Car("Toyota", "Ist", 2010); // это мой автомобиль
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void motorcycleSpeedTestDrive() {
        Motorcycle bike = new Motorcycle("Jawa", "Jawa-350", 1970); // это мотоцикл моего деда
        bike.testDrive();
        assertThat(bike.getSpeed()).isEqualTo(75);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void carSpeedTestDriveAndPark() {
        Car car = new Car("Toyota", "Ist", 2010); // это мой автомобиль
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void motorcycleSpeedTestDriveAndPark() {
        Motorcycle bike = new Motorcycle("Jawa", "Jawa-350", 1970); // это мотоцикл моего деда
        bike.testDrive();
        assertThat(bike.getSpeed()).isEqualTo(75);
        bike.park();
        assertThat(bike.getSpeed()).isEqualTo(0);
    }
}


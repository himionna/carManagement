package carManagement;

public class CarDaoImpl implements ICarDao{
	private Car[] cars; 
	private int index = 0;

	public CarDaoImpl() {
		cars = new Car[10];
	}
	public CarDaoImpl(int size) {
		cars = new Car[size];
	}
	
	@Override
	public boolean save(Car car) {
		if( index < cars.length) {
			cars[index++] = car;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(String carId) {
		for( int i = 0; i < index; i++ ) {
			if( cars[i].getCarId().equals(carId)) {
				for( int j = i+1; j < index; j++) {
					cars[j-1] = cars[j];
				}
				index--;
			}
			
		}
		return false;
	}

	@Override
	public Car queryById(String carId) {
		for(int i = 0;i < index; i++){
			if(cars[i].getCarId().equals(carId)) {
				return cars[i];
			}
		}
		return null;
	}

	@Override
	public Car[] queryByType(String type) {
		int count = 0;
		for(int i = 0; i < index;i++){
			if(cars[i].getType().equals(type)) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Car[] cs = new Car[count];
		for(int i = 0;i<index;i++) {
			if(cars[i].getType().equals(type)) {
				cs[--count] = cars[i];
			}
		}
		return cs;
	}

	@Override
	public Car[] queryByBrand(String brand) {
		int count = 0;
		for(int i = 0; i < index;i++){
			if(cars[i].getBrand().equals(brand)) {
				count++;
			}
		}
		if(0 == count){
			return null;
		}
		Car[] cs = new Car[count];
		for(int i = 0;i<index;i++) {
			if(cars[i].getBrand().equals(brand)) {
				cs[--count] = cars[i];
			}
		}
		return cs;
	}

	@Override
	public Car[] queryAll() {
		Car[] cs = new Car[index];
		System.arraycopy(cars, 0, cs, 0, index);
		return cs;
	}

}

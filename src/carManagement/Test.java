package carManagement;

public class Test {
	
	public static void print(Car[] cars){
		for(Car car : cars){
			System.out.println("Æ·ÅÆ£º" + car.getBrand());
			System.out.println("ÐÍºÅ£º" + car.getType());
			System.out.println("³µÅÆ£º" + car.getCarId());
			System.out.println("----------------------------");
		}
	}
	
	public static void main(String[] args) {
		ICarDao icd= new CarDaoImpl();
		
		Car c1 = new Car("±¦Âí", "X1", "´¨A23333");
		Car c2 = new Car("±¦Âí", "X2", "´¨A23334");
		Car c3 = new Car("±¼³Û", "G65", "´¨A23335");
		Car c4 = new Car("ÂêÉ¯À­µÙ", "LEVANTE", "´¨A23336");
		Car c5 = new Car("±¼³Û", "GLC", "´¨A23337");
		Car c6 = new Car("ÌØË¹À­", "MODEL X", "´¨A23338");
		Car c7 = new Car("±¾Ìï", "XR-V", "´¨A23339");
		Car c8 = new Car("±¼³Û", "A200", "´¨A23330");
		Car c9 = new Car("±¦Âí", "X3", "´¨A23311");
		Car c10 = new Car("ÂêÉ¯À­µÙ", "GHIBLI", "´¨A23322");
		
		icd.save(c1);
		icd.save(c2);
		icd.save(c3);
		icd.save(c4);
		icd.save(c5);
		icd.save(c6);
		icd.save(c7);
		icd.save(c8);
		icd.save(c9);
		icd.save(c10);
		print(icd.queryAll());
		
		System.out.println("---------delete---------");
		icd.delete("´¨A23337");
		print(icd.queryAll());
		
		System.out.println("------------queryById------------");
		Car car = icd.queryById("´¨A23336");
		if(null != car){
			System.out.println("Æ·ÅÆ£º"+car.getBrand());
			System.out.println("ÀàÐÍ£º"+car.getType());
			System.out.println("³µÅÆ£º"+car.getCarId());
			System.out.println("-------------------");
		}
		
		System.out.println("------------queryByBrand------------");
		Car[] car1 = icd.queryByBrand("±¦Âí");
		print(car1);
		
		
	}
}

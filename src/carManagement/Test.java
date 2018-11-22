package carManagement;

public class Test {
	
	public static void print(Car[] cars){
		for(Car car : cars){
			System.out.println("Ʒ�ƣ�" + car.getBrand());
			System.out.println("�ͺţ�" + car.getType());
			System.out.println("���ƣ�" + car.getCarId());
			System.out.println("----------------------------");
		}
	}
	
	public static void main(String[] args) {
		ICarDao icd= new CarDaoImpl();
		
		Car c1 = new Car("����", "X1", "��A23333");
		Car c2 = new Car("����", "X2", "��A23334");
		Car c3 = new Car("����", "G65", "��A23335");
		Car c4 = new Car("��ɯ����", "LEVANTE", "��A23336");
		Car c5 = new Car("����", "GLC", "��A23337");
		Car c6 = new Car("��˹��", "MODEL X", "��A23338");
		Car c7 = new Car("����", "XR-V", "��A23339");
		Car c8 = new Car("����", "A200", "��A23330");
		Car c9 = new Car("����", "X3", "��A23311");
		Car c10 = new Car("��ɯ����", "GHIBLI", "��A23322");
		
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
		icd.delete("��A23337");
		print(icd.queryAll());
		
		System.out.println("------------queryById------------");
		Car car = icd.queryById("��A23336");
		if(null != car){
			System.out.println("Ʒ�ƣ�"+car.getBrand());
			System.out.println("���ͣ�"+car.getType());
			System.out.println("���ƣ�"+car.getCarId());
			System.out.println("-------------------");
		}
		
		System.out.println("------------queryByBrand------------");
		Car[] car1 = icd.queryByBrand("����");
		print(car1);
		
		
	}
}

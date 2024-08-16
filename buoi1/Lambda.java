functionalInterface : 
là interface có duy nhất 1 phương thưucs trừu tượng.
	- phương thức trừu tượng là 1 phương thức được khai báo, nhưng không có trình triển khai
khi tạo 1 interface nào mà chúng ta muốn khai báo interface đó là functionalInterface, chúng ta
phải có @Annotation [@FunctionalInterface] trên tên khởi tạo của interface đó
	VD: tạo 1 interface Animal
	@FunctionalInterface
	public interface Animal {
		void speak();
	}
khi tạo 1 interface nếu interface đó chỉ có 1 phương thức, thì sẽ được tư động hiểu interface là functionalInterface
nhưng ta nên đặt @Annotation cụ thể cho rõ ràng

cách sử dụng khi chưa có lambda:
	VD1: tạo lớp cat
	public class Cat implements Animal {
		@Override
		public void speak() {
			System.out.prinln("meo meo");
		}
	}
cách sử dụng lambda
lambda(lambda expression)
dược giới thiệu trong java8 như 1 cách để đơn giản hoá cách triển khai của functionalInterface
thay vì minh phải tạo lốp để triển khai functionalInterface thì bây h mình chỉ cần khai báo cách
triển khai phương thức của functionalInterface và mình có thể sử dụng nó mà không cần phảiqua lớp
nào hết
	VD1: 
	public class Main {
		@Override
		public static void main(String[] args) {
			Animal meo1 = new Cat(); // VD1 cách thông thường
			System.out.prinln("meo meo"); // meo meo
			// C1
			Animal meo2 = () -> { // VD2: sử dụng lambda
			System.out.prinln("meo meo"); 
			// C2
			Animal meo2 = () -> System.out.prinln("meo meo"); 
			
			};
			meo2.speak(); // meo meo
		}
	}
	Lưu ý: cách triển khai của phương thức mà nhiều hơn 1 dòng thì bắt buộc phải dùng dấu ngoặc nhọn;
	Lưu ý: với phương có 1 tham số thì với biểu thức lambda các bạn có thể không cần dùng dấu ngoặc đơn
		VD: Animal meo2 = firstNasme -> System.out.prinln(firstNasme);
			meo2.speak("Tom");
	Lưu ý: với biểu thức lambda, cách triển khai phương thức mà có nhiều tham số thì mình chỉ cần để tên
	các tham số ở giữa hai ngoặc đơn và cách nhau bằng dấu phẩy.
		VD: Animal meo2 = (firstNasme, lastName) -> System.out.prinln(firstNasme, lastName);
			meo2.speak("Tom", "Pham");
	Lưu ý: triển khai phương thức có dữ liệu trả về:
	VD1: Animal meo2 = (firstNasme, lastName) -> { // cách sử dụng return
			return firstNasme + " " + lastName;
		};
	VD2: Animal meo2 = (firstNasme, lastName) -> firstNasme + " " + lastName; // không cần sử dụng return, biểu thức lambda sẽ tự hiểu phương thức này sẽ trả lại dữ liệu
		meo2.speak("Tom", "Pham");
	khi mình dùng từ khoá return mình bắt buộc phải dùng dấu ngoặc nhọn,
biểu thức lambda chỉ dùng được với functionalInterface
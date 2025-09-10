import com.workintech.cylinder.Circle;
import com.workintech.cylinder.Cylinder;
import com.workintech.pool.Rectangle;
import com.workintech.pool.Cuboid;

import com.workintech.developers.Employee;
import com.workintech.developers.HRManager;
import com.workintech.developers.JuniorDeveloper;
import com.workintech.developers.MidDeveloper;
import com.workintech.developers.SeniorDeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Field;
import java.util.Locale; // Locale import edildi

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    private Circle circle;
    private Cylinder cylinder;
    private Rectangle rectangle;
    private Cuboid cuboid;
    private Employee employee;

    private HRManager hrManager;
    private JuniorDeveloper juniorDeveloper;
    private MidDeveloper midDeveloper;
    private SeniorDeveloper seniorDeveloper;

    @BeforeEach
    void setUp() {
        circle = new Circle(2);
        cylinder = new Cylinder(2, 2);
        rectangle = new Rectangle(1, 2);
        cuboid = new Cuboid(1, 2, 3);
        employee = new Employee(1, "Jane Doe", 20000);
        hrManager = new HRManager(1, "John Doe", 120000);
        juniorDeveloper = new JuniorDeveloper(1, "Junior Doe", 45000);
        midDeveloper = new MidDeveloper(1, "Mid Doe", 60000);
        seniorDeveloper = new SeniorDeveloper(1, "Senior Doe", 100000);
    }

    @DisplayName("Circle sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testCircleAccessModifiers() throws NoSuchFieldException {
        Field radiusField = circle.getClass().getDeclaredField("radius");
        assertEquals(2, radiusField.getModifiers()); // 2 = private
    }

    @DisplayName("Circle sınıf değişkenleri doğru type a sahip mi ?")
    @Test
    public void testCircleTypes() {
        assertThat(circle.getRadius()).isInstanceOf(Number.class);
    }

    @DisplayName("getArea methodu Circle sınıfında doğru çalışıyor mu?")
    @Test
    public void testGetArea() {
        assertTrue(String.format("%.2f", circle.getArea()).contains("12"));
    }

    @DisplayName("Cylinder sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testCylinderAccessModifiers() throws NoSuchFieldException {
        Field heightField = cylinder.getClass().getDeclaredField("height");
        assertEquals(2, heightField.getModifiers());
    }

    @DisplayName("Cylinder sınıfı ve değişkenleri doğru type a sahip mi ?")
    @Test
    public void testCylinderTypes() {
        assertThat(cylinder).isInstanceOf(Circle.class);
        assertThat(cylinder.getHeight()).isInstanceOf(Number.class);
    }

    @DisplayName("getVolume methodu doğru çalışıyor mu?")
    @Test
    public void testGetVolume() {
        assertTrue(String.format("%.2f", cylinder.getVolume()).contains("25"));
    }

    @DisplayName("Rectangle sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testRectangleAccessModifiers() throws NoSuchFieldException {
        Field widthField = rectangle.getClass().getDeclaredField("width");
        assertEquals(2, widthField.getModifiers());
        Field lengthField = rectangle.getClass().getDeclaredField("length");
        assertEquals(2, lengthField.getModifiers());
    }

    @DisplayName("Rectangle sınıf değişkenleri doğru type a sahip mi ?")
    @Test
    public void testRectangleTypes() {
        assertThat(rectangle.getWidth()).isInstanceOf(Number.class);
        assertThat(rectangle.getLength()).isInstanceOf(Number.class);
    }

    @DisplayName("getArea methodu Rectangle sınıfında doğru çalışıyor mu?")
    @Test
    public void testGetAreaRectangle() {
        assertEquals("2.00", String.format(Locale.US, "%.2f", rectangle.getArea()));
    }

    @DisplayName("Cuboid sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testCuboidAccessModifiers() throws NoSuchFieldException {
        Field heightField = cuboid.getClass().getDeclaredField("height");
        assertEquals(2, heightField.getModifiers());
    }

    @DisplayName("Cuboid sınıf değişkenleri doğru type a sahip mi ?")
    @Test
    public void testCuboidTypes() {
        assertThat(cuboid).isInstanceOf(Rectangle.class);
        assertThat(cuboid.getHeight()).isInstanceOf(Number.class);
    }

    @DisplayName("getVolume methodu Cuboid sınıfında doğru çalışıyor mu?")
    @Test
    public void testGetVolumeRectangle() {
        assertEquals("6.00", String.format(Locale.US, "%.2f", cuboid.getVolume()));
    }

    @DisplayName("Employee sınıf değişkenleri doğru access modifier a sahip mi ?")
    @Test
    public void testEmployeeAccessModifiers() throws NoSuchFieldException {
        Field idField = employee.getClass().getDeclaredField("id");
        assertEquals(2, idField.getModifiers());
        Field nameField = employee.getClass().getDeclaredField("name");
        assertEquals(2, nameField.getModifiers());
        Field salaryField = employee.getClass().getDeclaredField("salary");
        assertEquals(2, salaryField.getModifiers());
    }

    @DisplayName("Employee sınıf değişkenleri doğru type a sahip mi ?")
    @Test
    public void testEmployeeTypes() {
        assertThat(employee.getId()).isInstanceOf(Number.class);
        assertThat(employee.getName()).isInstanceOf(String.class);
        assertThat(employee.getSalary()).isInstanceOf(Number.class);
    }

    @DisplayName("Employee sınıfından doğru türeyen sınıflar var mı ?")
    @Test
    public void testEmployeeSubClasses() {
        assertThat(hrManager).isInstanceOf(Employee.class);
        assertThat(juniorDeveloper).isInstanceOf(Employee.class);
        assertThat(midDeveloper).isInstanceOf(Employee.class);
        assertThat(seniorDeveloper).isInstanceOf(Employee.class);
    }
}
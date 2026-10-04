package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void score95ShouldBeA() {
    
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(95.0);
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("85 оноо B дүн байх ёстой")
    void score85ShouldBeB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(85.0);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("75 оноо C дүн байх ёстой")
    void score75ShouldBeC() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(75.0);
        assertEquals("C", grade);
    }

    @Test
    @DisplayName("65 оноо D дүн байх ёстой")
    void score65ShouldBeD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(65.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("30 оноо F дүн байх ёстой")
    void score30ShouldBeF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(30.0);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(90.0);
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (хязгаарын тохиолдол)")
    void score89Point99ShouldBeB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(89.99);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(60.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой (хязгаарын тохиолдол)")
    void score59Point99ShouldBeF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(59.99);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой")
    void zeroShouldBeF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(0.0);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой")
    void hundredShouldBeA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(100.0);
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("-1 оноо оруулахад IllegalArgumentException шидэх ёстой")
    void negativeScoreShouldThrowException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(-1.0)
        );
    }

    @Test
    @DisplayName("101 оноо оруулахад IllegalArgumentException шидэх ёстой")
    void scoreAbove100ShouldThrowException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.letterGrade(101.0)
        );
    }

    @Test
    @DisplayName("Бүх оноо дээд хязгаартай үед нийт оноо 100 байх ёстой")
    void totalScoreShouldBe100() {
        GradeCalculator calc = new GradeCalculator();
        double total = calc.totalScore(10, 40, 10, 10, 30);
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("Ирцийн оноо сөрөг бол IllegalArgumentException шидэх ёстой")
    void negativeAttendanceShouldThrowException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Лабын оноо 40-өөс их бол IllegalArgumentException шидэх ёстой")
    void labAboveMaximumShouldThrowException() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(
                IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30)
        );
    }
}
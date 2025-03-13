import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NewStudentIndexTest {
    private NewStudentIndex studentIndex;

    @BeforeEach
    void setUp() {
        studentIndex = new NewStudentIndex("David", 3);
    }

    @Test
    void testGetGrades() {
        studentIndex.grades = new double[]{2.0, 4.0, 5.0};
        String expectedOutput = "Student: David niedostateczny; dobry; bardzo dobry";
        assertEquals(expectedOutput, studentIndex.printGrades());
    }

    @Test
    void testGetMaxGrade() {
        studentIndex.grades = new double[]{3.0, 4.0, 5.0};
        assertEquals(5.0, studentIndex.getMaxGrade());
    }

    @Test
    void testGetAverage() {
        studentIndex.grades = new double[]{2.0, 2.0, 5.0};
        assertEquals(3.0, studentIndex.getAverage());
    }

    @Test
    void testPrintMissingGrades() {
        studentIndex.grades = new double[]{4.0, 4.0, 5.0};
        String expectedOutput = "Missing grade: 2.0 Missing grade: 3.0 Missing grade: 3.5 Missing grade: 4.5 ";
        assertEquals(expectedOutput, studentIndex.printMissingGrades());
    }

    @Test
    void testAddGrades() throws NewStudentIndex.WrongDataFormatException {
        studentIndex.addGrades(3.0, 4.0, 5.0);
        assertArrayEquals(new double[]{3.0, 4.0, 5.0}, studentIndex.grades, "Grades should be [3.0, 4.0, 5.0]");
    }

    @Test
    void testIsCorrectForm() {
        assertTrue(NewStudentIndex.isCorrectForm(2.0), "2.0 should be a correct grade");
        assertTrue(NewStudentIndex.isCorrectForm(3.0), "3.0 should be a correct grade");
        assertTrue(NewStudentIndex.isCorrectForm(3.5), "3.5 should be a correct grade");
        assertTrue(NewStudentIndex.isCorrectForm(4.0), "4.0 should be a correct grade");
        assertTrue(NewStudentIndex.isCorrectForm(4.5), "4.5 should be a correct grade");
        assertTrue(NewStudentIndex.isCorrectForm(5.0), "5.0 should be a correct grade");

        assertFalse(NewStudentIndex.isCorrectForm(2.5));
        assertFalse(NewStudentIndex.isCorrectForm(1.9));
        assertFalse(NewStudentIndex.isCorrectForm(5.1));
//        assertFalse(NewStudentIndex.isCorrectForm(4.3));
        assertFalse(NewStudentIndex.isCorrectForm(3.25));
        assertFalse(NewStudentIndex.isCorrectForm(4.75));
    }
}
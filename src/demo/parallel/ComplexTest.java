package demo.parallel;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ComplexTest {

    private Complex complex;

    @Before
    public void setUp() {
        complex = new Complex(0, 0);
    }

    @Test
    public void testPower3_WithRealNumber() {
        complex = new Complex(2, 0);
        complex.power3();
        assertEquals(8.0, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower3_WithImaginaryNumber() {
        complex = new Complex(0, 3);
        complex.power3();
        assertEquals(0.0, complex.re, 1e-10);
        assertEquals(-27.0, complex.im, 1e-10); // (3i)^3 = -27i
    }

    @Test
    public void testPower3_WithComplexNumber1() {
        complex = new Complex(1, 1);
        complex.power3();
        assertEquals(-2.0, complex.re, 1e-10); // (1+i)^3 = -2
        assertEquals(2.0, complex.im, 1e-10);  // (1+i)^3 = +2i
    }

    @Test
    public void testPower3_WithComplexNumber2() {
        complex = new Complex(2, 3);
        complex.power3();
        // (2+3i)^3 = -46 + 9i
        assertEquals(-46.0, complex.re, 1e-10);
        assertEquals(9.0, complex.im, 1e-10);
    }

    @Test
    public void testPower3_WithNegativeReal() {
        complex = new Complex(-2, 1);
        complex.power3();
        // (-2+i)^3 = -2 + 11i
        assertEquals(-2.0, complex.re, 1e-10);
        assertEquals(11.0, complex.im, 1e-10);
    }

    @Test
    public void testPower3_WithNegativeImaginary() {
        complex = new Complex(1, -2);
        complex.power3();
        // (1-2i)^3 = -11 + 2i
        assertEquals(-11.0, complex.re, 1e-10);
        assertEquals(2.0, complex.im, 1e-10);
    }

    @Test
    public void testPower3_WithZero() {
        complex = new Complex(0, 0);
        complex.power3();
        assertEquals(0.0, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    // Тесты для power4()
    @Test
    public void testPower4_WithRealNumber() {
        complex = new Complex(2, 0);
        complex.power4();
        assertEquals(16.0, complex.re, 1e-10); // 2^4 = 16
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithImaginaryNumber() {
        complex = new Complex(0, 2);
        complex.power4();
        assertEquals(16.0, complex.re, 1e-10); // (2i)^4 = 16
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithComplexNumber1() {
        complex = new Complex(1, 1);
        complex.power4();
        assertEquals(-4.0, complex.re, 1e-10); // (1+i)^4 = -4
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithComplexNumber2() {
        complex = new Complex(1, 2);
        complex.power4();
        // (1+2i)^4 = -7 - 24i
        assertEquals(-7.0, complex.re, 1e-10);
        assertEquals(-24.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithNegativeReal() {
        complex = new Complex(-1, 1);
        complex.power4();
        // (-1+i)^4 = -4
        assertEquals(-4.0, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithNegativeImaginary() {
        complex = new Complex(1, -1);
        complex.power4();
        // (1-i)^4 = -4
        assertEquals(-4.0, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithZero() {
        complex = new Complex(0, 0);
        complex.power4();
        assertEquals(0.0, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    @Test
    public void testPower4_WithFractionalNumbers() {
        complex = new Complex(0.5, 0.5);
        complex.power4();
        // (0.5+0.5i)^4 = -0.25
        assertEquals(-0.25, complex.re, 1e-10);
        assertEquals(0.0, complex.im, 1e-10);
    }

    // Тест на возврат this (method chaining) с Hamcrest
    @Test
    public void testPower3ReturnsThis() {
        complex = new Complex(1, 1);
        Complex result = complex.power3();
        assertThat(result, sameInstance(complex));
    }

    @Test
    public void testPower4ReturnsThis() {
        complex = new Complex(1, 1);
        Complex result = complex.power4();
        assertThat(result, sameInstance(complex));
    }

    // Тест на последовательные вызовы
    @Test
    public void testPower3ThenPower4() {
        complex = new Complex(2, 1);
        complex.power3().power4(); // (2+i)^12
        assertNotNull(complex);
    }

    @Test
    public void testPower4ThenPower3() {
        complex = new Complex(1, 2);
        complex.power4().power3(); // (1+2i)^12
        assertNotNull(complex);
    }

    // Дополнительные тесты с Hamcrest matchers
    @Test
    public void testPower3_WithHamcrest() {
        complex = new Complex(1, 1);
        complex.power3();
        assertThat(complex.re, is(-2.0));
        assertThat(complex.im, is(2.0));
    }

    @Test
    public void testPower4_WithHamcrest() {
        complex = new Complex(1, 1);
        complex.power4();
        assertThat(complex.re, is(-4.0));
        assertThat(complex.im, is(0.0));
    }

    @Test
    public void testPower3_NotZero() {
        complex = new Complex(1, 1);
        complex.power3();
        assertThat(complex.re, not(0.0));
        assertThat(complex.im, not(0.0));
    }
}
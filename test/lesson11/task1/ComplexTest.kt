package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ComplexTest {

    private fun assertApproxEquals(expected: Complex, actual: Complex, eps: Double) {
        assertEquals(expected.re, actual.re, eps)
        assertEquals(expected.im, actual.im, eps)
    }

    @Test
    fun plus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("4.12-2i"), Complex("1.1+2i") + Complex("3.02-4i"), 1e-10)
        assertApproxEquals(Complex("-4-2i"), Complex("-1+2i") + Complex("-3-4i"), 1e-10)
        assertApproxEquals(Complex("-2i"), Complex("+2i") + Complex("-4i"), 1e-10)
        assertApproxEquals(Complex("9-2i"), Complex("9+2i") + Complex("-4i"), 1e-10)
    }

    @Test
    operator fun unaryMinus() {
        assertApproxEquals(Complex(1.0, -2.0), -Complex(2.0, -1.0), 1e-10)
        assertApproxEquals(Complex(1.99, -2.0), -Complex(2.0, -1.99), 1e-10)
    }

    @Test
    fun minus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("4-2.5i"), Complex("1+2.5i") + Complex("3-5i"), 1e-10)
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
    }

    @Test
    fun times() {
        assertApproxEquals(Complex("11+2i"), Complex("1+2i") * Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("12.5"), Complex("1.5+2i") * Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("-14i"), Complex("3.5") * Complex("-4i"), 1e-10)
        assertApproxEquals(Complex("396"), Complex("99i") * Complex("-4i"), 1e-10)

    }

    @Test
    fun div() {
        assertApproxEquals(Complex("1+2i"), Complex("11+2i") / Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("1.5+2i"), Complex("12.5") / Complex("3-4i"), 1e-10)
        assertApproxEquals(Complex("3.5"), Complex("-14i") / Complex("-4i"), 1e-10)
        assertApproxEquals(Complex("4i"), Complex("396") / Complex("-99i"), 1e-10)
    }

    @Test
    fun hard() {
        assertApproxEquals(Complex("5.3+0.9i"), (Complex("1+i") * Complex("3-2i")) + (Complex("1") / Complex("3+i")), 1e-10)
        assertApproxEquals(Complex("-1.6+16.4i"), (Complex("3+7i") * Complex("2+i")) - (Complex("3+3i") / Complex("5")), 1e-10)
    }

    @Test
    fun equals() {
        assertApproxEquals(Complex(1.0, 2.0), Complex("1+2i"), 1e-12)
        assertApproxEquals(Complex(1.0, 0.0), Complex(1.0), 1e-12)
        assertEquals(Complex(1.0, 2.0), Complex("1+2i"))
        assertFalse(Complex(1.0, 1000.12) != Complex("1+1000.12i"))
    }
}
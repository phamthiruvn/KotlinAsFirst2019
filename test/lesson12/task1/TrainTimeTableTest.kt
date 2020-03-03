package lesson12.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

class TrainTimeTableTest {

    @Test
    @Tag("Normal")
    fun addTrain() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.addTrain("N1", Time(7, 35), Stop("Пушкин", Time(9, 4))))
        assertFalse(ttt.addTrain("N2", Time(7, 18), Stop("Пушкин", Time(8, 45))))
        assertTrue(ttt.addTrain("N3", Time(6, 0), Stop("Пушкин", Time(7, 0))))
        assertTrue(ttt.addTrain("N4", Time(8, 1), Stop("Пушкин", Time(9, 4))))
        assertEquals(
            listOf(
                Train("N3", Stop("СПб", Time(6, 0)), Stop("Пушкин", Time(7, 0))),
                Train("N2", Stop("СПб", Time(6, 18)), Stop("Пушкин", Time(6, 45))),
                Train("N1", Stop("СПб", Time(6, 35)), Stop("Пушкин", Time(7, 4))),
                Train("N4", Stop("СПб", Time(8, 1)), Stop("Пушкин", Time(9, 4)))
            ), ttt.trains()
        )

    }

    @Test
    @Tag("Normal")
    fun removeTrain() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.removeTrain("N3"))
        assertTrue(ttt.removeTrain("N1"))
        assertEquals(1, ttt.trains().size)
        assertTrue(ttt.removeTrain("N2"))
        assertFalse(ttt.removeTrain("N3"))
        assertEquals(0, ttt.trains().size)
    }

    @Test
    @Tag("Hard")
    fun addStop() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertFalse(ttt.addStop("N1", Stop("СПб", Time(6, 31))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 46))))
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("Неверная", Time(7, 11)))
        }
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("СПб", Time(6, 50)))
        }
        assertFalse(ttt.addStop("N1", Stop("Купчино", Time(6, 44))))
        assertFalse(ttt.addStop("N1", Stop("Пушкин", Time(7, 0))))
        assertThrows(IllegalArgumentException::class.java) {
            ttt.addStop("N1", Stop("Пушкин", Time(6, 40)))
        }
        val ttt1 = TrainTimeTable("A")
        assertTrue(ttt1.addTrain("N1", Time(6, 35), Stop("E", Time(9, 4))))
        assertTrue(ttt1.addTrain("N2", Time(6, 18), Stop("E", Time(6, 45))))
        assertFalse(ttt1.addTrain("N2", Time(6, 18), Stop("E", Time(6, 50))))
        assertTrue(ttt1.addStop("N1", Stop("B", Time(7, 34))))
        assertTrue(ttt1.addStop("N1", Stop("C", Time(7, 44))))
        assertTrue(ttt1.addStop("N1", Stop("D", Time(8, 0))))
        assertThrows(IllegalArgumentException::class.java) {
            ttt1.addStop("N1", Stop("E", Time(7, 40)))
        }
        assertThrows(IllegalArgumentException::class.java) {
            ttt1.addStop("N1", Stop("A", Time(7, 40)))
        }
        assertFalse(ttt1.addStop("N1", Stop("D", Time(9, 0))))
        assertFalse(ttt1.addStop("N1", Stop("A", Time(6, 0))))
        assertEquals(
            listOf(
                Train(
                    "N1" , listOf(
                        Stop("A", Time(6, 0)),
                        Stop("B", Time(7, 34)),
                        Stop("C", Time(7, 44)),
                        Stop("D", Time(9, 0)),
                        Stop("E", Time(9, 4))
                    )
                ),
                Train(
                    "N2" , listOf(
                        Stop("A", Time(6, 18)),
                        Stop("E", Time(6, 45))
                    )
                )
            ), ttt1.trains()
        )

    }

    @Test
    @Tag("Normal")
    fun removeStop() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 48))))
        assertFalse(ttt.removeStop("N1", "Неверная"))
        assertFalse(ttt.removeStop("N1", "СПб"))
        assertFalse(ttt.removeStop("N1", "Пушкин"))
        assertTrue(ttt.removeStop("N1", "Купчино"))
    }

    @Test
    @Tag("Hard")
    fun trains() {
        val ttt = TrainTimeTable("СПб")
        assertTrue(ttt.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 6))))
        assertTrue(ttt.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt.addTrain("N3", Time(6, 42), Stop("Пушкин", Time(7, 10))))
        assertTrue(ttt.addTrain("N4", Time(6, 42), Stop("Пушкин", Time(7, 10))))
        assertTrue(ttt.addStop("N1", Stop("Купчино", Time(6, 52))))
        assertTrue(ttt.addStop("N2", Stop("Купчино", Time(6, 32))))
        assertTrue(ttt.addStop("N3", Stop("Купчино", Time(6, 49))))
        assertEquals(
            listOf(
                Train("N3", Stop("СПб", Time(6, 42)), Stop("Купчино", Time(6, 49)), Stop("Пушкин", Time(7, 10))),
                Train("N1", Stop("СПб", Time(6, 35)), Stop("Купчино", Time(6, 52)), Stop("Пушкин", Time(7, 6)))
            ), ttt.trains(Time(6, 30), "Купчино")
        )
        val ttt1 = TrainTimeTable("A")
        assertTrue(ttt1.addTrain("N1", Time(6, 35), Stop("E", Time(9, 4))))
        assertTrue(ttt1.addTrain("N2", Time(6, 18), Stop("E", Time(8, 45))))
        assertTrue(ttt1.addTrain("N3", Time(6, 35), Stop("T", Time(8, 49))))
        assertTrue(ttt1.addTrain("N4", Time(6, 18), Stop("E", Time(8, 11))))
        assertTrue(ttt1.addTrain("N5", Time(6, 8), Stop("E", Time(8, 1))))
        assertTrue(ttt1.addStop("N1", Stop("Y", Time(7, 34))))
        assertTrue(ttt1.addStop("N2", Stop("Y", Time(7, 36))))
        assertTrue(ttt1.addStop("N3", Stop("Y", Time(7, 59))))
        assertTrue(ttt1.addStop("N4", Stop("X", Time(7, 27))))
        assertTrue(ttt1.addStop("N5", Stop("Y", Time(7, 59))))
        assertEquals(
            listOf(
                Train("N1", Stop("A", Time(6, 35)), Stop("Y", Time(7, 34)), Stop("E", Time(9, 4))),
                Train("N2", Stop("A", Time(6, 18)), Stop("Y", Time(7, 36)), Stop("E", Time(8, 45))),
                Train("N3", Stop("A", Time(6, 35)), Stop("Y", Time(7, 59)), Stop("T", Time(8, 49)))
            ), ttt1.trains(Time(6, 15), "Y"))
    }

    @Test
    @Tag("Hard")
    fun testEquals() {
        val ttt1 = TrainTimeTable("СПб")
        assertTrue(ttt1.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt1.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt1.addStop("N2", Stop("Купчино", Time(6, 31))))
        assertTrue(ttt1.addStop("N2", Stop("Шушары", Time(6, 35))))
        val ttt2 = TrainTimeTable("СПб")
        assertTrue(ttt2.addTrain("N2", Time(6, 18), Stop("Пушкин", Time(6, 45))))
        assertTrue(ttt2.addTrain("N1", Time(6, 35), Stop("Пушкин", Time(7, 4))))
        assertTrue(ttt2.addStop("N2", Stop("Шушары", Time(6, 35))))
        assertTrue(ttt2.addStop("N2", Stop("Купчино", Time(6, 31))))
        assertTrue(ttt1 == ttt2)
        val ttt3 = TrainTimeTable("A")
        assertTrue(ttt3.addTrain("N1", Time(6, 35), Stop("E", Time(7, 4))))
        assertTrue(ttt3.addTrain("N2", Time(6, 18), Stop("E", Time(6, 45))))
        assertTrue(ttt3.addTrain("N3", Time(6, 35), Stop("E", Time(6, 45))))
        assertTrue(ttt3.removeTrain("N2"))
        assertFalse(ttt3.removeTrain("N2"))
        assertTrue(ttt3.addStop("N1", Stop("B", Time(6, 50))))
        assertFalse(ttt3.addStop("N1", Stop("B", Time(6, 39))))
        assertTrue(ttt3.addStop("N3", Stop("B", Time(6, 38))))
        val ttt4 = TrainTimeTable("A")
        assertTrue(ttt4.addTrain("N1", Time(6, 35), Stop("E", Time(7, 4))))
        assertTrue(ttt4.addTrain("N2", Time(6, 10), Stop("D", Time(6, 45))))
        assertTrue(ttt4.addTrain("N3", Time(6, 35), Stop("E", Time(6, 45))))
        assertTrue(ttt4.addTrain("N4", Time(6, 39), Stop("E", Time(6, 30))))
        assertTrue(ttt4.addStop("N1", Stop("B", Time(6, 39))))
        assertTrue(ttt4.addStop("N3", Stop("B", Time(6, 37))))
        assertThrows(IllegalArgumentException::class.java) {
            assertTrue(ttt4.addStop("N1", Stop("C", Time(7, 35))))
        }
        assertTrue( ttt3.trains() != ttt4.trains())
        assertTrue(ttt4.removeTrain("N4"))
        assertTrue(ttt3.addTrain("N2", Time(6, 10), Stop("D", Time(6, 45))))
        assertFalse(ttt4.addStop("N3", Stop("B", Time(6, 38))))
        assertEquals(ttt3.trains(), ttt4.trains())
    }
}
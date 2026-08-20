package com.example.engine

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.abs

class HydraulicsTest {
  @Test
  fun testManningAndHazenWilliams() {
    val pipe = Pipe(id = "T1", length = 100.0, diameter = 0.3, slope = 0.001, manningsN = 0.013, hwCoeff = 130.0)
    val (manningRes, hwRes) = Hydraulics.analyze(pipe)

    // Expected approximate values (from initial implementation)
    assertEquals(true, abs(manningRes.q - 0.0307) < 0.005)
    assertEquals(true, abs(hwRes.q - 0.0366) < 0.006)
  }
}

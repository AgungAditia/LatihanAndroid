package com.agungaditia.latihanandroid.unittest

class MyUnitTestViewModel(private val cuboidModel: CuboidModel) {
    fun getCircumFerence() = cuboidModel.getCircumference()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()
    fun getVolume() = cuboidModel.getVolume()

    fun save(
        w: Double, l: Double, h: Double
    ) {
        cuboidModel.save(w, l, h)
    }
}
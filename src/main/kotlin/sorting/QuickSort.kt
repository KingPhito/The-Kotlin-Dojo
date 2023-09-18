package sorting

object QuickSort {

    fun quickSort(array: Array<Int>): Array<Int> {
        if (array.size <= 1) return array

        val pivot = array[array.size/2]
        val smaller = array.filter { it < pivot }.toTypedArray()
        val larger = array.filter { it > pivot }.toTypedArray()

        return quickSort(smaller) + arrayOf(pivot) + quickSort(larger)
    }
}
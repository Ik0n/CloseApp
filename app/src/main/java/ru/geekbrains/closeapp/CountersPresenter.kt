package ru.geekbrains.closeapp

class CountersPresenter(private val view : MainView) {

    private val model = CountersModel()

    fun getCounters() = model.getCounters()

    fun onCounterClick(id: Int) {
        when(id) {
            FIRST_BUTTON -> {
                view.setText((model.next(id)).toString(), id)
            }
            SECOND_BUTTON -> {
                view.setText((model.next(id)).toString(), id)
            }
            THIRD_BUTTON -> {
                view.setText((model.next(id)).toString(), id)
            }
        }
    }

}
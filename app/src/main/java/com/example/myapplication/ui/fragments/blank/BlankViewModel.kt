package com.example.myapplication.ui.fragments.blank

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Model

class BlankViewModel : ViewModel() {

    private val list1: MutableLiveData<ArrayList<Model>> = MutableLiveData()

    fun getListOfCatHTP(): MutableLiveData<ArrayList<Model>> {

        val modelList:ArrayList<Model> = ArrayList()

        modelList.clear()
        modelList.add(
            Model(
                "https://static.detmir.st/media_out/494/929/4929494/450/0.jpg?1662437224508",
                " lost World"
            )
        )
        modelList.add(
            Model(
                "https://www.mann-ivanov-ferber.ru/assets/images/covers/37/21737/1.00x-thumb.png",
                "Дети капитана Гранта"
            )
        )
        modelList.add(
            Model(
                "https://www.storytel.com/images/640x640/0001156746.jpg",
                "самурай без меча"
            )
        )
        modelList.add(
            Model(
                "https://img4.labirint.ru/rc/fba9dddb9b67ef95831c7174b4c2eb8c/363x561q80/books16/150746/cover.jpg?1280394613",
                "Гарри Поттер и дары смерти"
            )
        )
        modelList.add(
            Model(
                "https://img4.labirint.ru/rc/c5593938783bcf5a3a3617ea89dbf73b/363x561q80/books46/459698/cover.jpg?1566211871",
                "Макс Фрай: чужак"
            )
        )
        modelList.add(
            Model(
                "https://cv9.litres.ru/pub/c/cover_200/48428994.jpg",
                "Ведьмин котел"
            )
        )
        list1.value = modelList
        return list1
    }
}
package uz.demo.dana.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.namoz_vaqti.ui.MainCategoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import uz.demo.dana.di.annotation.ViewModelKey

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainCategoryViewModel::class)
    fun mainCategoryViewModel(viewModel: MainCategoryViewModel) :ViewModel


}
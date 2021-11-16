package co.eventbox.event.di

import co.eventbox.event.viewModel.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Farshid Roohi.
 * TEDxTehran | Copyrights 11/16/21.
 */

val viewModelModule = module {

    viewModel {
        AboutViewModel()
    }

    viewModel {
        GalleryViewModel()
    }

    viewModel {
        HomeViewModel()
    }

    viewModel {
        NewsViewModel()
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        SpeakersViewModel()
    }

    viewModel {
        SplashViewModel()
    }

    viewModel {
        SponsorsViewModel()
    }

    viewModel {
        TimeScheduleViewModel()
    }

    viewModel {
        PhotosViewModel()
    }


}
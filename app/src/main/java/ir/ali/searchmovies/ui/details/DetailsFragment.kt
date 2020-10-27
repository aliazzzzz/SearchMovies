package ir.ali.searchmovies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.ali.searchmovies.R
import ir.ali.searchmovies.data.model.MovieDetails
import kotlinx.android.synthetic.main.details_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val viewModel : DetailsViewModel by viewModel()
        viewModel.API_KEY = resources.getString(R.string.api_key)
        viewModel.movieIdObs.onNext(args.movieID)

        viewModel
            .movieDetailsObs
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { refresh(it) }
    }

    private fun refresh(data: MovieDetails) {
        details_title.text = data.title
        details_year.text = data.year
        details_genres.text = data.genres
        details_overview.text = data.overview
    }

}
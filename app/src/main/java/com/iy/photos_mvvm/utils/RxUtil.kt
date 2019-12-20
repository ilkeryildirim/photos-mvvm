import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.workOnBackground(): Observable<T> =
        this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())

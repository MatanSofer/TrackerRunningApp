package com.matans.core.doamin.util


sealed interface Result<out D,out E:Error> {

    data class Success<out D>(val data: D): Result<D, Nothing>
    data class Error<out E: com.matans.core.doamin.util.Error>(val error: E): Result<Nothing, E>


}

//includes convert the types
inline fun <T,E: Error,R> Result<T, E>.map(map: (T) -> R):Result<R, E>{
    return when(this){
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

fun <T,E: Error> Result<T,E>.asEmptyDataResult(): EmptyResult<E>{
    return map {  }
}

//to give a type different name
typealias EmptyResult<E> = Result<Unit, E>
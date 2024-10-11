package com.akfc.training.com.akfc.training

sealed class Result {
    class Success(val data: String) : Result()
    class Error(val message: String) : Result()
    object Loading : Result()
}

fun handleResult(result: Result) = when (result) {
    is Result.Success -> println("Success: ${result.data}")
    is Result.Error -> println("Error: ${result.message}")
    is Result.Loading -> println("Loading...")
}

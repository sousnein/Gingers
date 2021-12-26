package ru.sousnein.features.login.presentation.create_account.domain

object GetPasswordEndIconClickableAfterCompare {

    operator fun invoke(compareError: Int?) = when (compareError == null) {
        true -> false
        false -> true
    }

}
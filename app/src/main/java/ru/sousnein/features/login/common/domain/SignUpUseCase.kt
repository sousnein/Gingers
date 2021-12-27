package ru.sousnein.features.login.common.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sousnein.features.login.data.IAuthRepository
import ru.sousnein.androidclient.type.UserModelInput
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
    private val signInUseCase: SignInUseCase
) {

    suspend operator fun invoke(email: String, password: String)  = withContext(Dispatchers.IO) {
        val userModelInput = UserModelInput(email = email, password = password, suspend = false).toInput()
        authRepository.signUp(userModelInput = userModelInput).let {
            signInUseCase.invoke(email = email, password = password)
        }
    }

}
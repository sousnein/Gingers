package ru.sousnein.features.login.common.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.sousnein.features.login.data.IAuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: IAuthRepository,
    private val userRepository: IUserRepository,
) {

    suspend operator fun invoke(email: String, password: String) = withContext(Dispatchers.IO) {
        val userId = UserIdInput(email = email).toInput()
        val authInput = AuthRequestInput(password = password, userId = userId).toInput()

        authRepository.signIn(authInput).let {
            val response = it.data?.signIn
            val user = response?.token?.user
            val userPrefs = userRepository.getUser().toBuilder()
            userPrefs.email = user?.email
            userPrefs.isSignedIn = true
            userPrefs.isBanned = user?.suspend ?: false
            userPrefs.userName = user?.username.orEmpty()
            userPrefs.id = user?.id?.toString()?.toLong() ?: -1
            userRepository.updateUserData(userPrefs.build())
        }
    }

}
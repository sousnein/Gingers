package ru.sousnein.features.login.data

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
): IAuthRepository {

//    override suspend fun signIn(authRequestInput: Input<AuthRequestInput>) = withContext(Dispatchers.IO) {
//        apolloClient.query(SignInQuery(authRequestInput)).await()
//    }
//
//    override suspend fun signUp(userModelInput: Input<UserModelInput>) = withContext(Dispatchers.IO) {
//        apolloClient.mutate(SignUpMutation(userModelInput)).await()
//    }

}
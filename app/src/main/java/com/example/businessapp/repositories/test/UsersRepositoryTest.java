package com.example.businessapp.repositories.test;

import com.example.businessapp.api.models.AuthenticateModel;
import com.example.businessapp.api.models.UsuarioJPS;
import com.example.businessapp.api.services.AuthenticationApiService;
import com.example.businessapp.api.services.ResultCallBacks;
import com.example.businessapp.api.services.UsersApiService;
import com.example.businessapp.repositories.UsersRepository;

import java.time.Instant;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UsersRepositoryTest extends UsersRepository {


    @Inject
    public UsersRepositoryTest(UsersApiService service, AuthenticationApiService authenticationApiService) {
        super(service, authenticationApiService);
    }

    @Override
    public void authenticar(AuthenticateModel authenticateModel, ResultCallBacks<UsuarioJPS> callBacks) {

        UsuarioJPS usuarioJPS = new UsuarioJPS(
                "id",
                authenticateModel.getUserName(),
                authenticateModel.getUserName(),
                authenticateModel.getUserName(),
                "TokenTokenToken",
                Date.from(Instant.now())
        );

        callBacks.onSuccess(usuarioJPS);

    }
}

package com.example.springdemo.service;

import com.example.springdemo.dto.Profile.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.RoleMappingResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class KeycloakService {
    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public void addUser(ProfileDto dto){
        String username = dto.getName().concat(".".concat(dto.getSurname()));
        CredentialRepresentation password = createPasswordCredential(dto.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setFirstName(dto.getName());
        user.setLastName(dto.getSurname());
        user.setCredentials(Collections.singletonList(password));
        user.setEmail(dto.getEmail());
        user.setEnabled(true);
        UsersResource userResource = getUserResource();
        userResource.create(user);
        addRealmRoleToUser(username, dto.getRole());
    }

    private void addRealmRoleToUser(String userName, String roleName) {
        RealmResource realmResource = keycloak.realm(realm);
        List<UserRepresentation> users = realmResource.users().search(userName);
        UserResource userResource = realmResource.users().get(users.get(0).getId());
        RoleRepresentation role = realmResource.roles().get(roleName).toRepresentation();
        RoleMappingResource roleMappingResource = userResource.roles();
        roleMappingResource.realmLevel().add(Collections.singletonList(role));
    }

    private UsersResource getUserResource(){
        return keycloak.realm(realm).users();
    }

    private static CredentialRepresentation  createPasswordCredential(String password) {
        CredentialRepresentation cred = new CredentialRepresentation();
        cred.setType(CredentialRepresentation.PASSWORD);
        cred.setValue(password);
        cred.setTemporary(false);
        return cred;
    }
}

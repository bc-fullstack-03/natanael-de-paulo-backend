package io.github.natanaeldepaulo.api.application.models.user;

import io.github.natanaeldepaulo.api.domain.embedded.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {
    private UUID id;
    private String email;
    private Profile profile;
}

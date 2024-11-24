package com.tecnocampus.agile.users.model;

import com.mongodb.lang.Nullable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    @MongoId()
    private String id;

    @NonNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String username;

    @NonNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    @NonNull
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Nullable
    @Schema(requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String avatar;

    public User() {

    }

}

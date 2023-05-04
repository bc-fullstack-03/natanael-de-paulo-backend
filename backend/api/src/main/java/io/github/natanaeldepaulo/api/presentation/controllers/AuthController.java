package io.github.natanaeldepaulo.api.presentation.controllers;

import io.github.natanaeldepaulo.api.application.IAuthService;
import io.github.natanaeldepaulo.api.application.specification.AuthRequest;
import io.github.natanaeldepaulo.api.application.specification.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/auth")
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest request) {
        var response = authService.auth(request);
        return ResponseEntity.ok().body(response);
    }
}
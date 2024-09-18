package com.darkquantum.xiaomistore.user.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.user.model.UserInfoModify;
import com.darkquantum.xiaomistore.user.service.UserService;
import com.darkquantum.xiaomistore.user.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Value("${jwt.secret.key}")
    private String jwtSecretKey;
    @Value("${file.base-path}")
    private String base;
    private static final PasswordEncryptor encryptor = new StrongPasswordEncryptor();

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> user) {
        if (user.get("id") == null || user.get("password") == null || user.get("id").isEmpty() || user.get("password").isEmpty()) {
            return Map.of("status", 1);
        }
        if (!encryptor.checkPassword(user.get("password"), userService.getPasswordByUsername(user.get("id")))) {
            return Map.of("status", 1);
        }
        User result = userService.getUserByUsername(user.get("id"));
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 0);
        map.put("token", JwtUtils.encode(result.getUsername(), Map.of("nickname", result.getNickname()), jwtSecretKey));
        map.put("name", result.getNickname());
        return map;
    }

    @PostMapping("/verify")
    public Map<String, Object> verify(HttpServletRequest request) {
        if (request.getHeader("Authorization") == null) {
            return Map.of("ok", false);
        }
        String token = request.getHeader("Authorization");
        try {
            DecodedJWT decodedJWT = JwtUtils.decode(token, jwtSecretKey);
            return Map.of("ok", true, "data", Map.of(
                    "id", decodedJWT.getAudience().getFirst(),
                    "iat", decodedJWT.getIssuedAt().getTime(),
                    "exp", decodedJWT.getExpiresAt().getTime(),
                    "name", decodedJWT.getClaim("nickname").asString()));
        } catch (Exception e) {
            return Map.of("ok", false);
        }
    }

    @GetMapping("/info")
    public Map<String, Object> info(String id) {
        User user = userService.getUserByUsername(id);
        return Map.of("uid", user.getUsername(), "uname", user.getNickname(), "default_addr", user.getAddress(),
                "default_phone", user.getPhone(), "gender", user.getSex(), "avatar_path", user.getAvatar(),
                "realname", user.getRealName());
    }

    @PostMapping("/info")
    public Map<String, Object> info(@RequestBody UserInfoModify modify) {
        String filePath = null;
        if(modify.getAvatar_path().startsWith("data:"))
        {
            byte[] buffer = Base64.getDecoder().decode(modify.getAvatar_path().split(",")[1]);
            filePath = "images/users/" + System.currentTimeMillis() + ".jpg";
            try(FileOutputStream out = new FileOutputStream(base + filePath)) {
                out.write(buffer);
            }catch (Exception ignored){}
        }
        if(filePath != null)
        {
            modify.setAvatar_path("/api/" + filePath);
        }
        if(userService.modifyUser(modify))
        {
            modify.setUid(modify.getId());
            return Map.of("ok", true, "body", modify);
        }else {
            return Map.of("ok", false);
        }
    }

}

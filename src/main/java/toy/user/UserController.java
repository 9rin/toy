package toy.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = {
        "https://twitter-clone-tawny-phi.vercel.app", // 배포 기본 도메인
        "http://localhost:5173" // 개발용
})

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 사용자 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("userId") Long userId){
        UserResponseDto dto = userService.getUser(userId);
        return ResponseEntity.ok(dto);
    }
}

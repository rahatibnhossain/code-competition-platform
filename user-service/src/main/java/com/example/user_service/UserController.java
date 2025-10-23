package com.example.user_service;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<UserProfile> getProfile(@RequestHeader("X-User-Id") String userId) {
        // Get user profile
        return ResponseEntity.ok(userProfile);
    }

    @PreAuthorize("hasRole('admin')")
    @GetMapping("/admin/all")
    public ResponseEntity<List<User>> getAllUsers() {
        // Admin only endpoint
        return ResponseEntity.ok(users);
    }
}

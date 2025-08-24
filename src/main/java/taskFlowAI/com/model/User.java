package taskFlowAI.com.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import taskFlowAI.com.enums.UserRole;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dob;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false, length = 15)
    private String phoneNumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(name = "user_role", nullable = false)
    private UserRole userRole = UserRole.USER;
}

package bg.softuni.spring.fundamentals.mobileLeLe.models.entities;

import bg.softuni.spring.fundamentals.mobileLeLe.models.entities.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Role name;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getName() {
        return name;
    }

    public void setName(Role name) {
        this.name = name;
    }
}

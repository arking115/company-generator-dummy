package com.example.company_dummy_backend.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String contact;
    @Column(unique = true)
    private String APIKey;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> userList;

    public void addUser(User user) {
        userList.add(user);
        user.setCompany(this);
    }

    public void removeUser(User user) {
        userList.remove(user);
        user.setCompany(null);
    }
}

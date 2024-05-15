package org.studypro.SpringBlog.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long accountId;
    
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String role;

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
        name="account_authority",
        joinColumns = {@JoinColumn(name="account_id", referencedColumnName = "accountId")},
        inverseJoinColumns = 
        {@JoinColumn(name="authority_id", referencedColumnName = "authorityId")}
    )
    private Set<Authority> authorities = new HashSet<>();
}
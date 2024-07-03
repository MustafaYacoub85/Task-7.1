package web.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "user1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @NonNull
    @Column(name = "firstname")
    String firstname;
    @NonNull
    @Column(name = "lastname")
    String lastname;
    @NonNull
    @Column(name = "age")
    int age;
    @NonNull
    @Column(name = "email")
    String email;

}

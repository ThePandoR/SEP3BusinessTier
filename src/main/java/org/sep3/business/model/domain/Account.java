package org.sep3.business.model.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Account {
    public enum AccountType{

        CUSTOMER,DJ,BARTENDER;
    }

    @Id
    @GeneratedValue
    private Long id;

    @NonNull private String username;
    @NonNull private String password;
    @NonNull private AccountType type;
}

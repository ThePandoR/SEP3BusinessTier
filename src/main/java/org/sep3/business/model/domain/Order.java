package org.sep3.business.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ordr")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

    public enum Status {
        NEW, INPROGRESS, DONE
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NonNull private Account owner;
    @NonNull private Status status;
    @ManyToMany
    @NonNull private List<Product>ordered;


}

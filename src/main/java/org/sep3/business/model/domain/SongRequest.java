package org.sep3.business.model.domain;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongRequest {

    private Long id;
    @NonNull private String title;
    private int votes;

    public int vote(){

        return ++votes;
    }
}


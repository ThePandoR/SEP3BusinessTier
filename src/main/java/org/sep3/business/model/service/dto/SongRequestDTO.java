package org.sep3.business.model.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongRequestDTO {

    private Long id;
    private String title;
    private int votes;

}

package org.apache.dubbo.demo.dto;


import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String address;
}

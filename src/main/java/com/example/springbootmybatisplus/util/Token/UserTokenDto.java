package com.example.springbootmybatisplus.util.Token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hjh
 * @version 1.0
 * @date 2019/10/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserTokenDto {

    private Long id;

    private Integer type;

    private Long departmentId;
}

package com.cc.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by changc on 2019/3/6.
 */
@Data
@Entity(name = "tb_student")
public class Student {
    @Id
    //用于标注主键的生成策略
    @GeneratedValue
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 32)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 3)
    private Integer age;
/*    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date sj1;*/
}

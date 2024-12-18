package com.hj1000.todo.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 어플리케이션 환경설정용 클래스
    //여기서 작성한 메서드는 시스템에 등록 @bean

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper(); // 자동으로 modelmapper 생성
    }
}

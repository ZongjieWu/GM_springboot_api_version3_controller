package com.example.springbootmybatisplus.GeneralCode;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

import static io.github.swagger2markup.markup.builder.MarkupLanguage.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class GneratorSwaggerPdfAndHtml {
    @Test
    public void generateAsciiDocs() throws Exception {
// 输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withMarkupLanguage(ASCIIDOC)
                .build();
        Swagger2MarkupConverter.from(new URL("http://localhost:8083/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFolder(Paths.get("docs/asciidoc/generated"));
    }
}

package com.helloWorld.helloWorld.response;

import com.github.pagehelper.PageInfo;
import com.helloWorld.helloWorld.common.StringUtils;
import com.helloWorld.helloWorld.common.constant.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Schema(title = "Return Entity object")
public class ResponseBase<T> {

    @Schema(title = "Business Status Code",
            description = "200=success, 401=login exception, other=business exception")
    private int code;

    @Schema(title = "Prompt message")
    private String msg;

    @Schema(title = "Business Data")
    private T data;

    @Schema(title = "Total number of items")
    private Long total;

    @Schema(title = "Is there a next page")
    private Boolean hasNext = false;

    @Schema(title = "Other data")
    private String otherData;

    public ResponseBase(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseBase(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        if (StringUtils.isNotNull(data)) {
            this.data = data;
        }
    }
    public static <T> ResponseBase<T> ok( final String msg ) {
        return new ResponseBase<>( HttpStatus.SUCCESS, msg );
    }
    public static <T> ResponseBase<T> ok() {
        return ResponseBase.ok( "Success" );
    }

}

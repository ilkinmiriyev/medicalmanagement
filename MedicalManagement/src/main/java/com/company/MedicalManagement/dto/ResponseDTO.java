package com.company.MedicalManagement.dto;

public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object object;

    public ResponseDTO(){
    }

    public static ResponseDTO of (String successMessage, Object object){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.successMessage=successMessage;
        responseDTO.object=object;
        return responseDTO;
    }

    public static ResponseDTO of (String errorMessage, Integer errorCode, Object object){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.errorMessage=errorMessage;
        responseDTO.object=object;
        responseDTO.errorCode=errorCode;
        return responseDTO;
    }

    public static ResponseDTO of(Object object){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.object=object;
        return responseDTO;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

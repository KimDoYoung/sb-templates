# sbtemplates

### 작업
1. error.jsp를 넣음
2. AssetEduControllerAdvice를 작성
	* AssetEduException과. AssetEduJsonException 2가지를 작성
	* AssetEduException일 경우 error.jsp로 
	* AssetEduJsonException일 경우 json형태로 보내게끔 함.
3. JsonView를 사용하여 json형태로 보냄.	

### Keywords
* 

### 기타 

* ResponseEntityExceptionHandler상속받아서 만드는 경우
```java
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
...
}
```
> 주의할 점은, 프로젝트에 하나의 @ControllerAdvice만 관리하는 것을 권장합니다. 
> 여러 개를 사용하려면,  basePackageClasses 및 basePackages와 같은 Selector를 사용해야하기 때문입니다. 

```
  @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex, HandlerMethod handlerMethod, HttpServletRequest request) throws JsonProcessingException {
        Class ControllerName = handlerMethod.getMethod().getDeclaringClass();
        String MethodName = handlerMethod.getMethod().getName();
        ErrorResponse error = new ErrorResponse();

        error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setErrorMessage(ex.getMessage());
        error.setControllerName(ControllerName.toString());
        error.setServiceName(MethodName.toString());
        error.setTimeStamp(sdf.format(System.currentTimeMillis()));
        error.setProjectName(applicationName);
        error.setServicePath(request.getRequestURL().toString());
        PutLogEvents(error);

        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }
AssetEduControllerAdvice
```
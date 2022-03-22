package az.unitech.deveopment.auth.error;

public enum ErrorCodes implements ErrorCode {

   UNSUPPORTED_CONVERT;

    @Override
    public String code() {
        return this.name();
    }

}
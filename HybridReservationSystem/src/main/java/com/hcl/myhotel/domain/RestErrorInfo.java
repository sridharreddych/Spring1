package com.hcl.myhotel.domain;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Sridhar reddy
 * Generice Error Informatin class
 */
@XmlRootElement
public class RestErrorInfo {
    public final String detail;
    public final String message;

    public RestErrorInfo(Exception ex, String detail) {
        this.message = ex.getLocalizedMessage();
        this.detail = detail;
    }
}

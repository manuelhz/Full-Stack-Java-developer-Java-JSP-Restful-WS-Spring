package org.studypro.SpringBlog.util.email;

import lombok.Data;

@Data
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
}

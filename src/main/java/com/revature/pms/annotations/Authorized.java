package com.revature.pms.annotations;

import com.revature.pms.model.Role;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface Authorized {
    public Role[] allowedRoles() default{};
}
